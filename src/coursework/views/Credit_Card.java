package coursework.views;

import coursework.BankCard;
import coursework.CreditCard;
import coursework.components.MyCustomButton;
import coursework.components.MyCustomLabel;
import coursework.components.MyCustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Credit_Card extends JFrame {
    //to provide a consistent look and feel to the application.
    MyCustomLabel setLimitLabelForSet,cardIdLabelForSet, newGracePeriodLabelForSet, newCreditLimitLabelForSet,cancelCreditCardLabelForCancel, id2LabelForCancel;
    MyCustomTextField cardIdTfForSet, newGracePeriodTfForSet, newCreditLimitTfForCancel, id2TfForCancel;
    MyCustomButton setBtnForSet,cancelCreditCardBtnForCancel,clearBtnForSet,displayBtnForSet,backBtnForSet;



    public Credit_Card(ArrayList<BankCard>bankCards){// a constructor that takes an ArrayList of BankCard objects as an argument.
        JFrame set_CancelCreditCard = new JFrame("Set/Cancel Credit Card");//creating frame
        set_CancelCreditCard.setVisible(true);//to make visible
        set_CancelCreditCard.setSize(600,700);//to edit the size as per need
        set_CancelCreditCard.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// to hide the window when it is closed
        set_CancelCreditCard.setLocationRelativeTo(null);
        set_CancelCreditCard.setResizable(true);//to resize
        set_CancelCreditCard.setLayout(new GridLayout(2,1));


        JPanel CreditCardPanel = new JPanel();//creating JPanel with title bordered for setting new credit Limit
        CreditCardPanel.setLayout(new GridBagLayout());

        JPanel CancelCreditCardPanel = new JPanel();//creating another JPanel for cancelCreditCard
        CancelCreditCardPanel.setLayout(new GridBagLayout());

        cardIdTfForSet = new MyCustomTextField("");
        newGracePeriodTfForSet = new MyCustomTextField("");
        newCreditLimitTfForCancel = new MyCustomTextField("");
        id2TfForCancel = new MyCustomTextField("");

        setLimitLabelForSet = new MyCustomLabel("Set Credit Limit");
        cardIdLabelForSet = new MyCustomLabel("Card Id:");
        newGracePeriodLabelForSet= new MyCustomLabel("New Grace Limit:");
        newCreditLimitLabelForSet = new MyCustomLabel("New Credit Limit:");
        cancelCreditCardLabelForCancel = new MyCustomLabel("Cancel Credit Card");
        id2LabelForCancel = new MyCustomLabel("Card Id:");


        setBtnForSet = new MyCustomButton("Set Limit");
        cancelCreditCardBtnForCancel = new MyCustomButton("Cancel Credit Card");
        clearBtnForSet = new MyCustomButton("Clear");
        displayBtnForSet = new MyCustomButton("Display");
        backBtnForSet = new MyCustomButton("Back");



//The addActionListener() method is used to add functionality to the buttons by creating instances of other classes defined in the project.
        setBtnForSet.addActionListener(e -> { // sets the credit limit of the card
            // exception handling is done to avoid crashes
            try {
                String cardId = cardIdTfForSet.getText();
                String creditLimit = newCreditLimitTfForCancel.getText();
                String gracePeriod = newGracePeriodTfForSet.getText();

                // It checks the array list is empty or not
                if (bankCards.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Kindly link your credit card to your Bank account first");
                } else if (cardId.isEmpty() || creditLimit.isEmpty() || gracePeriod.isEmpty()) { // It checks the text field is empty or not
                    JOptionPane.showMessageDialog(null, "Please complete all sections of the form");
                } else {
                    int cardId1 = Integer.parseInt(cardId);
                    double newCreditLimit = Double.parseDouble(creditLimit); // converts a String value to double
                    int newGracePeriod = Integer.parseInt(gracePeriod); // converts a String value to int
                    boolean obtainedCard = false;
                    CreditCard creditCard = null; // initializes a CreditCard object reference variable creditCard to null.

                    // starts a loop that iterates over each BankCard object in the bankCards ArrayList, assigning each object to a temporary reference variable bankCard2.
                    for (BankCard bankCard2 : bankCards) {
                        // It is used to downcast to access the object of bankcard
                        if (bankCard2 instanceof CreditCard) {
                            creditCard = (CreditCard) bankCard2;

                            // It checks whether the card id matches the card id of the ArrayList
                            if (creditCard.getCardId() == cardId1) {
                                obtainedCard = true;
                                break; // exits the loop early once a matching credit card is found
                            }
                        }
                    }

                    if (obtainedCard) {
                        // It will call the method to set credit limit
                        setCreditLimit(creditCard, newCreditLimit, newGracePeriod);
                        // It is used to update bankCards array with new credit card object
                        bankCards.set(bankCards.indexOf(creditCard), creditCard);
                    } else { // It will pop up when the user inputs the wrong ID
                        JOptionPane.showMessageDialog(null, "Please enter the accurate Card ID");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please complete the fields in the correct sequence");
            }
        });




        //cancels a credit card
        cancelCreditCardBtnForCancel.addActionListener(e -> {
            //exception handling is done to avoid from crashes
            try {
                String cardId = id2TfForCancel.getText();
                //It checks the array list is empty or not
                if (bankCards.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Kindly link your credit card to your Bank account first");
                } else if (cardId.isEmpty()){ //It checks the text field is empty or not
                    JOptionPane.showMessageDialog(null,"Please complete all sections of the form");
                } else {
                        int cardId2 = Integer.parseInt(cardId);//converts a String value to int
                        boolean obtainedCardId = false;
                        CreditCard creditCard = null;//initializes a CreditCard object reference variable creditCard to null.

                    //starts a loop that iterates over each BankCard object in the bankCards ArrayList, assigning each object to a temporary reference variable bankCard2.
                        for (BankCard bankCard2 : bankCards){
                            //It is used to downcast to access the object of bankcard
                            if (bankCard2 instanceof  CreditCard){
                                creditCard = (CreditCard) bankCard2;
                                //It checks whether the card id matches the card id of arraylist
                                if (creditCard.getCardId() == cardId2){
                                    obtainedCardId = true;
                                    break;

                                }
                            }
                        }
                        if (obtainedCardId){
                            //It will call the method from credit card
                            cancelCreditCard(creditCard);
                            //It is used to update bankCards array with new credit card object
                            bankCards.set(bankCards.indexOf(creditCard),creditCard);
                        } else {//It will pop up when the user input wrong ID
                            JOptionPane.showMessageDialog(null,"Please enter the accurate Card ID");
                        }
                }
                //If an exception is occurred it will catch and display a message
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Please input valid information");
            }

                });




        //clears the input fields
        clearBtnForSet.addActionListener(e -> {
            clear();
        });

        //displays all the credit cards
        displayBtnForSet.addActionListener(e -> {
            new DisplayCreditCards(bankCards);

        });


        //closes the current window.
        backBtnForSet.addActionListener(e -> {
            set_CancelCreditCard.setVisible(false);

                });

        //provides a flexible and powerful way of organizing components in a grid.
        GridBagLayout gblCreditCard = new GridBagLayout();// to add the components to the window in a specific layout.
        GridBagConstraints gbcCreditCard = new GridBagConstraints();//to define the constraints for each component
        CreditCardPanel.setLayout(gblCreditCard);
        CancelCreditCardPanel.setLayout(gblCreditCard);


        //Adding the setLimitLabel
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 0;//sets the row position of the component
        gbcCreditCard.gridwidth = 2;// the component will span 2 column in the grid.
        gbcCreditCard.insets = new Insets(10,10,50,0);// Adding  some whitespace(padding)
        CreditCardPanel.add(setLimitLabelForSet, gbcCreditCard);

        //Adding the cardIdLabel
        gbcCreditCard.gridx = 1;//sets the column position of the component
        gbcCreditCard.gridy = 1;//sets the row position of the component
        gbcCreditCard.insets = new Insets(10,10,10,0);// Adding  some whitespace(padding)
        CreditCardPanel.add(cardIdLabelForSet, gbcCreditCard);

        //Adding the cardIdTf
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 1;//sets the row position of the component
        gbcCreditCard.insets = new Insets(0,10,10,0);// Adding  some whitespace(padding)
        CreditCardPanel.add(cardIdTfForSet, gbcCreditCard);

        //Adding the newGracePeriodLabel
        gbcCreditCard.gridx = 1;//sets the column position of the component
        gbcCreditCard.gridy = 2;//sets the row position of the component
        gbcCreditCard.insets = new Insets(0,10,10,0);// Adding  some whitespace(padding)
        CreditCardPanel.add(newGracePeriodLabelForSet, gbcCreditCard);

        //Adding the newGracePeriodTf
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 2;//sets the row position of the component
        gbcCreditCard.insets = new Insets(0,10,0,0);// Adding  some whitespace(padding)
        CreditCardPanel.add(newGracePeriodTfForSet, gbcCreditCard);

        //Adding the newCreditLimitLabel
        gbcCreditCard.gridx = 1;//sets the column position of the component
        gbcCreditCard.gridy = 3;//sets the row position of the component
        gbcCreditCard.insets = new Insets(0,10,0,0);// Adding  some whitespace(padding)
        CreditCardPanel.add(newCreditLimitLabelForSet, gbcCreditCard);

        //Adding the newCreditLimitTf
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 3;//sets the row position of the component
        gbcCreditCard.insets = new Insets(10,10,10,0);// Adding  some whitespace(padding)
        CreditCardPanel.add(newCreditLimitTfForCancel, gbcCreditCard);

        //Adding the setBtn
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 4;//sets the row position of the component
        gbcCreditCard.gridwidth = 2;// the component will span 2 column in the grid.
        gbcCreditCard.insets = new Insets(10,10,10,0);// Adding  some whitespace(padding)
        CreditCardPanel.add(setBtnForSet, gbcCreditCard);

        //Adding the cancelCreditCardLabel
        gbcCreditCard.gridx = 1;//sets the column position of the component
        gbcCreditCard.gridy = 0;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        gbcCreditCard.insets = new Insets(10,10,50,10);// Adding  some whitespace(padding)
        CancelCreditCardPanel.add(cancelCreditCardLabelForCancel, gbcCreditCard);

        //Adding the id2Label
        gbcCreditCard.gridx = 0;//sets the column position of the component
        gbcCreditCard.gridy = 1;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        gbcCreditCard.insets = new Insets(10,170,10,10);// Adding  some whitespace(padding)
        CancelCreditCardPanel.add(id2LabelForCancel, gbcCreditCard);

        //Adding the id2Tf
        gbcCreditCard.gridx = 1;//sets the column position of the component
        gbcCreditCard.gridy = 1;//sets the row position of the component
        gbcCreditCard.insets = new Insets(10,10,10,10);// Adding  some whitespace(padding)
        CancelCreditCardPanel.add(id2TfForCancel, gbcCreditCard);



        //Adding the cancelCreditCardBtn
        gbcCreditCard.gridx = 1;//sets the column position of the component
        gbcCreditCard.gridy = 2;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        gbcCreditCard.insets = new Insets(10,10,30,10);// Adding  some whitespace(padding)
        CancelCreditCardPanel.add(cancelCreditCardBtnForCancel, gbcCreditCard);

        //Adding the clearBtn
        gbcCreditCard.gridx = 0;//sets the column position of the component
        gbcCreditCard.gridy = 3;//sets the row position of the component
        gbcCreditCard.insets = new Insets(10,170,10,10);// Adding  some whitespace(padding)
        CancelCreditCardPanel.add(clearBtnForSet, gbcCreditCard);

        //Adding the displayBtn
        gbcCreditCard.gridx = 1;//sets the column position of the component
        gbcCreditCard.gridy = 3;//sets the row position of the component
        gbcCreditCard.insets = new Insets(10,10,10,10);// Adding  some whitespace(padding)
        CancelCreditCardPanel.add(displayBtnForSet, gbcCreditCard);


        //Adding the backBtn
        gbcCreditCard.gridx = 2;//sets the column position of the component
        gbcCreditCard.gridy = 3;//sets the row position of the component
        gbcCreditCard.insets = new Insets(10,10,10,10);// Adding  some whitespace(padding)
        CancelCreditCardPanel.add(backBtnForSet, gbcCreditCard);


        set_CancelCreditCard.add(CreditCardPanel);
        set_CancelCreditCard.add(CancelCreditCardPanel);

    }


    //clears the input fields
    public void clear(){
        cardIdTfForSet.setText("");
        newCreditLimitTfForCancel.setText("");
        newGracePeriodTfForSet.setText("");
        id2TfForCancel.setText("");
    }

    //this is a method it ensures that the credit limit is set within reasonable bounds and provides user feedback using dialog boxes.
    public void setCreditLimit(CreditCard creditCard, double newCreditLimit, int newGracePeriod){
        if (newCreditLimit >= 2.5 * creditCard.getBalanceAmount()){
            JOptionPane.showMessageDialog(null,"Your credit limit cannot be more than 2.5 times the balance amount");
        }else {
            creditCard.setCreditLimit(newCreditLimit, newGracePeriod);
            JOptionPane.showMessageDialog(null,"Your credit limit has been set");
            clear();
        }
    }


    //this is a method to clear any fields or inputs that were used during the cancellation process.
    public void cancelCreditCard(CreditCard creditCard){
        creditCard.cancelCreditCard();
        JOptionPane.showMessageDialog(null,"Your credit card has been cancelled");
        clear();
    }
}
