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
import javax.swing.table.DefaultTableModel;

public class StudentProjectView extends JFrame {

    private JFrame frame = new JFrame("");

    private JPanel panel = new JPanel();

    private JLabel title = new JLabel("Your projects");

    private JTable table = new JTable();

    private JScrollPane scroll = new JScrollPane();

    private DefaultTableModel project_table = new DefaultTableModel();

    private JButton back = new JButton("Back");

    public StudentProjectView() throws IOException {
        GUI();
    }

    protected void GUI() throws IOException {
        // Frame
        frame.setSize(550, 550);
        frame.setLocationRelativeTo(null);

        // Panel
        BoxLayout lay = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(lay);

        frame.add(panel);

        ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();
        ArrayList<StudentDetails> student_list = StudentDetails.readStudentList();

        // Table title
        title.setFont(new Font("Courier", Font.BOLD, 14));
        title.setAlignmentX(JLabel.CENTER);
        panel.add(title);

        // Header for table
        project_table.addColumn("Project ID");
        project_table.addColumn("Specialization");
        project_table.addColumn("Project Status");
        project_table.addColumn("Comment");

        // Table content
        for (int i = 0; i < student_list.size(); i++) {

            for (int j = 0; j < project_list.size(); j++) {

                int stu_id = student_list.get(i).getStudentID();
                String status = project_list.get(j).getProjectStatus();
                String stu_specialization = student_list.get(i).getSpecialization();
                String proj_specialization = project_list.get(j).getSpecialization();

                if (User.save_id == stu_id && status.equals("Activated")
                        && stu_specialization.equals(proj_specialization)) {
                    Vector<String> row = new Vector<String>();
                    row.add(project_list.get(j).getProjectIDString());
                    row.add(project_list.get(j).getSpecialization());
                    row.add(project_list.get(j).getProjectStatus());
                    row.add(project_list.get(j).getComment());
                    project_table.addRow(row);
                }
            }

        }

        frame.setVisible(true);

        // Set table
        table.setModel(project_table);

        // Add scroll bar for table
        scroll.getViewport().add(table);
        panel.add(scroll);

        // Back button
        back.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(back);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Redirect to lecturer option
    public void redirect() {

        frame.dispose();

        LecturerInterfaceView theView = new LecturerInterfaceView();
        new LecturerInterfaceController(theView);
        theView.setVisible(true);
    }

    // Back button action listener
    void addBackButtonListener(ActionListener listener) {
        back.addActionListener(listener);
    }
}
