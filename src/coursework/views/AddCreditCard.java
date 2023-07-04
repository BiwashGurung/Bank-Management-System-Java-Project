package coursework.views;

import coursework.BankCard;
import coursework.CreditCard;
import coursework.components.MyCustomButton;
import coursework.components.MyCustomComboBox;
import coursework.components.MyCustomLabel;
import coursework.components.MyCustomTextField;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


//This is a Java class named AddCreditCard that extends the JFrame class. It contains a GUI for adding a credit card to a list of bank cards.
public class AddCreditCard extends JFrame {
     // Instance  variables
    MyCustomLabel addCreditCardLabelForCreditCard,issuerBankLabelForCreditCard,clientNameLabelForCreditCard, cardIdLabelForCreditCard,bankAccountLabelForCreditCard,balanceAmountLabelForCreditCard,cvcAmountLabelForCreditCard,interestRateLabelForCreditCard,expirationDateLabelForCreditCard;
    MyCustomTextField issuerBankTfForCreditCard,clientNameTfForCreditCard,cardIdTfForCreditCard,bankAccountTfForCreditCard,balanceAmountTfForCreditCard,cvcNumberTfForCreditCard,interestRateTfForCreditCard;//// custom components
    MyCustomComboBox bankNamesForCreditCard;// custom components
    JComboBox yearCDForCreditCard,monthCDForCreditCard,dayCDForCreditCard;
    MyCustomButton addCreditCardBtnForCreditCard,clearBtnForCreditCard,displayBtnForCreditCard,backBtnForCreditCard;// custom components


