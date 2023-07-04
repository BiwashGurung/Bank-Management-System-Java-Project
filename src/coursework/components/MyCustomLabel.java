package coursework.components;


import javax.swing.*;
import java.awt.*;

//To set customized label font and style when it is imported
public class MyCustomLabel extends JLabel {

    public MyCustomLabel(String text){
        super(text);
        setFont(new java.awt.Font("Arial", Font.BOLD, 16));
    }
}
