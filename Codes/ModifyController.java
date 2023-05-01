import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

// Controller for Modify Project content
// Ahmed Adam
public class ModifyController {

    private ModifyView theView;
    private ModifyModel theModel;

    public ModifyController(ModifyView theView, ModifyModel theModel) {
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
                String input_new_content = theView.getNewContent();

                valid = theModel.modifyContent(option, input_new_content);

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
                JOptionPane.showMessageDialog(null, "      Project content modified!");
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
