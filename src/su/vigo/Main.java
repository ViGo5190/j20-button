package su.vigo;


import java.awt.*;

import static javax.swing.UIManager.setLookAndFeel;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;

public class Main {

    public static void main(String[] args) {

        try {
            setLookAndFeel(getSystemLookAndFeelClassName());

        } catch (Exception e) {
            System.err.println(e);
        }
        // write your code here

        FirstFrame frame = new FirstFrame();

        Dimension dimension = new Dimension(350, 100);

        frame.setMinimumSize(dimension);

        frame.setVisible(true);
    }
}
