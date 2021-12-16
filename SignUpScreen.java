import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Dec 07 23:46:13 CST 2021
 */

/**
 * @author Xudong Gao
 */
public class SignUpScreen extends JFrame {
    private Admin admin;
    private UserManager um;
    public SignUpScreen(Admin admin) {
        this.admin = admin;
        this.um = admin.getUserManager();
        initComponents();
    }

    private void resetPerformed(ActionEvent e) {
        UsernameF.setText(null);
        passwordField1.setText(null);
        passwordField2.setText(null);
    }

    private void signUpPerformed(ActionEvent e) {
        String username = UsernameF.getText();
        String password = String.valueOf(passwordField1.getPassword());
        String passwordC = String.valueOf(passwordField2.getPassword());
        if (um.checkDuplicateName(username) || username.equals(admin.getUserName())) { // check if existed
            JOptionPane.showMessageDialog(null, "That username is taken", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!password.equals(passwordC)) {
            JOptionPane.showMessageDialog(null, "Those passwords didn’t match", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Client client = new Client(username, password, Admin.getInstance());
            um.addUser(client);
            JOptionPane.showMessageDialog(null, "You have successfully signud up", "Success", JOptionPane.INFORMATION_MESSAGE);
            um.storeUsers();
            SessionHandler.getInstance().addLog("Client " + username + " signed up successfully");
            this.dispose();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY
        // //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        label1 = new JLabel();
        label2 = new JLabel();
        UsernameF = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        // ======== this ========
        var contentPane = getContentPane();

        // ---- label1 ----
        label1.setText("Create a new user");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

        // ---- label2 ----
        label2.setText("Username:");

        // ---- label3 ----
        label3.setText("Password:");

        // ---- label4 ----
        label4.setText("Confirm:");

        // ---- button1 ----
        button1.setText("Reset");
        button1.addActionListener(e -> resetPerformed(e));

        // ---- button2 ----
        button2.setText("Sign Up");
        button2.addActionListener(e -> signUpPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout
                .createSequentialGroup()
                .addGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout
                                .createSequentialGroup()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(passwordField2,
                                        GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup().addComponent(label2)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 69,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(UsernameF, GroupLayout.PREFERRED_SIZE, 139,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 139,
                                                        GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(69, 69, 69).addComponent(button1)
                                .addGap(27, 27, 27).addComponent(button2)))
                .addContainerGap(51, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addGap(0, 93, Short.MAX_VALUE).addComponent(label1).addGap(100, 100, 100)));
        contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup().addGap(7, 7, 7)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(UsernameF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(
                                contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 38,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 30,
                                                GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4).addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, 30,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button1).addComponent(button2))
                        .addContainerGap(54, Short.MAX_VALUE)));
        setSize(345, 330);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JLabel label1;
    private JLabel label2;
    private JTextField UsernameF;
    private JLabel label3;
    private JLabel label4;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration //GEN-END:variables
}
