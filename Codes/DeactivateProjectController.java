import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

// Controller for deactivating lecturer's project - by Lee Jiang Yoong
public class DeactivateProjectController {

    private DeactivateProjectView theView;
    private DeactivateProjectModel theModel;

    public DeactivateProjectController(DeactivateProjectView theView, DeactivateProjectModel theModel) {
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
                int option = theView.getChoice();

                theModel.checkLecturerProjects();
                theModel.arrange_projects();
                valid = theModel.deactivate_project(option);

            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (NumberFormatException e3) {
                // Empty input String error message
                JOptionPane.showMessageDialog(null, "No input (Project ID)");
            }

            if (valid == false) {
                JOptionPane.showMessageDialog(null, "         Invalid Project ID");
                theView.resetText(); // Set Text field to null and request focus
            } else {
                JOptionPane.showMessageDialog(null, "      Project dectivated!");
                theView.redirect(); // Redirect to lecturer's option
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
