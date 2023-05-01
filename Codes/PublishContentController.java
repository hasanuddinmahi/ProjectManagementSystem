import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

// Controller for publishing contents by lecturers - by Yeak Yi Han
public class PublishContentController {
    private PublishContentView theView;
    private PublishContentModel theModel;

    public PublishContentController(PublishContentView theView, PublishContentModel theModel){
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addOkButtonListener(new OkButtonListener());
        this.theView.addBackButtonListener(new BackButtonListener());
    }

    class OkButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                int project_id = theView.getProjectText();
                String content = theView.getContentText();

                Boolean valid = theModel.checkValidity(project_id, content);

                if (valid) {
                    JOptionPane.showMessageDialog(null, "             Published");
                    theView.redirect();
                } else {
                    JOptionPane.showMessageDialog(null, "       Invalid Project ID");
                    theView.resetText();
                }

            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (NumberFormatException e3) {
                // Empty input String error message
                JOptionPane.showMessageDialog(null, "     No input (Project ID)");
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
