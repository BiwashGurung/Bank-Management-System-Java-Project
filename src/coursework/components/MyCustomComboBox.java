package coursework.components;

import javax.swing.*;

//To set customized Combo-box style when it is imported
public class MyCustomComboBox extends JComboBox {

    public MyCustomComboBox(String[] items){
        super(items);
        setFont(new java.awt.Font("Arial", 0, 15));
        setForeground(new java.awt.Color(0, 0, 0));
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumRowCount(5);
    }
}