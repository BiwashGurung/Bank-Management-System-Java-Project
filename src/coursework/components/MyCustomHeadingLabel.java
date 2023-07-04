package coursework.components;

import javax.swing.*;
import java.awt.*;

//To change and make customized text font style and make it bold when it is imported
public class MyCustomHeadingLabel extends JLabel {
    public MyCustomHeadingLabel(String text) {
        super(text);
        setFont(new Font("SANS_SERIF", Font.BOLD, 30));
    }
}
