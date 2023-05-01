import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controller for displaying projects - by Yeak Yi Han
public class DisplayProjectsController {
    DisplayProjectsView theView;

    public DisplayProjectsController(DisplayProjectsView theView){
        this.theView = theView;

        this.theView.addBackButtonListener(new BackButtonListener());
    }

    class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.redirect(); // Redirect to lecturer's option
        }

    }
}
