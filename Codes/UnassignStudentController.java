import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

// Controller for unassining student from lecturer's project - by Lee Jiang Yoong
public class UnassignStudentController {

    private UnassignStudentView theView;
    private UnassignStudentModel theModel;

    public UnassignStudentController(UnassignStudentView theView, UnassignStudentModel theModel) {

        this.theView = theView;
        this.theModel = theModel;

        this.theView.addOkButtonListener(new OkButtonListener());
        this.theView.addBackButtonListener(new BackButtonListener());
    }

    class OkButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int student_id = theView.getStudentText();
            int project_id = theView.getProjectText();

            try {
                Boolean valid = theModel.verify(student_id, project_id);

                if (valid == false) {
                    JOptionPane.showMessageDialog(null, "Invalid Student ID / Project ID");
                    theView.resetText();
                } else {
                    JOptionPane.showMessageDialog(null, "The student id: " + student_id
                            + " is unassigned to project " + project_id);
                    theView.redirect();
                }

            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (NumberFormatException e2) {
                // Empty input String error message
                JOptionPane.showMessageDialog(null, "No input (Student ID / Project ID)");
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
