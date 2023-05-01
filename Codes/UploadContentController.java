import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

public class UploadContentController {
    
    private UploadContentView theView;
    private UploadContentModel theModel;

    public UploadContentController(UploadContentView theView, UploadContentModel theModel){
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addOkButtonListener(new OkButtonListener());
        this.theView.addBackButtonListener(new BackButtonListener());
    }

    class OkButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String project_content = theView.getContentText();
                int project_id = theView.getProjectText();

                Boolean valid = theModel.checkProjectID(project_id, project_content);

                if (valid) {
                    JOptionPane.showMessageDialog(null, "              Uploaded");
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
