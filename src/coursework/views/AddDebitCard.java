package coursework.views;

import coursework.BankCard;
import coursework.DebitCard;
import coursework.components.MyCustomButton;
import coursework.components.MyCustomComboBox;
import coursework.components.MyCustomLabel;
import coursework.components.MyCustomTextField;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//This is a Java class named AddDebitCard that extends the JFrame class. It contains a GUI for adding a debit card to a list of bank cards.
public class AddDebitCard extends JFrame {
    // Instance  variables
    MyCustomLabel addDebitCardLabelForDebitCard,issuerBankLabelForDebitCard,clientNameLabelForDebitCard,cardIdLabelForDebitCard,bankAccountLabelForDebitCard,balanceAmountLabelForDebitCard,pinNumberLabelForDebitCard;
    MyCustomTextField issuerBankTFForDebitCard,clientNameTFForDebitCard,cardIdTFForDebitCard,bankAccountTFForDebitCard,balanceAmountTfForDebitCard, pinNumberTfForDebitCard;
    MyCustomComboBox bankNamesForDebitCard;// custom components
    MyCustomButton addBtnForDebitCard, clearBtnForDebitCard, displayBtnForDebitCard,backBtnForDebitCard;// custom components

    public AddDebitCard(ArrayList<BankCard> bankCards){ //This constructor takes an ArrayList of BankCard objects as a parameter to add new debit cards to the list.
        JFrame addDebitCard = new JFrame("Add Debit Card");//creating a JFrame
        addDebitCard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// to hide the window when it is closed
        addDebitCard.setSize(700, 800);// to edit the size as per need
        addDebitCard.setLocationRelativeTo(null);//location
        addDebitCard.setResizable(true);//to set the size
        addDebitCard.setVisible(true);//To make this frame visible

        JPanel debitCardPanel = new JPanel();//creating new panel
        debitCardPanel.setLayout(new GridBagLayout());

        //Creating JLabel for adding a debit card
        addDebitCardLabelForDebitCard= new MyCustomLabel("Please fill up the form below");
        issuerBankLabelForDebitCard= new MyCustomLabel("Issuer Bank:");
        clientNameLabelForDebitCard= new MyCustomLabel("Client Name:");
        cardIdLabelForDebitCard= new MyCustomLabel("Card Id:");
        bankAccountLabelForDebitCard= new MyCustomLabel("Bank Account:");
        balanceAmountLabelForDebitCard= new MyCustomLabel("Balance Amount:");
        pinNumberLabelForDebitCard = new MyCustomLabel("Pin Number:");

        //Creating JTextField for adding a debit card
        issuerBankTFForDebitCard = new MyCustomTextField("");
        clientNameTFForDebitCard= new MyCustomTextField("");
        cardIdTFForDebitCard = new MyCustomTextField("");
        bankAccountTFForDebitCard = new MyCustomTextField("");
        balanceAmountTfForDebitCard = new MyCustomTextField("");
        pinNumberTfForDebitCard = new MyCustomTextField("");

        //This is the name of banks which will show in combo-box
        bankNamesForDebitCard = new MyCustomComboBox(new String[]{
                "Select Bank Name","Citizens Bank International","Everest Bank","Global IME Bank","Himalayan Bank",
                "Kumari Bank","Laxmi Bank","Machhapuchhre Bank","Nabil Bank","Nepal Investment Mega Bank","Nepal SBI Bank",
                "NIC Asia Bank","NMB Bank","Prabhu Bank","Prime Commercial Bank","Sanima Bank","Siddhartha Bank","Standard Chartered Bank","Sunrise Bank"
        });


        //Creating JButton and declaring names
        addBtnForDebitCard = new MyCustomButton("Add Debit Card");
        clearBtnForDebitCard = new MyCustomButton("Clear");
        displayBtnForDebitCard = new MyCustomButton("Display");
        backBtnForDebitCard = new MyCustomButton("Back");

        //creates a new DebitCard object and adds it to an ArrayList<BankCard> of bank cards, which is passed to the constructor of the AddDebitCard class.
        addBtnForDebitCard.addActionListener(e -> {
            String balanceAmount = balanceAmountTfForDebitCard.getText();
            String cardId = cardIdTFForDebitCard.getText();
            String bankAccount = bankAccountTFForDebitCard.getText();
            String issuerBank = issuerBankTFForDebitCard.getText();
            String clientName = clientNameTFForDebitCard.getText();
            String pinNumber = pinNumberTfForDebitCard.getText();

            if (balanceAmount.equals("") || cardId.equals("") || bankAccount.equals("") || issuerBank.equals("") || clientName.equals("") || pinNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "Please complete all sections of the form");
            } else {
                try {
                double balance = Double.parseDouble(balanceAmount);
                int card = Integer.parseInt(cardId);
                int pin = Integer.parseInt(pinNumber);
                DebitCard debitCard = new DebitCard(balance, card, bankAccount, issuerBank, clientName, pin);
                bankCards.add(debitCard);
                JOptionPane.showMessageDialog(null, "Your Debit Card has been added successfully");
                clear();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Please review your information and ensure that it is correctly entered");
                }
            }
        });


        //clears the text fields and combo boxes
        clearBtnForDebitCard.addActionListener(e -> {
            clear();
        });

        // displays all the debit cards in the ArrayList
        displayBtnForDebitCard.addActionListener(e -> {
            new DisplayDebitCards(bankCards);
        });

        //closes the current window
        backBtnForDebitCard.addActionListener(e -> {
            addDebitCard.setVisible(false);
        });


