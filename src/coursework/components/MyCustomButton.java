package coursework.components;

import javax.swing.*;
import java.awt.*;

//To set customized CustomButton style when it is imported
public class MyCustomButton extends JButton {
    public MyCustomButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 15));
        setForeground(Color.BLACK);
        setMargin(new java.awt.Insets(10, 10, 10, 10));

    }
}
