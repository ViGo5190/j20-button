package su.vigo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import su.vigo.Resources.Resources;

public class FirstFrame extends JFrame implements MouseMotionListener {

    private final JButton button;
    //    private final JTextField textField;
    private final JLabel label;

    private final ActionListener actionListener = e -> {
    };


    //    private void changeLabelText() {
//        label.setText(textField.getText());
//        textField.setText(null);
//    }
    private void changeLabelText(String s) {
        label.setText(s);
    }

    public FirstFrame() throws HeadlessException {
        super(Resources.string("application.title"));

        label = new JLabel(Resources.string("label.message"), JLabel.CENTER);
        button = new JButton(Resources.string("button.push.me.text"));
//        textField = new JTextField(16);

        initComponents();
    }

//    private final CaretListener caretListener = new CaretListener() {
//        @Override
//        public void caretUpdate(CaretEvent e) {
//            button.setEnabled(!textField.getText().isEmpty());
//        }
//    };

    private void initComponents() {


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        setContentPane(createContentPane());

//        button.addActionListener(actionListener);
        button.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                button.setBounds(button.getX() - 100, button.getY() - 100, button.getWidth(), button.getHeight());
            }
        });
        button.setActionCommand(Resources.string("button.push.me.action"));
        button.setBounds(200, 200, 100, 100);

        addMouseMotionListener(this);


        label.setBounds(0, 0, 300, 100);
        add(button, BorderLayout.SOUTH);

        add(label, BorderLayout.CENTER);

        pack();
    }

    private int getGap(JComponent component) {
        LayoutStyle style = LayoutStyle.getInstance();
        return style.getContainerGap(component, SwingConstants.NORTH, null);
    }

    private Container createContentPane() {
        Dimension dimension = new Dimension(500, 500);

        JPanel panel = new JPanel();


//        int vgap = getGap(panel);

//        Border border = BorderFactory.createEmptyBorder(vgap, vgap, vgap, vgap);
        panel.setPreferredSize(dimension);

//        panel.setBorder(border);

        panel.setLayout(null);

        return panel;
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getX() + " " + button.getX() + " " + button.getWidth());


        int btnX = button.getX() + button.getWidth() / 2;
        int btnY = button.getY() + button.getHeight() / 2;

        int diff = (int) Math.sqrt(Math.pow((btnX - e.getX()), 2) + Math.pow((btnY - e.getY()), 2));

//        String s = e.getX() + " " + button.getX() + " " +  button.getWidth() +" " +  this.getWidth();
        String s = diff + " " + button.getX() + " " + button.getY() + " " + e.getX() + " " + e.getY() + " " + button.getWidth();

//        changeLabelText(s);

        if (checkPosition(button.getX(), button.getY(), e.getX(), e.getY(), button.getWidth())) {

            int dir = 10;
            if ((button.getX() + button.getWidth()  + dir < e.getX()) && (btnX - dir < e.getX()))  {
                button.setBounds(button.getX() - dir, button.getY(), button.getWidth(), button.getHeight());
            } else if (btnX - dir > e.getX()) {
                button.setBounds(button.getX() + dir, button.getY(), button.getWidth(), button.getHeight());
            } else if ((btnY + button.getHeight() + dir > e.getY()) && (btnY - dir > e.getY())) {
                button.setBounds(button.getX(), button.getY() + dir, button.getWidth(), button.getHeight());
            } else if (btnY - dir < e.getY()){
                button.setBounds(button.getX(), button.getY() - dir, button.getWidth(), button.getHeight());
            }


//            button.setAlignmentX(button.getX() + 100);
//            button.setEnabled(false);
//            button.setBounds(button.getX() + 100,100,100,100);
        } else {
            button.setEnabled(true);
        }
//        saySomething("Mouse moved", e);
    }

    private boolean checkPosition(int x, int y, int ex, int ey, int checkDiff) {

        int btnX = x + button.getWidth() / 2;
        int btnY = y + button.getHeight() / 2;

        int diff = (int) Math.sqrt(Math.pow((btnX - ex), 2) + Math.pow((btnY - ey), 2));

        changeLabelText(btnX + " : " + btnY + "!" + ex + ":" + ey + " = " + diff);

        return diff < checkDiff;
    }

}