    public AddCreditCard(ArrayList<BankCard> bankCards){  //This constructor takes an ArrayList of BankCard objects as a parameter to add new credit cards to the list.
        JFrame addCreditCard = new JFrame("Add Credit Card");//creating a JFrame
        addCreditCard.setSize(700, 800);// to edit the size as per need
        addCreditCard.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// to hide the window when it is closed
        addCreditCard.setLocationRelativeTo(null);//location
        addCreditCard.setResizable(true);//to make resizable
        addCreditCard.setVisible(true);//To make it visible

        JPanel creditCardpanel = new JPanel();//creating new J panel
        creditCardpanel.setLayout(new GridBagLayout());


        //Creating JLabel for adding a credit card
        addCreditCardLabelForCreditCard= new MyCustomLabel("Please fill up the form below");
        issuerBankLabelForCreditCard= new MyCustomLabel("Issuer Bank:");
        clientNameLabelForCreditCard= new MyCustomLabel("Client Name:");
        cardIdLabelForCreditCard= new MyCustomLabel("Card Id:");
        bankAccountLabelForCreditCard= new MyCustomLabel("Bank Account:");
        balanceAmountLabelForCreditCard = new MyCustomLabel("Balance Amount:");
        cvcAmountLabelForCreditCard= new MyCustomLabel("CVC Number:");
        interestRateLabelForCreditCard= new MyCustomLabel("Interest Rate:");
        expirationDateLabelForCreditCard = new MyCustomLabel("Expiration Date:");

        //Creating JTextField for adding a credit card
        issuerBankTfForCreditCard = new MyCustomTextField("");
        clientNameTfForCreditCard = new MyCustomTextField("");
        cardIdTfForCreditCard = new MyCustomTextField("");
        bankAccountTfForCreditCard = new MyCustomTextField("");
        balanceAmountTfForCreditCard = new MyCustomTextField("");
        cvcNumberTfForCreditCard = new MyCustomTextField("");
        interestRateTfForCreditCard = new MyCustomTextField("");

        //This is the name of banks which will show in combo-box
        bankNamesForCreditCard = new MyCustomComboBox(new String[]{
                "Select Bank Name","Citizens Bank International","Everest Bank","Global IME Bank","Himalayan Bank",
                "Kumari Bank","Laxmi Bank","Machhapuchhre Bank","Nabil Bank","Nepal Investment Mega Bank","Nepal SBI Bank",
                "NIC Asia Bank","NMB Bank","Prabhu Bank","Prime Commercial Bank","Sanima Bank","Siddhartha Bank","Standard Chartered Bank","Sunrise Bank"
        });

        //These are the dates
        String years[] = {"Select Year", "2020", "2021","2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
        String months[] = {"Select Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String days[] = {"Select Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
                "27", "28", "29", "30", "31"};




        //Creating JComboBox for adding dates
        yearCDForCreditCard = new JComboBox<>(years);
        monthCDForCreditCard = new JComboBox<>(months);
        dayCDForCreditCard = new JComboBox<>(days);


        //Creating JButton and giving button names
        addCreditCardBtnForCreditCard = new MyCustomButton("Add CreditCard");
        clearBtnForCreditCard = new MyCustomButton("Clear");
        displayBtnForCreditCard = new MyCustomButton("Display");
        backBtnForCreditCard = new MyCustomButton("Back");


        //sets the text of the issuerBankTf text field to the selected bank name
        bankNamesForCreditCard.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                String selectedBankName = (String) bankNamesForCreditCard.getSelectedItem();
                issuerBankTfForCreditCard.setText(selectedBankName);
            }
        });



        //The addActionListener() method is used to add functionality to the buttons by creating instances of other classes defined in the project.

        addCreditCardBtnForCreditCard.addActionListener(e -> { //reads the input data  and displays a message dialog confirming the addition.
            String cardId = cardIdTfForCreditCard.getText();
            String clientName = clientNameTfForCreditCard.getText();
            String issuerBank = issuerBankTfForCreditCard.getText();
            String bankAccount = bankAccountTfForCreditCard.getText();
            String balanceAmount = balanceAmountTfForCreditCard.getText();
            String cvcNumber = cvcNumberTfForCreditCard.getText();
            String interestRate = interestRateTfForCreditCard.getText();

            if (cardId.equals("") || clientName.equals("") || issuerBank.equals("") || bankAccount.equals("") || balanceAmount.equals("") || cvcNumber.equals("") || interestRate.equals("")
                    || yearCDForCreditCard.getSelectedItem().equals("select year") || monthCDForCreditCard.getSelectedItem().equals("select month") || dayCDForCreditCard.getSelectedItem().equals("select day")
            ) {
                JOptionPane.showMessageDialog(null, "Please complete all sections of the form");

            } else {
                try {
                    int card = Integer.parseInt(cardId);
                    double balance = Double.parseDouble(balanceAmount);
                    int cvc = Integer.parseInt(cvcNumber);
                    double interest = Double.parseDouble(interestRate);
                    String expirationDate = yearCDForCreditCard.getSelectedItem() + "-" + monthCDForCreditCard.getSelectedItem() + "-" + dayCDForCreditCard.getSelectedItem();
                    CreditCard creditCard = new CreditCard(card, issuerBank, bankAccount, clientName, cvc, interest, expirationDate, balance);
                    bankCards.add(creditCard);
                    JOptionPane.showMessageDialog(null, "Your Credit Card has been added Successfully");
                    clear();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Please review your information and ensure that it is correctly entered");
                }
            }
        });

        //clears the text fields and combo boxes
        clearBtnForCreditCard.addActionListener(e -> {
            clear();
        });

        // displays the current list of bank cards in a message dialog
        displayBtnForCreditCard.addActionListener(e -> {
            new DisplayCreditCards(bankCards);

        });

        //closes the AddCreditCard frame.
        backBtnForCreditCard.addActionListener(e -> {
            addCreditCard.setVisible(false);
        });


        //provides a flexible and powerful way of organizing components in a grid.
        GridBagLayout gblCreditCard = new GridBagLayout();// to add the components to the window in a specific layout.
        GridBagConstraints gbcCreditCard = new GridBagConstraints();//to define the constraints for each component
        creditCardpanel.setLayout(gblCreditCard);

        //Adding the addCreditCardLabel
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 0;//sets the row position of the component
        gbcCreditCard.gridwidth = 2;// the component will span 2 column in the grid.
        gbcCreditCard.insets = new Insets(10, 10, 10, 10);//giving whitespace(padding)
        creditCardpanel.add(addCreditCardLabelForCreditCard, gbcCreditCard);

        //Adding the issuerBankLabel
        gbcCreditCard.gridx = 1;//sets the column position of the component
        gbcCreditCard.gridy = 1;//sets the row position of the component
        gbcCreditCard.gridwidth = 1; //the component will span 1 column in the grid.
        creditCardpanel.add(issuerBankLabelForCreditCard, gbcCreditCard);

        //Adding the issuerBankTf
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 1;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(issuerBankTfForCreditCard, gbcCreditCard);

        //Adding the bankNames
        gbcCreditCard.gridx = 4;//sets the column position of the component
        gbcCreditCard.gridy = 1;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(bankNamesForCreditCard, gbcCreditCard);

        //Adding the clientNameLabel
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 2;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(clientNameLabelForCreditCard, gbcCreditCard);

        //Adding the clientNameTf
        gbcCreditCard.gridx = 4;//sets the column position of the component
        gbcCreditCard.gridy = 2;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(clientNameTfForCreditCard, gbcCreditCard);

        //Adding the cardIdLabel
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 3;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(cardIdLabelForCreditCard, gbcCreditCard);

        //Adding the cardIdTf
        gbcCreditCard.gridx = 4;//sets the column position of the component
        gbcCreditCard.gridy = 3;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(cardIdTfForCreditCard, gbcCreditCard);

        //Adding the bankAccountLabel
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 4;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(bankAccountLabelForCreditCard, gbcCreditCard);

        //Adding the bankAccountTf
        gbcCreditCard.gridx = 4;//sets the column position of the component
        gbcCreditCard.gridy = 4;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(bankAccountTfForCreditCard, gbcCreditCard);

        //Adding the balanceAmountLabel
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 5;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(balanceAmountLabelForCreditCard, gbcCreditCard);

        //Adding the balanceAmountTf
        gbcCreditCard.gridx = 4;//sets the column position of the component
        gbcCreditCard.gridy = 5;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(balanceAmountTfForCreditCard, gbcCreditCard);

        //Adding the cvcAmountLabel
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 6;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(cvcAmountLabelForCreditCard, gbcCreditCard);

        //Adding the cvcNumberTf
        gbcCreditCard.gridx = 4;//sets the column position of the component
        gbcCreditCard.gridy = 6;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(cvcNumberTfForCreditCard, gbcCreditCard);

        //Adding the interestLabel
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 7;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(interestRateLabelForCreditCard, gbcCreditCard);

        //Adding the interestRateTf
        gbcCreditCard.gridx = 4;//sets the column position of the component
        gbcCreditCard.gridy = 7;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(interestRateTfForCreditCard, gbcCreditCard);

        //Adding the expirationDateLabel
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 8;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(expirationDateLabelForCreditCard, gbcCreditCard);



        //Adding the yearCD
        gbcCreditCard.gridx = 4;//sets the column position of the component
        gbcCreditCard.gridy = 8;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(yearCDForCreditCard, gbcCreditCard);

        //Adding the monthCD
        gbcCreditCard.gridx = 4;//sets the column position of the component
        gbcCreditCard.gridy = 9;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(monthCDForCreditCard, gbcCreditCard);

        //Adding the dayCD
        gbcCreditCard.gridx = 4;//sets the column position of the component
        gbcCreditCard.gridy = 10;//sets the row position of the component
        gbcCreditCard.gridwidth = 1;// the component will span 1 column in the grid.
        creditCardpanel.add(dayCDForCreditCard, gbcCreditCard);




        //Adding the addCreditCardBtn
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 11;//sets the row position of the component
        gbcCreditCard.gridwidth = 2;// the component will span 2 column in the grid.
        creditCardpanel.add(addCreditCardBtnForCreditCard, gbcCreditCard);

        //Adding the clearBtn
        gbcCreditCard.gridx = 2;//sets the column position of the component
        gbcCreditCard.gridy = 12;//sets the row position of the component
        gbcCreditCard.gridwidth = 2;// the component will span 2 column in the grid.
        creditCardpanel.add(clearBtnForCreditCard, gbcCreditCard);

        //Adding the displayBtn
        gbcCreditCard.gridx = 3;//sets the column position of the component
        gbcCreditCard.gridy = 12;//sets the row position of the component
        gbcCreditCard.gridwidth = 2;// the component will span 2 column in the grid.
        creditCardpanel.add(displayBtnForCreditCard, gbcCreditCard);

        //Adding the backBtn
        gbcCreditCard.gridx = 4;//sets the column position of the component
        gbcCreditCard.gridy = 12;//sets the row position of the component
        gbcCreditCard.gridwidth = 2;// the component will span 2 column in the grid.
        creditCardpanel.add(backBtnForCreditCard, gbcCreditCard);




        addCreditCard.add(creditCardpanel);
    }

    //clears the text fields and combo boxes
    public void clear(){
        cardIdTfForCreditCard.setText("");
        clientNameTfForCreditCard.setText("");
        issuerBankTfForCreditCard.setText("");
        bankAccountTfForCreditCard.setText("");
        balanceAmountTfForCreditCard.setText("");
        cvcNumberTfForCreditCard.setText("");
        interestRateTfForCreditCard.setText("");

        bankNamesForCreditCard.setSelectedIndex(0);
        yearCDForCreditCard.setSelectedIndex(0);
        monthCDForCreditCard.setSelectedIndex(0);
        dayCDForCreditCard.setSelectedIndex(0);
    }
}


