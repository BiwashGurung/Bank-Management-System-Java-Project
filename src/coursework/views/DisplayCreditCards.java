package coursework.views;
import coursework.BankCard;
import coursework.CreditCard;

import javax.swing.*;
import java.util.ArrayList;
public class DisplayCreditCards extends JFrame {
    //instance variable
     JTable displayTable;

    public DisplayCreditCards(ArrayList<BankCard> bankCards) {//The constructor takes an ArrayList of BankCard objects as a parameter.
        super("Display Credit Card Details");//title
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// to hide the window when it is closed
        setSize(1000, 1000);//can set as per need
        setLocationRelativeTo(null);//location
        setResizable(true);//resizable
        setVisible(true);//to make it visible

        JPanel displayPanel = new JPanel();//creating a panel
        displayPanel.setLayout(new BoxLayout(displayPanel,BoxLayout.Y_AXIS));//layout for vertical representation
        String[] columnNames = { "Client Name","Card Type","Card Id", "Bank Account", "Balance Amount","Issuer Bank", "CVC Number", "Interest Rate"," Expiration Date", "New Grace Limit", "New Credit Limit" , "IsGranted"};
        ArrayList<CreditCard> creditCard = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof CreditCard) {
                creditCard.add((CreditCard) bankCard);
            }
        }
        String[][] data = new String[creditCard.size()][12];
        //A for loop is used to populate the data array with the credit card details.
        // Each of these details is then assigned to the appropriate cell in the data array.
        for (int i = 0; i < creditCard.size(); i++) {
            data[i][0] = String.valueOf(creditCard.get(i).getClientName());
            data[i][1] =  "Credit Card";
            data[i][2] = String.valueOf(creditCard.get(i).getCardId());
            data[i][3] = String.valueOf(creditCard.get(i).getBankAccount());
            data[i][4] = String.valueOf(creditCard.get(i).getBalanceAmount());
            data[i][5] = String.valueOf(creditCard.get(i).getIssuerBank());
            data[i][6] = String.valueOf(creditCard.get(i).getCVCNumber());
            data[i][7] = String.valueOf(creditCard.get(i).getInterestRate());
            data[i][8] = String.valueOf(creditCard.get(i).getExpirationDate());
            data[i][9] = String.valueOf(creditCard.get(i).getGracePeriod());
            data[i][10] = String.valueOf(creditCard.get(i).getCreditLimit());
            data[i][11] = String.valueOf(creditCard.get(i).getIsGranted());

        }
        displayTable = new JTable(data, columnNames);//creating
        JScrollPane scrollPane = new JScrollPane(displayTable);//created to enable scrolling if the table exceeds the size of the JFrame.
        displayPanel.add(scrollPane);//adding
        add(displayPanel);//adding
    }
}




