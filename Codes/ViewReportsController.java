import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controller of View project reports
// Ahmed Adam
public class ViewReportsController {

    private ViewReportsView theView;

    public ViewReportsController(ViewReportsView theView) {

        this.theView = theView;

        this.theView.addNextButtonListener(new addNextButtonListener());
        this.theView.addBackButtonListener(new BackButtonListener());
        this.theView.addBackPageButtonListener(new addBackPageButtonListener());

    }

    class addNextButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.nextPage(); // Go to next page
        }
    }

    class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.redirect(); // Redirect to admin's option
        }
    }
    
    class addBackPageButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.backPage(); 
        }
    }
}