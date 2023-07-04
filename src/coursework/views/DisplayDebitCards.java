package coursework.views;

import coursework.BankCard;
import coursework.DebitCard;

import javax.swing.*;
import java.util.ArrayList;


public class  DisplayDebitCards extends JFrame {

    public DisplayDebitCards(ArrayList<BankCard> bankCards){// a constructor that takes an ArrayList of BankCard objects as an argument.
        super("Display Debit Cards");//Title
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//to hide the window when it is closed.
        setSize(800, 800);// setting as per need
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(true);// resizeable
        setVisible(true);// to make visible

        JPanel panel = new JPanel();//creating a panel
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));//layout for vertical representation

        // it iterates over the bankCards list to extract DebitCard objects and add them to a new ArrayList of DebitCard objects.
        String[] columnNames = {"Card Id", "Bank Account", "Balance","Issuer Bank" ,"Client Name", "Card Type","Withdrawal Amount","Date of Withdrawal", "Pin", "Has Withdrawn"};
        ArrayList<DebitCard> debitCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof DebitCard) {
                debitCards.add((DebitCard) bankCard);
            }
        }
        // It populates the array with the data from the DebitCard objects, with each column corresponding to a different attribute of the DebitCard class.
        String[][] data = new String[debitCards.size()][10];
        for (int i = 0; i < debitCards.size(); i++) {
            data[i][0] = String.valueOf(debitCards.get(i).getCardId());
            data[i][1] = String.valueOf(debitCards.get(i).getBankAccount());
            data[i][2] = String.valueOf(debitCards.get(i).getBalanceAmount());
            data[i][3] = String.valueOf(debitCards.get(i).getIssuerBank());
            data[i][4] = String.valueOf(debitCards.get(i).getClientName());
            data[i][5] =  "Debit Card";
            data[i][6] = String.valueOf(debitCards.get(i).getWithdrawalAmount());
            data[i][7] = String.valueOf(debitCards.get(i).getDateOfWithdrawal());
            data[i][8] = String.valueOf(debitCards.get(i).getPIN());
            data[i][9] = String.valueOf(debitCards.get(i).getHasWithdrawn());
        }
        JTable table = new JTable(data, columnNames);//creating
        JScrollPane scrollPane = new JScrollPane(table);//created to enable scrolling if the table exceeds the size of the JFrame.
        panel.add(scrollPane);//adding
        add(panel);//adding
    }
}
