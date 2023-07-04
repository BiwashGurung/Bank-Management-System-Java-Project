package coursework.views;

import coursework.BankCard;

import javax.swing.*;
import java.util.ArrayList;


public class Display extends JFrame {
    JTable table;// creating JTable
    public Display(ArrayList<BankCard> bankCards){// a constructor that takes an ArrayList of BankCard objects as an argument.
        super("Display");//title
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// to hide the window when it is closed
        setSize(500, 500);// can set as per choice
        setLocationRelativeTo(null);
        setResizable(false);// constant
        setVisible(true);//to make it visible

        JPanel panel = new JPanel();//creating a panel
        String[] columnNames = {"Card Id","Client Name", "Bank Account", "Balance", "Card Type"};
        String[][] data = new String[bankCards.size()][5];
        // for loop is used to iterate over each BankCard object in the ArrayList, and for each card, the relevant information  is added to the data array.
        for (int i = 0; i < bankCards.size(); i++) {
            data[i][0] = String.valueOf(bankCards.get(i).getCardId());
            data[i][1] = String.valueOf(bankCards.get(i).getClientName());
            data[i][2] = String.valueOf(bankCards.get(i).getBankAccount());
            data[i][3] = String.valueOf(bankCards.get(i).getBalanceAmount());
            data[i][4] = bankCards.get(i) instanceof coursework.DebitCard ? "Debit Card" : "Credit Card";
        }
        //The table object is created using the data and columnNames arrays, and added to a JScrollPane which is added to the JPanel.
        table = new JTable(data, columnNames);//creating
        JScrollPane scrollPane = new JScrollPane(table);//created to enable scrolling if the table exceeds the size of the JFrame.
        panel.add(scrollPane);//adding
        add(panel);//adding
    }
}
