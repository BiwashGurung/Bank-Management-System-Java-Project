package coursework;
import coursework.components.MyCustomButton;
import coursework.components.MyCustomHeadingLabel;
import coursework.components.MyCustomLabel;
import coursework.views.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BankGUI {

    ArrayList<BankCard> bankCards = new ArrayList<>();//This constructor takes an ArrayList of BankCard objects as a parameter
    //instance variables for custom components
    MyCustomHeadingLabel welcomeLabelForBankGUI;
    MyCustomLabel greetLabelForBankGUI, chooseLabelForBankGUI, addLabelForBankGUI,withdrawLabelForBankGUI, setLabelForBankGUI,recordsLabelForBankGUI;
    MyCustomButton addDebitCardBtnForBankGUI,addCreditCardBtnForBankGUI,addWithDrawBtnForBankGUI, displayBtnForBankGUI, creditCardBtnForBankGUI;


    public BankGUI(){

        JFrame BankGUI = new JFrame("The Bank OF Nepal");//creating a JFrame
        BankGUI.setSize(750, 650);//Customized as per need
        BankGUI.setLocationRelativeTo(null);//location
        BankGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to hide the window when it is closed.
        BankGUI.setResizable(true);//can customize the size
        BankGUI.setVisible(true);// to make it visible


        welcomeLabelForBankGUI = new MyCustomHeadingLabel("Welcome to The Bank OF Nepal");
        greetLabelForBankGUI = new MyCustomLabel("Greetings, How can I help you Sir/Mam ?");
        chooseLabelForBankGUI = new MyCustomLabel("Please, Choose an option from Below:");
        addLabelForBankGUI = new MyCustomLabel("To add an Account, Select:");
        withdrawLabelForBankGUI = new MyCustomLabel("To withdraw from Debit Card, Select:");
        setLabelForBankGUI = new MyCustomLabel("To Set/Cancel in Credit Card, Select:");
        recordsLabelForBankGUI = new MyCustomLabel("To view previous Records, Select:");


        JPanel bankGUIPanel = new JPanel();//creating a panel

        //customizing
        bankGUIPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bankGUIPanel.setForeground(Color.BLACK);
        bankGUIPanel.setFont(new Font("Arial", Font.PLAIN, 20));

        addDebitCardBtnForBankGUI = new MyCustomButton("Add Debit Card");
        addCreditCardBtnForBankGUI = new MyCustomButton("Add Credit Card");
        addWithDrawBtnForBankGUI = new MyCustomButton("Withdraw from Debit Card");
        creditCardBtnForBankGUI = new MyCustomButton("Set/Cancel Credit Card");
        displayBtnForBankGUI = new MyCustomButton("Show Records");



        //The addActionListener() method is used to add functionality to the buttons by creating instances of other classes defined in the project.
        addDebitCardBtnForBankGUI.addActionListener(e -> {
            new AddDebitCard(bankCards);
        });

        addCreditCardBtnForBankGUI.addActionListener(e -> {
            new AddCreditCard(bankCards);
        });

        addWithDrawBtnForBankGUI.addActionListener(e -> {
            new WithdrawFromDebitCard(bankCards);
        });

        creditCardBtnForBankGUI.addActionListener(e -> {
            new Credit_Card(bankCards);
        });


        displayBtnForBankGUI.addActionListener(e -> {
            new Display(bankCards);
        });




        GridBagLayout GridBagLayoutForBankGUI = new GridBagLayout();// to add the components to the window in a specific layout.
        GridBagConstraints gbcForBankGUI = new GridBagConstraints();//to define the constraints for each component
        bankGUIPanel.setLayout(GridBagLayoutForBankGUI);//setting



        // Adding the WelcomeLabel
        gbcForBankGUI.gridx = 2;//sets the column position of the component
        gbcForBankGUI.gridy = 0;//sets the row position of the component
        gbcForBankGUI.gridwidth = 3; // Span 3 columns
        gbcForBankGUI.insets = new Insets(0, 30, 50, 10); // Adding some padding
        bankGUIPanel.add(welcomeLabelForBankGUI, gbcForBankGUI);

        // Adding the greetLabel

        gbcForBankGUI.gridx = 2;//sets the column position of the component
        gbcForBankGUI.gridy = 1;//sets the row position of the component
        gbcForBankGUI.gridwidth = 2; // Span 2 columns
        gbcForBankGUI.insets = new Insets(10, 0, 30, -350); // Adding some padding
        bankGUIPanel.add(greetLabelForBankGUI, gbcForBankGUI);

        // Adding the chooseLabel

        gbcForBankGUI.gridx = 2;//sets the column position of the component
        gbcForBankGUI.gridy = 2;//sets the row position of the component
        gbcForBankGUI.gridwidth = 2; // Span 2 columns
        gbcForBankGUI.insets = new Insets(10, 10, 30, -90); // Adding some padding
        bankGUIPanel.add(chooseLabelForBankGUI, gbcForBankGUI);

        //Adding the addLabel
        gbcForBankGUI.gridx = 2;//sets the column position of the component
        gbcForBankGUI.gridy = 5;//sets the row position of the component
        gbcForBankGUI.gridwidth = 3; // Span 2 columns
        gbcForBankGUI.insets = new Insets(10, 10, 10, -70); // Adding some padding
        bankGUIPanel.add(addLabelForBankGUI, gbcForBankGUI);

        // Adding the addDebitCardBtn
        gbcForBankGUI.gridx = 2;//sets the column position of the component
        gbcForBankGUI.gridy = 6;//sets the row position of the component
        gbcForBankGUI.insets = new Insets(10, -70, 50, 30); // Adding some padding
        bankGUIPanel.add(addDebitCardBtnForBankGUI, gbcForBankGUI);

        // Adding the addCreditCardBtn
        gbcForBankGUI.gridx = 3;//sets the column position of the component
        gbcForBankGUI.gridy = 6;//sets the row position of the component
        gbcForBankGUI.insets = new Insets(10, -30, 50, 0); // Adding some padding
        bankGUIPanel.add(addCreditCardBtnForBankGUI, gbcForBankGUI);



        //Adding the withdrawLabel
        gbcForBankGUI.gridx = 2;//sets the column position of the component
        gbcForBankGUI.gridy = 7;//sets the row position of the component
        gbcForBankGUI.gridwidth = 1; // Span 1 columns
        gbcForBankGUI.insets = new Insets(10, 10, 10, -60); // Adding some padding
        bankGUIPanel.add(withdrawLabelForBankGUI, gbcForBankGUI);

        // Adding the addWithDrawBtn
        gbcForBankGUI.gridx = 2;//sets the column position of the component
        gbcForBankGUI.gridy = 8;//sets the row position of the component
        gbcForBankGUI.gridwidth = 1;// Span 1 columns
        gbcForBankGUI.insets = new Insets(10, 10, 10, -60); // Adding some padding
        bankGUIPanel.add(addWithDrawBtnForBankGUI, gbcForBankGUI);

        //Adding the setLabel
        gbcForBankGUI.gridx = 4;//sets the column position of the component
        gbcForBankGUI.gridy = 7;//sets the row position of the component
        gbcForBankGUI.gridwidth = 1; // Span 1 columns
        gbcForBankGUI.insets = new Insets(10, 10, 10, 10); // Adding some padding
        bankGUIPanel.add(setLabelForBankGUI, gbcForBankGUI);

        // Adding the creditCardBtn
        gbcForBankGUI.gridx = 4;//sets the column position of the component
        gbcForBankGUI.gridy = 8;//sets the row position of the component
        gbcForBankGUI.gridwidth = 1; // Span 1 columns
        gbcForBankGUI.insets = new Insets(10, 10, 10, 10); // Adding some padding
        bankGUIPanel.add(creditCardBtnForBankGUI, gbcForBankGUI);

        //Adding the recordsLabel
        gbcForBankGUI.gridx = 3;//sets the column position of the component
        gbcForBankGUI.gridy = 9;//sets the row position of the component
        gbcForBankGUI.gridwidth = 1; // Span 1 columns
        gbcForBankGUI.insets = new Insets(50, 10, 10, -100); // Adding some padding
        gbcForBankGUI.anchor = GridBagConstraints.CENTER;
        bankGUIPanel.add(recordsLabelForBankGUI, gbcForBankGUI);

        // Adding the displayBtn
        gbcForBankGUI.gridx = 3;//sets the column position of the component
        gbcForBankGUI.gridy = 10;//sets the row position of the component ;
        gbcForBankGUI.gridwidth = 1; // Span 1 columns
        gbcForBankGUI.insets = new Insets(10, 10, 10, -90); // Adding some padding
        gbcForBankGUI.anchor = GridBagConstraints.CENTER;//specifies that the component should be centered horizontally and vertically within its grid cell.
        bankGUIPanel.add(displayBtnForBankGUI, gbcForBankGUI);





        BankGUI.add(bankGUIPanel);

    }

//This method is made to call and display the GUI
    public static void main(String[] args) {
        BankGUI bankGUI = new BankGUI();

    }
}
