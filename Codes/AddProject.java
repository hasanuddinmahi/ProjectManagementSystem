import java.io.IOException;

import javax.swing.JOptionPane;

public class AddProject {

    private static final String FILE_PATH = "ProjectDetails.csv";

    public AddProject() throws NumberFormatException, IOException{

        String p_id = JOptionPane.showInputDialog(null, "Enter the unique id: ");
        String name = JOptionPane.showInputDialog(null, "Enter the specialization name: ");
        String describe = JOptionPane.showInputDialog(null, "Decribe the project here: ");
        String lec_id = JOptionPane.showInputDialog(null, "Assign this project to a lecturer (Input lecturer ID)");

        AddDeleteModel.addDataToCSV(FILE_PATH, p_id, name, describe);

        AddDeleteModel.assign( Integer.parseInt(lec_id), Integer.parseInt(p_id));
    
        AdminInterfaceView adminView1 = new AdminInterfaceView();
        new AdminInterfaceController(adminView1);
        adminView1.setVisible(true);
    }
}
