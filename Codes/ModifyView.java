import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// View for Modify Project content
// Ahmed Adam
public class ModifyView extends JFrame{

    private ModifyModel theModel;

    private JFrame frame = new JFrame("Modify project content");

    private JPanel panel = new JPanel();

    private JLabel table_title = new JLabel("Project list");
    private JLabel instruction = new JLabel("Input one project ID to modify");
    private JLabel instruction2 = new JLabel("Enter new content");

    private JTable jtable = new JTable();

    private DefaultTableModel table = new DefaultTableModel();

    private JScrollPane scroll = new JScrollPane();

    private JTextField choice = new JTextField();
    private JTextField new_content = new JTextField();

    private JButton ok = new JButton("OK");
    private JButton back = new JButton("Back");

    public ModifyView(ModifyModel theModel) throws IOException {

        this.theModel = theModel;
        
        frame.add(panel);

        theModel.lecturer_details.clear(); // avoid adding duplicate lecturer details by clearing the array

        GUI();

    }

    protected void GUI() throws IOException {

        // Frame
        frame.setSize(500, 550);
        frame.setLocationRelativeTo(null);

        // Panel
        BoxLayout lay = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(lay);

        frame.add(panel);

        // Table title
        table_title.setFont(new Font("Courier", Font.BOLD, 14));
        table_title.setAlignmentX(JLabel.CENTER);
        panel.add(table_title);

        theModel.checkLecturerProjects();

        table_setup(table, theModel.lecturer_details);

        frame.setVisible(true);

        // Set table
        jtable.setModel(table);

        // Add scroll bar
        scroll.getViewport().add(jtable);
        panel.add(scroll);

        instruction.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction);

        choice.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(choice);

        instruction2.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction2);

        new_content.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(new_content);

        // Ok button
        ok.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(ok);

        // Back button
        back.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(back);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   // Set up table
   public void table_setup(DefaultTableModel table, ArrayList<LecturerDetails> lecturer_details) throws IOException {

    ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();
    ArrayList<ContentDetails> content_project_list = ContentDetails.readContentDetails();
    
    table.addColumn("Project ID");
    table.addColumn("Specialization");
    table.addColumn("Contents");
    table.addColumn("Content Status");

    for (int i = 0; i < content_project_list.size(); i++) {
        for (int j = 0; j < lecturer_details.size(); j++) {

            int project = content_project_list.get(i).getProjectID();

            if (project == lecturer_details.get(j).getProjectID() ) {
                Vector<String> new_row = new Vector<String>();
                new_row.add(project_list.get(j).getProjectIDString());
                new_row.add(project_list.get(j).getSpecialization());
                new_row.add(content_project_list.get(i).getContent());
                new_row.add(content_project_list.get(i).getContentStatus());
                table.addRow(new_row);
            }
        }
    }
}    

    // Get choice from text field
    public int getChoice() {
        return Integer.parseInt(choice.getText());
    }

    public String getNewContent(){
        return new_content.getText();
    }

    // Set text field to null
    public void resetText() {
        choice.setText(null);
        choice.requestFocus();
    }


    // Redirect to lecturer option
    public void redirect() {

        frame.dispose();

        LecturerInterfaceView theView = new LecturerInterfaceView();
        new LecturerInterfaceController(theView);
        theView.setVisible(true);
    }

    // Ok button action listener
    void addOkButtonListener(ActionListener listener) {
        ok.addActionListener(listener);
    }

    // Back button action listener
    void addBackButtonListener(ActionListener listener) {
        back.addActionListener(listener);
    }

}
