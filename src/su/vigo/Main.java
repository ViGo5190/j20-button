package su.vigo;


import su.vigo.Form.MainFrame;

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

        MainFrame frame = new MainFrame();

        Dimension dimension = new Dimension(550, 500);

        frame.setMinimumSize(dimension);

        frame.setVisible(true);
    }
}
