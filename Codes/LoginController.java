import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

// Controller for login page - by Lee Jiang Yoong
public class LoginController {
    private LoginView theView;
    private LoginModel theModel;

    public LoginController(LoginView theView, LoginModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addLoginButtonListener(new LoginButtonListener());
        this.theView.addExitButtonListener(new ExitButtonListener());
    }

    class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                int user_int = theView.getUserText();
                String password = theView.getPasswordText();

                Boolean valid = theModel.login(user_int, password);

                if (valid)
                    theView.dispose();
                else {
                    // Empty input String error message
                    JOptionPane.showMessageDialog(null, "Wrong Username / Password");
                    theView.resetText();
                }

            } catch (IOException ex2) {
                ex2.printStackTrace();
            } catch (NumberFormatException ex3) {
                // Empty input String error message
                JOptionPane.showMessageDialog(null, "No input (Username / Password)");
                theView.resetText(); // Set Text field to null and request focus
            }

        }
    }

    class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }
}
