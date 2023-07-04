package coursework.components;

import javax.swing.*;

//To set customized text field size when it is imported
public class MyCustomTextField extends JTextField {

    public MyCustomTextField(String text){
        super(text);
        setColumns(15);
        setMargin(new java.awt.Insets(10, 10, 10, 10));
    }
}