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

// View for uploading contents by lecturers - by Yeak Yi Han
public class UploadContentView extends JFrame {

    private JFrame frame = new JFrame("Upload Content");

    private JPanel panel = new JPanel();

    private JLabel title1 = new JLabel("Projects content");
    private JLabel title2 = new JLabel("All projects");

    private JLabel instruction1 = new JLabel("Project ID");
    private JLabel instruction2 = new JLabel("Content");

    private JTable table1 = new JTable();
    private JTable table2 = new JTable();

    private JScrollPane scroll1 = new JScrollPane();
    private JScrollPane scroll2 = new JScrollPane();

    private DefaultTableModel content_table = new DefaultTableModel();
    private DefaultTableModel project_table = new DefaultTableModel();

    private JTextField projectID_text = new JTextField();
    private JTextField content_text = new JTextField();

    private JButton ok = new JButton("OK");
    private JButton back = new JButton("Back");

    public UploadContentView() throws IOException {
        GUI();
    }

    protected void GUI() throws IOException {
        // Frame
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);

        // Panel
        BoxLayout lay = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(lay);

        frame.add(panel);

        // Table 1 title
        title1.setFont(new Font("Courier", Font.BOLD, 14));
        title1.setAlignmentX(JLabel.CENTER);
        panel.add(title1);

        // Header for table 1
        content_table.addColumn("Project ID");
        content_table.addColumn("Content Status");
        content_table.addColumn("Status");

        // Table 1 content
        ArrayList<ContentDetails> content_list = ContentDetails.readContentDetails();
        ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();

        for (int i = 0; i < content_list.size(); i++) {

            Vector<String> row = new Vector<String>();
            row.add(content_list.get(i).getProjectIDString());
            row.add(content_list.get(i).getContent());
            row.add(content_list.get(i).getContentStatus());
            content_table.addRow(row);

        }

        // Set table 1
        table1.setModel(content_table);

        // Add scroll bar for table 1
        scroll1.getViewport().add(table1);
        panel.add(scroll1);

        // Table 2 title
        title2.setFont(new Font("Courier", Font.BOLD, 14));
        title2.setAlignmentX(JLabel.CENTER);
        panel.add(title2);

        // Header for table 2
        project_table.addColumn("Project ID");
        project_table.addColumn("Specialization");
        project_table.addColumn("Project Status");
        project_table.addColumn("Comment");

        // Table 2 content
        for (int i = 0; i < project_list.size(); i++) {

            Vector<String> row = new Vector<String>();
            row.add(project_list.get(i).getProjectIDString());
            row.add(project_list.get(i).getSpecialization());
            row.add(project_list.get(i).getProjectStatus());
            row.add(project_list.get(i).getComment());
            project_table.addRow(row);

        }

        frame.setVisible(true);

        // Set table 2
        table2.setModel(project_table);

        // Add scroll bar for table 2
        scroll2.getViewport().add(table2);
        panel.add(scroll2);

        // Instruction 1
        instruction1.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction1);

        // Project ID text field
        projectID_text.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(projectID_text);

        // Instruction 2
        instruction2.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction2);

        // Content text field
        content_text.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(content_text);

        // Ok button
        ok.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(ok);

        // Back button
        back.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(back);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Get project id from text field
    public int getProjectText() {
        return Integer.parseInt(projectID_text.getText());
    }

    public String getContentText(){
        return content_text.getText();
    }

    // Set text field to null
    public void resetText() {
        projectID_text.setText("");
        content_text.setText("");
        projectID_text.requestFocus();
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
