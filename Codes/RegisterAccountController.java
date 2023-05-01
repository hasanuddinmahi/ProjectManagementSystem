import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

// Controller for Register an account for Admin / Student / Lecturer - by Lee Jiang Yoong
public class RegisterAccountController {

    private RegisterAccountView theView;
    private RegisterAccountModel theModel;

    public RegisterAccountController(RegisterAccountView theView, RegisterAccountModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addOkButtonListener(new OkButtonListener());
        this.theView.addBackButtonListener(new BackButtonListener());

    }

    class OkButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Boolean valid = false;
            
            try {
                String userID_Text = theView.getUserID();
                String userPassword_Text = theView.getPassword();
                String userRole_Text = theView.getRole();

                valid = theModel.createAccount(userID_Text, userPassword_Text, userRole_Text);

                if(valid == false){
                    JOptionPane.showMessageDialog(null, "     Invalid input!");
                    theView.resetText();

                }else if (valid) {
                    // Redirect to Admin's option
                    theView.redirect();
                } else {
                    // Set Text field to null and request focus
                    theView.resetText();
                }

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.redirect(); // Redirect to Admin's option
        }
    }
}
