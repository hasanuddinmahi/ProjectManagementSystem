import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentProjectController {
    StudentProjectView theView;

    public StudentProjectController(StudentProjectView theView){
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
