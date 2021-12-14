import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Dec 06 22:18:12 CST 2021
 */

/**
 * @author Xudong Gao
 */
public class ATMHome extends JFrame {

    private Admin admin;

    public ATMHome() {
        this.admin = Admin.getInstance();
        initComponents();
    }


    private void button2ActionPerformed(ActionEvent e) {
        String username = textField1.getText();
        String passWord = passwordField1.getText();
        if (true) { // a function to check user
            textField1.setText(null);
            passwordField1.setText(null);
            if (!username.equals(admin.getUserName())) { // if it is a client
                User user = admin.getUserManager().getUserByName(username);
                
                if(user == null) {
                    JOptionPane.showMessageDialog(null, "Username not found, sign up first!", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    Client client = new Client(user.getUserName(), user.getPassword(), admin);
                    if(client.matchPassword(passWord)) {
                        ClientHome ch = new ClientHome(client);
                        ch.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Password incorrect!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                if (admin.matchPassword(passWord)) {
                    new AdminScreen().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Password incorrect!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else {

            JOptionPane.showMessageDialog(null, "Invalid Login Details!", "Error!", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void signUpPerformed(ActionEvent e) {
        new SignUpScreen(admin).setVisible(true);// TODO add your code here
    }

    private void thisWindowClosing(WindowEvent e) {
        System.out.println("ddddd");
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY
        // //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();
        separator1 = new JSeparator();
        passwordField1 = new JPasswordField();
        separator2 = new JSeparator();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("ATM");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(240, 45), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Username:");
        label2.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        contentPane.add(label2);
        label2.setBounds(148, 118, 85, 35);

        //---- label3 ----
        label3.setText("Password:");
        label3.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        contentPane.add(label3);
        label3.setBounds(148, 168, 80, 50);

        //---- textField1 ----
        textField1.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        contentPane.add(textField1);
        textField1.setBounds(255, 123, 170, 30);

        //---- button2 ----
        button2.setText("log in");
        button2.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(285, 270, 90, 30);

        //---- button3 ----
        button3.setText("sign up");
        button3.setHorizontalTextPosition(SwingConstants.CENTER);
        button3.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        button3.addActionListener(e -> signUpPerformed(e));
        contentPane.add(button3);
        button3.setBounds(160, 270, 90, 30);
        contentPane.add(separator1);
        separator1.setBounds(65, 85, 400, 70);

        //---- passwordField1 ----
        passwordField1.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        contentPane.add(passwordField1);
        passwordField1.setBounds(255, 185, 170, 30);
        contentPane.add(separator2);
        separator2.setBounds(65, 245, 400, 70);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(545, 410);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JButton button2;
    private JButton button3;
    private JSeparator separator1;
    private JPasswordField passwordField1;
    private JSeparator separator2;
    // JFormDesigner - End of variables declaration //GEN-END:variables
}
