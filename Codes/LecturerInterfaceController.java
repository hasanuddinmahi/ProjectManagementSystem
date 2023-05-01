import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

// Controller for lecturer interface - by Lee Jiang Yoong
public class LecturerInterfaceController {

    private LecturerInterfaceView theView;

    public LecturerInterfaceController(LecturerInterfaceView theView) {

        this.theView = theView;

        this.theView.addOkButtonListener(new OkButtonListener());

    }

    class OkButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            theView.dispose();

            switch (theView.getChoice()) {
                case "1": // View all projects
                    try {
                        DisplayProjectsView theView = new DisplayProjectsView();
                        new DisplayProjectsController(theView);
                        
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "2": // Upload the content
                    try {
                        UploadContentView theView = new UploadContentView();
                        UploadContentModel theModel = new UploadContentModel();
                        new UploadContentController(theView, theModel);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "3": // Publish the content
                    try {
                        PublishContentModel theModel = new PublishContentModel();
                        PublishContentView theView = new PublishContentView(theModel);
                        new PublishContentController(theView, theModel);
                    
                    } catch (IOException e1) {
     
                        e1.printStackTrace();
                    }
                    break;
                case "4": // Modify the content
                try {
                    ModifyModel theModel = new ModifyModel();
                    ModifyView theView = new ModifyView(theModel);
                    new ModifyController(theView, theModel);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
                case "5": // Assign student to their project
                    try {
                        AssignStudentModel theModel = new AssignStudentModel();
                        AssignStudentView theView = new AssignStudentView(theModel);
                        new AssignStudentController(theView, theModel);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "6": // Unassign student to their project
                    try {
                        UnassignStudentModel theModel = new UnassignStudentModel();
                        UnassignStudentView theView = new UnassignStudentView(theModel);
                        new UnassignStudentController(theView, theModel);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "7": // Activate project
                    try {
                        ActivateProjectModel theModel = new ActivateProjectModel();
                        ActivateProjectView theView = new ActivateProjectView(theModel);
                        new ActivateProjectController(theView, theModel);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "8": // Deactivate project
                    try {
                        DeactivateProjectModel theModel = new DeactivateProjectModel();
                        DeactivateProjectView theView = new DeactivateProjectView(theModel);
                        new DeactivateProjectController(theView, theModel);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "9": // Logout
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