        //sets the text of the issuerBankTf text field to the selected bank name
        bankNamesForDebitCard.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                String selectedBankName = (String) bankNamesForDebitCard.getSelectedItem();
                issuerBankTFForDebitCard.setText(selectedBankName);
            }
        });




        //provides a flexible and powerful way of organizing components in a grid.
        GridBagLayout gblDebitCard = new GridBagLayout();// to add the components to the window in a specific layout.
        GridBagConstraints gbcDebitCard = new GridBagConstraints();//to define the constraints for each component
        debitCardPanel.setLayout(gblDebitCard);

        //Adding the addDebitCardLabel
        gbcDebitCard.gridx = 3;//sets the column position of the component
        gbcDebitCard.gridy = 0;//sets the row position of the component
        gbcDebitCard.gridwidth = 2;// the component will span 2 column in the grid.
        gbcDebitCard.insets = new Insets(10, 10, 110, 10);// Adding  some whitespace(padding)
        gbcDebitCard.fill = GridBagConstraints.HORIZONTAL;//specifies that the component should be resized horizontally to fill its grid cell.
        gbcDebitCard.anchor = GridBagConstraints.CENTER;//specifies that the component should be centered horizontally and vertically within its grid cell.
        debitCardPanel.add(addDebitCardLabelForDebitCard, gbcDebitCard);

        //Adding the issuerBankLabel
        gbcDebitCard.gridx = 0;//sets the column position of the component
        gbcDebitCard.gridy = 1;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(issuerBankLabelForDebitCard, gbcDebitCard);

        //Adding the issuerBankTF
        gbcDebitCard.gridx = 2;//sets the column position of the component
        gbcDebitCard.gridy = 1;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(issuerBankTFForDebitCard, gbcDebitCard);

        //Adding the bankNames
        gbcDebitCard.gridx = 4;//sets the column position of the component
        gbcDebitCard.gridy = 1;//sets the row position of the component
        gbcDebitCard.gridwidth = 1;// the component will span 1 column in the grid.
        debitCardPanel.add(bankNamesForDebitCard, gbcDebitCard);

        //Adding the clientNameLabel
        gbcDebitCard.gridx = 3;//sets the column position of the component
        gbcDebitCard.gridy = 2;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(clientNameLabelForDebitCard, gbcDebitCard);

        //Adding the clientNameTF
        gbcDebitCard.gridx = 4;//sets the column position of the component
        gbcDebitCard.gridy = 2;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(clientNameTFForDebitCard, gbcDebitCard);

        //Adding the cardIdLabel
        gbcDebitCard.gridx = 3;//sets the column position of the component
        gbcDebitCard.gridy = 3;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(cardIdLabelForDebitCard, gbcDebitCard);

        //Adding the cardIdTF
        gbcDebitCard.gridx = 4;//sets the column position of the component
        gbcDebitCard.gridy = 3;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(cardIdTFForDebitCard, gbcDebitCard);

        //Adding the bankAccountLabel
        gbcDebitCard.gridx = 3;//sets the column position of the component
        gbcDebitCard.gridy = 4;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(bankAccountLabelForDebitCard, gbcDebitCard);

        //Adding the bankAccountTF
        gbcDebitCard.gridx = 4;
        gbcDebitCard.gridy = 4;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(bankAccountTFForDebitCard, gbcDebitCard);

        //Adding the balanceAmountLabel
        gbcDebitCard.gridx = 3;//sets the column position of the component
        gbcDebitCard.gridy = 5;//sets the row position of the component
        gbcDebitCard.gridwidth = 1;// the component will span 1 column in the grid.
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(balanceAmountLabelForDebitCard, gbcDebitCard);

        //Adding the balanceAmountTf
        gbcDebitCard.gridx = 4;//sets the column position of the component
        gbcDebitCard.gridy = 5;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(balanceAmountTfForDebitCard, gbcDebitCard);

        //Adding the pinNumberLabel
        gbcDebitCard.gridx = 3;//sets the column position of the component
        gbcDebitCard.gridy = 6;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(pinNumberLabelForDebitCard, gbcDebitCard);

        //Adding the pinNumberTf
        gbcDebitCard.gridx = 4;//sets the column position of the component
        gbcDebitCard.gridy = 6;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(pinNumberTfForDebitCard, gbcDebitCard);




        //Adding the addBtn
        gbcDebitCard.gridx = 3;//sets the column position of the component
        gbcDebitCard.gridy = 7;//sets the row position of the component
        gbcDebitCard.gridwidth = 2;// the component will span 2 column in the grid.
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(addBtnForDebitCard, gbcDebitCard);

        //Adding the clearBtn
        gbcDebitCard.gridx = 1;//sets the column position of the component
        gbcDebitCard.gridy = 8;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(clearBtnForDebitCard, gbcDebitCard);

        //Adding the displayBtn
        gbcDebitCard.gridx = 2;//sets the column position of the component
        gbcDebitCard.gridy = 8;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 20);// Adding  some whitespace(padding)
        debitCardPanel.add(displayBtnForDebitCard, gbcDebitCard);

        //Adding the bankBtn
        gbcDebitCard.gridx = 4;//sets the column position of the component
        gbcDebitCard.gridy = 8;//sets the row position of the component
        gbcDebitCard.insets = new Insets(10, 10, 10, 10);// Adding  some whitespace(padding)
        debitCardPanel.add(backBtnForDebitCard, gbcDebitCard);



        addDebitCard.add(debitCardPanel);
    }

    //clears the text fields and combo boxes
    public void clear() {
        balanceAmountTfForDebitCard.setText("");
        cardIdTFForDebitCard.setText("");
        bankAccountTFForDebitCard.setText("");
        issuerBankTFForDebitCard.setText("");
        clientNameTFForDebitCard.setText("");
        pinNumberTfForDebitCard.setText("");
        bankNamesForDebitCard.setSelectedIndex(0);
    }
}
