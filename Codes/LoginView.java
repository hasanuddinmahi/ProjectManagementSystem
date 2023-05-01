import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

// View for login page - by Lee Jiang Yoong
public class LoginView extends JFrame {

    private JPanel panel = new JPanel();

    private JTextField user_text = new JTextField(15);
    private JTextField password_text = new JPasswordField(15);

    private JButton login_button = new JButton("Login");
    private JButton exit_button = new JButton("Exit");

    private JLabel userID = new JLabel("User ID:");
    private JLabel password = new JLabel("Password:");

    public LoginView() {

        super("MMU online Mini-project Management System");

        GUI();
    }

    // GUI
    protected void GUI() {

        // Set Font
        login_button.setFont(new Font("Courier", Font.BOLD, 15));
        exit_button.setFont(new Font("Courier", Font.BOLD, 15));
        user_text.setFont(new Font("Courier", Font.BOLD, 15));
        userID.setFont(new Font("Courier", Font.BOLD, 15));
        password.setFont(new Font("Courier", Font.BOLD, 15));

        // Window
        setSize(450,180);
        setLocationRelativeTo(null);
        panel.setLayout (null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set Position
        user_text.setBounds(170,25,150,20);
        password_text.setBounds(170,65,150,20);
        login_button.setBounds(120,100,80,20);
        exit_button.setBounds(220,100,80,20);
        userID.setBounds(95,25,80,20);
        password.setBounds(86,65,80,20);

        // Add to panel
        panel.add(user_text);
        panel.add(password_text);
        panel.add(login_button);
        panel.add(exit_button);
        panel.add(userID);
        panel.add(password);

        setContentPane(panel);
    }

    // Get user id from text field
    public int getUserText() {
        return Integer.parseInt(user_text.getText());
    }

    // Get password from text field
    public String getPasswordText() {
        return password_text.getText();
    }

    // Set text field to null
    public void resetText() {
        user_text.setText("");
        password_text.setText("");
        user_text.requestFocus();
    }

    // Ok button action listener
    void addLoginButtonListener(ActionListener listener) {
        login_button.addActionListener(listener);
    }

    // Back button action listener
    void addExitButtonListener(ActionListener listener) {
        exit_button.addActionListener(listener);
    }
}
