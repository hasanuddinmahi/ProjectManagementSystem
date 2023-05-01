import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

// Controller for assigning student to lecturer's project - by Lee Jiang Yoong
public class AssignStudentController {
    private AssignStudentView theView;
    private AssignStudentModel theModel;

    public AssignStudentController(AssignStudentView theView, AssignStudentModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addOkButtonListener(new OkButtonListener());
        this.theView.addBackButtonListener(new BackButtonListener());
    }

    class OkButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                int student_id = theView.getStudentText();
                int project_id = theView.getProjectText();

                Boolean valid = theModel.verify(student_id, project_id);

                if (valid == false) {
                    JOptionPane.showMessageDialog(null, "Invalid Student ID / Project ID");
                    theView.resetText();
                } else {
                    JOptionPane.showMessageDialog(null, "The student id: " + student_id
                            + " is assigned to project " + project_id);
                    theView.redirect();
                }

            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (NumberFormatException e3) {
                // Empty input String error message
                JOptionPane.showMessageDialog(null, "No input (Student ID / Project ID)");
                theView.resetText(); // Set Text field to null and request focus
            }
        }
    }

    class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.redirect(); // Redirect to lecturer's option
        }

    }
}
