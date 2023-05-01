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

// View for activating lecturer's project - by Lee Jiang Yoong
public class ActivateProjectView extends JFrame {

    private ActivateProjectModel theModel;

    private JFrame frame = new JFrame("Activate project");

    private JPanel panel = new JPanel();

    private JLabel table_title = new JLabel("Project list with deactivated projects");
    private JLabel instruction = new JLabel("Input one project ID to activate");

    private JTable jtable = new JTable();

    private DefaultTableModel table = new DefaultTableModel();

    private JScrollPane scroll = new JScrollPane();

    private JTextField choice = new JTextField();

    private JButton ok = new JButton("OK");
    private JButton back = new JButton("Back");


    ActivateProjectView( ActivateProjectModel theModel ) throws IOException {

        this.theModel = theModel;

        frame.add(panel);

        theModel.lecturer_details.clear(); // avoid adding duplicate lecturer details by clearing the array

        GUI();

    }


    protected void GUI() throws IOException {

        // Frame
        frame.setSize(500, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Panel
        BoxLayout lay = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(lay);

        // Table title
        table_title.setFont(new Font("Courier", Font.BOLD, 14));
        table_title.setAlignmentX(JLabel.CENTER);
        panel.add(table_title);

        // Find deactivated project(s)
        theModel.checkLecturerProjects();
        // Find lecturer's project(s)
        theModel.arrange_projects();

        // Table Model
        table_setup(table, theModel.deactivated_list, theModel.lecturer_details);

        // Set table
        jtable.setModel(table);

        // Add scroll bar
        scroll.getViewport().add(jtable);
        panel.add(scroll);

        // Instruction 
        instruction.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction);

        // Input text field
        choice.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(choice);

        // Ok button
        ok.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(ok);

        // Back button
        back.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(back);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Set up table
    public void table_setup(DefaultTableModel table, ArrayList<ProjectDetails> deactivated_list, 
    ArrayList<LecturerDetails> lecturer_details) {

        table.addColumn("Project ID");
        table.addColumn("Specialization");
        table.addColumn("Comments");

        // Deactivated project list
        // Match deactivated project id with lecturer project id
        for (int i = 0; i < deactivated_list.size(); i++) {
            for (int j = 0; j < lecturer_details.size(); j++) {

                int deactivated_projects = deactivated_list.get(i).getProjectID();

                if (deactivated_projects == lecturer_details.get(j).getProjectID()) {
                    Vector<String> row = new Vector<String>();
                    row.add(deactivated_list.get(i).getProjectIDString());
                    row.add(deactivated_list.get(i).getSpecialization());
                    row.add(deactivated_list.get(i).getComment());
                    table.addRow(row);
                }
            }
        }
    }

    // Get choice from text field
    public int getChoice(){
        return Integer.parseInt( choice.getText() );
    }

    // Set text field to null
    public void resetText(){
        choice.setText(null);
        choice.requestFocus();
    }

    // Redirect to lecturer option
    public void redirect(){
        frame.dispose();
        
        LecturerInterfaceView theView = new LecturerInterfaceView();
        new LecturerInterfaceController(theView);
        theView.setVisible(true);
    }

    // Ok button action listener
    void addOkButtonListener(ActionListener listener){
        ok.addActionListener(listener);
    }

    // Back button action listener
    void addBackButtonListener(ActionListener listener){
        back.addActionListener(listener);
    }
}