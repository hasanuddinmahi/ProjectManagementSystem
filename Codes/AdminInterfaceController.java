import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// Controller for admin interface - by Lee Jiang Yoong
public class AdminInterfaceController {

    private static final String FILE_PATH = "ProjectDetails.csv"; // we use ProjectDetails.csv
    private AdminInterfaceView adminView;

    public AdminInterfaceController(AdminInterfaceView theView) {
        this.adminView = theView;

        this.adminView.addOkButtonListener(new OkButtonListener());
    }

    class OkButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            adminView.dispose();

            switch (adminView.getChoice()) {
                case "1": // Register an account
                try {
                    RegisterAccountModel theModel = new RegisterAccountModel();
                    RegisterAccountView theView = new RegisterAccountView();
                    new RegisterAccountController(theView, theModel);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
                case "2": // View all projects - by MD Hasan Uddin Mahi
                    try {
                        DisplayAllProjectsView theView = new DisplayAllProjectsView();
                        new DisplayAllProjectsController(theView);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "3": // Add a project - by MD Hasan Uddin Mahi
                    try {
                        new AddProject();
                    } catch (NumberFormatException | IOException e1) {
                        e1.printStackTrace();
                    }

                    adminView.dispose();

                    break;
                case "4": // Delete a project - by MD Hasan Uddin Mahi
                    String removeId = JOptionPane.showInputDialog(null, "Enter the ID of the project : ");
                    if (!removeId.isEmpty()) {
                        AddDeleteModel.removeProject(FILE_PATH, removeId);

                        adminView.dispose();

                        AdminInterfaceView adminView2 = new AdminInterfaceView();
                        new AdminInterfaceController(adminView2);
                        adminView2.setVisible(true);
                    }
                    break;
                case "5": // Leave comments
                    try {
                        CommentModel theModel = new CommentModel();
                        CommentView theView = new CommentView();
                        new CommentController(theView, theModel);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "6": // View reports
                    try {
                        ViewReportsView theView = new ViewReportsView();
                        new ViewReportsController(theView);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "7": // Logout
                    LoginModel theModel = new LoginModel();
                    LoginView theView = new LoginView();
                    new LoginController(theView, theModel);

                    theView.setVisible(true);
                    break;
                case "": // Empty input String error message
                    JOptionPane.showMessageDialog(null, "  Please select an option!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "           Invalid option");
                    break;
            }

            adminView.resetText();
        }
    }
}
