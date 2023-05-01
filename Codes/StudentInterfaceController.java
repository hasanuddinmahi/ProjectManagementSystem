import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

// Controller for student interface - by Lee Jiang Yoong
public class StudentInterfaceController {

    private StudentInterfaceView theView;

    public StudentInterfaceController(StudentInterfaceView theView) {
        this.theView = theView;

        this.theView.addOkButtonListener(new OkButtonListener());

    }

    class OkButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            theView.dispose();

            switch (theView.getChoice()) {
                case "1": // View
                    try {
                        StudentProjectView theView = new StudentProjectView();
                        new StudentProjectController(theView);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "2":
                    LoginModel theModel = new LoginModel();
                    LoginView theView = new LoginView();
                    new LoginController(theView, theModel);

                    theView.setVisible(true);
                    break;
                case "":
                    // Empty input String error message
                    JOptionPane.showMessageDialog(null, "  Please select an option!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "           Invalid option");
                    break;
            }
            theView.resetText();
        }
    }
}
