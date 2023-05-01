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

// View for assigning student to lecturer's project - By Lee Jiang Yoong
public class AssignStudentView extends JFrame {

    private AssignStudentModel theModel;

    private JFrame frame = new JFrame("Assign student to a project");

    private JPanel panel = new JPanel();

    private JLabel title1 = new JLabel("Student List");
    private JLabel title2 = new JLabel("Student(s) that assgined to your project(s)");
    private JLabel title3 = new JLabel("Your Project List");

    private JLabel instruction = new JLabel("Input one student ID to assign");
    private JLabel instruction2 = new JLabel("Input one project ID to be assigned");

    private JTable table1 = new JTable();
    private JTable table2 = new JTable();
    private JTable table3 = new JTable();

    private JScrollPane scroll1 = new JScrollPane();
    private JScrollPane scroll2 = new JScrollPane();
    private JScrollPane scroll3 = new JScrollPane();

    private DefaultTableModel student_table = new DefaultTableModel();
    private DefaultTableModel assign_table = new DefaultTableModel();
    private DefaultTableModel project_table = new DefaultTableModel();

    private JTextField student_text = new JTextField();
    private JTextField project_text = new JTextField();
    private JButton ok = new JButton("OK");
    private JButton back = new JButton("Back");

    ArrayList<LecturerDetails> lec_project_list = LecturerDetails.readLecturerDetails();
    ArrayList<AssignmentList> assignment_list = AssignmentList.readAssignmentList();
    ArrayList<StudentDetails> student_list = StudentDetails.readStudentList();
    ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();

    public AssignStudentView(AssignStudentModel theModel) throws IOException {

        this.theModel = theModel;

        GUI();
    }

    protected void GUI() throws IOException {

        // Frame
        frame.setSize(700, 820);
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
        student_table.addColumn("Student ID");
        student_table.addColumn("Specialization");

        // Table 1 content
        ArrayList<StudentDetails> student_list = StudentDetails.readStudentList();

        for (int i = 0; i < student_list.size(); i++) {
            Vector<String> row = new Vector<String>();
            row.add(student_list.get(i).getStudentIDString());
            row.add(student_list.get(i).getSpecialization());
            student_table.addRow(row);
        }

        // Set table 1
        table1.setModel(student_table);

        // Add scroll bar for table 1
        scroll1.getViewport().add(table1);
        panel.add(scroll1);

        // Table 2 title
        title2.setFont(new Font("Courier", Font.BOLD, 14));
        title2.setAlignmentX(JLabel.CENTER);
        panel.add(title2);

        // Header for table 2
        assign_table.addColumn("Student ID");
        assign_table.addColumn("Project ID");

        theModel.checkLecturerProjects();

        // Table 2 content
        ArrayList<AssignmentList> assignment_list = AssignmentList.readAssignmentList();

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

        frame.setVisible(true);

        // Set table 2
        table2.setModel(assign_table);

        // Add scroll bar for table 2
        scroll2.getViewport().add(table2);
        panel.add(scroll2);

        // Table title 3
        title3.setFont(new Font("Courier", Font.BOLD, 14));
        title3.setAlignmentX(JLabel.CENTER);
        panel.add(title3);

        // Header for table 3
        project_table.addColumn("Project ID");
        project_table.addColumn("Specialization");
        project_table.addColumn("Comment");

        // Table 3 content
        for (int i = 0; i < theModel.lecturers_project.size(); i++) {
            for (int j = 0; j < project_list.size(); j++) {
                if (theModel.lecturers_project.get(i).getProjectID() == project_list.get(j).getProjectID()) {
                    Vector<String> row = new Vector<String>();
                    row.add(project_list.get(j).getProjectIDString());
                    row.add(project_list.get(j).getSpecialization());
                    row.add(project_list.get(j).getComment());
                    project_table.addRow(row);
                }
            }
        }

        frame.setVisible(true);

        // Set table 3
        table3.setModel(project_table);

        // Add scroll bar for table 3
        scroll3.getViewport().add(table3);
        panel.add(scroll3);

        // Instruction 1 label
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
