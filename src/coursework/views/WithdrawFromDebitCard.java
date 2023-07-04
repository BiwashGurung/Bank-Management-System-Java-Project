package coursework.views;

import coursework.DebitCard;
import coursework.BankCard;
import coursework.components.MyCustomButton;
import coursework.components.MyCustomLabel;
import coursework.components.MyCustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WithdrawFromDebitCard extends JFrame {

    MyCustomLabel popUpLabelForWithDraw, pinLabelForWithDraw, cardIdLabelForWithDraw, withdrawalAmtLabelForWithDraw, dateLabelForWithDraw;
    MyCustomTextField cardIdTfForWithDraw, pinTfForWithDraw, withdrawalAmtTfForWithDraw;
    JComboBox yearsWDForWithDraw, monthsWDForWithDraw, daysWDForWithDraw;
    MyCustomButton withdrawBtnForWithDraw, clearBtnForWithDraw, backBtnForWithDraw, displayBtnForWithDraw;


    public WithdrawFromDebitCard(ArrayList<BankCard> bankCards) {// a constructor that takes an ArrayList of BankCard objects as an argument.
        JFrame withdraw = new JFrame("Withdraw from Debit Card");//creating a JFrame
        withdraw.setSize(700, 800);// to customize the size as per need
        withdraw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// to hide the window when it is closed
        withdraw.setLocationRelativeTo(null);//location
        withdraw.setResizable(true);//to set the size
        withdraw.setVisible(true);// to make frame visible

        JPanel withdrawPanel = new JPanel();//Creating new panel
        withdrawPanel.setLayout(new GridBagLayout());

        //Creating JLabel for Withdraw
        popUpLabelForWithDraw = new MyCustomLabel("Please fill up the form below");
        pinLabelForWithDraw = new MyCustomLabel("PIN Number:");
        cardIdLabelForWithDraw = new MyCustomLabel("Card Id:");
        withdrawalAmtLabelForWithDraw = new MyCustomLabel("Withdrawal Amount:");
        dateLabelForWithDraw = new MyCustomLabel("Date of Withdrawal:");


        //Creating JTextField for Withdraw
        pinTfForWithDraw = new MyCustomTextField("");
        cardIdTfForWithDraw = new MyCustomTextField("");
        withdrawalAmtTfForWithDraw = new MyCustomTextField("");

        //Creating JButton for Withdraw
        withdrawBtnForWithDraw = new MyCustomButton("Withdraw");
        clearBtnForWithDraw = new MyCustomButton("Clear");
        backBtnForWithDraw = new MyCustomButton("Back");
        displayBtnForWithDraw = new MyCustomButton("Display");



        //These are the dates
        String years[] = {"Select Year", "2020", "2021","2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
        String months[] = {"Select Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String days[] = {"Select Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
                "27", "28", "29", "30", "31"};


        //Creating JComboBox for adding dates
        yearsWDForWithDraw = new JComboBox<>(years);
        monthsWDForWithDraw = new JComboBox<>(months);
        daysWDForWithDraw = new JComboBox<>(days);


        //provides a flexible and powerful way of organizing components in a grid.
        GridBagLayout gblWithdraw = new GridBagLayout();//to add the components to the window in a specific layout.
        GridBagConstraints gbcWithdraw = new GridBagConstraints();//to define the constraints for each component
        withdrawPanel.setLayout(gblWithdraw);

        //Adding the popUpLabel
        gbcWithdraw.gridx = 3;//sets the column position of the component
        gbcWithdraw.gridy = 0;//sets the row position of the component
        gbcWithdraw.gridwidth = 3;// the component will span 1 column in the grid.
        gbcWithdraw.insets = new Insets(10, 10, 110, 10);// Adding  some whitespace(padding)
        gbcWithdraw.fill = GridBagConstraints.HORIZONTAL;//specifies that the component should be resized horizontally to fill its grid cell.
        gbcWithdraw.anchor = GridBagConstraints.CENTER;//specifies that the component should be centered horizontally and vertically within its grid cell.
        withdrawPanel.add(popUpLabelForWithDraw, gbcWithdraw);

        //Adding the pinLabel
        gbcWithdraw.gridx = 2;//sets the column position of the component
        gbcWithdraw.gridy = 1;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        gbcWithdraw.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        withdrawPanel.add(pinLabelForWithDraw, gbcWithdraw);

        //Adding the pinTf
        gbcWithdraw.gridx = 3;//sets the column position of the component
        gbcWithdraw.gridy = 1;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        gbcWithdraw.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        withdrawPanel.add(pinTfForWithDraw, gbcWithdraw);

        //Adding the cardIdLabel
        gbcWithdraw.gridx = 3;//sets the column position of the component
        gbcWithdraw.gridy = 2;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(cardIdLabelForWithDraw, gbcWithdraw);

        //Adding the cardIdTf
        gbcWithdraw.gridx = 4;//sets the column position of the component
        gbcWithdraw.gridy = 2;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(cardIdTfForWithDraw, gbcWithdraw);

        //Adding the withdrawalAmtLabel
        gbcWithdraw.gridx = 3;//sets the column position of the component
        gbcWithdraw.gridy = 3;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(withdrawalAmtLabelForWithDraw, gbcWithdraw);

        //Adding the withdrawalAmtTf
        gbcWithdraw.gridx = 4;//sets the column position of the component
        gbcWithdraw.gridy = 3;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(withdrawalAmtTfForWithDraw, gbcWithdraw);

        //Adding the dateLabel
        gbcWithdraw.gridx = 3;//sets the column position of the component
        gbcWithdraw.gridy = 4;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(dateLabelForWithDraw, gbcWithdraw);

        //Adding the yearsWD
        gbcWithdraw.gridx = 4;//sets the column position of the component
        gbcWithdraw.gridy = 4;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(yearsWDForWithDraw, gbcWithdraw);

        //Adding the monthsWD
        gbcWithdraw.gridx = 4;//sets the column position of the component
        gbcWithdraw.gridy = 5;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(monthsWDForWithDraw, gbcWithdraw);

        //Adding the daysWD
        gbcWithdraw.gridx = 4;//sets the column position of the component
        gbcWithdraw.gridy = 6;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(daysWDForWithDraw, gbcWithdraw);


        //Adding the clearBtn
        gbcWithdraw.gridx = 2;//sets the column position of the component
        gbcWithdraw.gridy = 7;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(clearBtnForWithDraw, gbcWithdraw);

        //Adding the withdrawBtn
        gbcWithdraw.gridx = 3;//sets the column position of the component
        gbcWithdraw.gridy = 7;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(withdrawBtnForWithDraw, gbcWithdraw);

        //Adding the backBtn
        gbcWithdraw.gridx = 4;//sets the column position of the component
        gbcWithdraw.gridy = 7;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(backBtnForWithDraw, gbcWithdraw);

        //Adding the displayBtn
        gbcWithdraw.gridx = 3;//sets the column position of the component
        gbcWithdraw.gridy = 8;//sets the row position of the component
        gbcWithdraw.gridwidth = 1;// the component will span 1 column in the grid.
        withdrawPanel.add(displayBtnForWithDraw, gbcWithdraw);

        withdraw.add(withdrawPanel);


        //The addActionListener() method is used to add functionality to the buttons by creating instances of other classes defined in the project.
        clearBtnForWithDraw.addActionListener(e -> {
            clear();
        });

        displayBtnForWithDraw.addActionListener(e -> {
            new DisplayDebitCards(bankCards);
        });


        backBtnForWithDraw.addActionListener(e -> {
            withdraw.setVisible(false);
        });

        withdrawBtnForWithDraw.addActionListener(e -> {
            //exception handling is done to avoid from crashes
            try {
                String cardId1 = cardIdTfForWithDraw.getText();
                String withdrawal1 = withdrawalAmtTfForWithDraw.getText();
                String pinNumber = pinTfForWithDraw.getText();
                String dateOfWithdrawal = days[daysWDForWithDraw.getSelectedIndex()] + "-" + months[monthsWDForWithDraw.getSelectedIndex()] + "-" + years[yearsWDForWithDraw.getSelectedIndex()];

                //It checks the array list is empty or not
                if (bankCards.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Kindly link your debit card to your Bank account first");
                    //It checks the text field is empty or not
                } else if (cardId1.isEmpty() || withdrawal1.isEmpty() || pinNumber.isEmpty() || daysWDForWithDraw.getSelectedIndex() == 0 || monthsWDForWithDraw.getSelectedIndex() == 0 || yearsWDForWithDraw.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Please complete all sections of the form");
                } else {
                    //it will change the string values from text fields  double and int
                    int cardId = Integer.parseInt(cardId1);//converts a String value to int
                    int pin = Integer.parseInt(pinNumber);//converts a String value to int
                    int withdrawalAmount = Integer.parseInt(withdrawal1);
                    boolean earnCard = false;
                    DebitCard debitCard = null;//initializes a DebitCard object reference variable creditCard to null.

                    //starts a loop that iterates over each BankCard object in the bankCards ArrayList, assigning each object to a temporary reference variable bankCard1.
                    for (BankCard bankCard1 : bankCards) {
                        //It is used to downcast to access the object of bankcard
                        if (bankCard1 instanceof DebitCard) {
                            debitCard = (DebitCard) bankCard1;
                            //It checks whether the card id match the card id of arraylist
                            if (debitCard.getCardId() == cardId) {
                                earnCard = true;
                                break;
                            }
                        }
                    }
                    if (earnCard) {
                        //It will call the withdraw method form debit card
                        withdraw(debitCard, withdrawalAmount, dateOfWithdrawal, pin);
                        //It is used to update bankCards array with new debit card object
                        bankCards.set(bankCards.indexOf(debitCard), debitCard);
                    } else {//It will popup when the user input wrong ID
                        JOptionPane.showMessageDialog(null, "The card could not be located. Please input a valid card identification number");
                    }
                }
                //If an exception is occurred it will catch and display message
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numerical value.");
            }
        });
    }


    //This is a method for withdraw it will check and display message when exception takes place
    public void withdraw(DebitCard debitCard, int withdrawalAmount, String dateOfWithdrawal, int pinNumber) {

        if (debitCard.getPIN() == pinNumber) {
            if (debitCard.getBalanceAmount() < withdrawalAmount) {
                JOptionPane.showMessageDialog(null, "Withdrawal Amount cannot be greater than balance amount.");
                return;
            }
            debitCard.withdraw(withdrawalAmount, dateOfWithdrawal, pinNumber);
            JOptionPane.showMessageDialog(null, "Withdrawal of amount is successful");
            clear();
        } else {
            JOptionPane.showMessageDialog(null, "Please enter the correct pin number");
        }
    }





    //clears the text fields and combo boxes
    public void clear() {
        pinTfForWithDraw.setText("");
        cardIdTfForWithDraw.setText("");
        withdrawalAmtTfForWithDraw.setText("");
        yearsWDForWithDraw.setSelectedIndex(0);
        monthsWDForWithDraw.setSelectedIndex(0);
        daysWDForWithDraw.setSelectedIndex(0);

    }





}
