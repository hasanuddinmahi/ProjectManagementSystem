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

// View for unassining student from lecturer's project - by Lee Jiang Yoong
public class UnassignStudentView extends JFrame {

    private UnassignStudentModel theModel;

    private JFrame frame = new JFrame("Unassign student from a project");

    private JPanel panel = new JPanel();

    private JLabel title = new JLabel("Assign List");

    private JTable table1 = new JTable();

    private JScrollPane scroll1 = new JScrollPane();

    private JLabel instruction = new JLabel("Input one student ID to unassign");
    private JLabel instruction2 = new JLabel("Input one project ID to be unassigned");

    private JTextField student_text = new JTextField();
    private JTextField project_text = new JTextField();

    private DefaultTableModel assign_table = new DefaultTableModel();

    private JButton ok = new JButton("OK");
    private JButton back = new JButton("Back");

    ArrayList<AssignmentList> assignment_list = AssignmentList.readAssignmentList();

    public UnassignStudentView(UnassignStudentModel theModel) throws IOException {

        this.theModel = theModel;

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

        frame.add(panel);

        // Table title
        title.setFont(new Font("Courier", Font.BOLD, 14));
        title.setAlignmentX(JLabel.CENTER);
        panel.add(title);

        // Header
        assign_table.addColumn("Student ID");
        assign_table.addColumn("Project ID");

        theModel.checkLecturerProjects();

        // Table content
        for (int i = 0; i < theModel.lecturers_project.size(); i++) {
            for (int j = 0; j < assignment_list.size(); j++) {
                if (theModel.lecturers_project.get(i).getProjectID() == assignment_list.get(j).getProjectID()) {
                    Vector<String> row = new Vector<String>();
                    row.add(assignment_list.get(j).getStudentIDString());
                    row.add(assignment_list.get(j).getProjectIDString());
                    assign_table.addRow(row);
                }
            }
        }

        // Set table
        table1.setModel(assign_table);

        // Add scroll bar
        scroll1.getViewport().add(table1);
        panel.add(scroll1);

        // Instruction label
        instruction.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction);

        // Student_id text field
        student_text.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(student_text);

        // Instruction 2 label
        instruction2.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction2);

        // Project_id text field
        project_text.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(project_text);

        // OK button
        ok.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(ok);

        // Back button
        back.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(back);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Get student id from text field
    public int getStudentText() {
        return Integer.parseInt(student_text.getText());
    }

    // Get project id from text field
    public int getProjectText() {
        return Integer.parseInt(project_text.getText());
    }

    // Set text field to null
    public void resetText() {
        student_text.setText("");
        project_text.setText("");
        student_text.requestFocus();
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
