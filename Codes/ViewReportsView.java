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

// View of View project reports
// Ahmed Adam
public class ViewReportsView extends JFrame {

    private JLabel table_title;

    JButton next = new JButton("Next");
    JButton back = new JButton("Back");
    JButton backpage = new JButton("Back");

    private JFrame frame = new JFrame("View Reports");

    private JPanel panel = new JPanel();

    ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();
    ArrayList<ContentDetails> content_project_list = ContentDetails.readContentDetails();
    ArrayList<AssignmentList> assignment_list = AssignmentList.readAssignmentList();

    public ViewReportsView() throws IOException {

        frame.add(panel);

        GUI();
    }

    protected void GUI() throws IOException {

        // Frame
        frame.setSize(500, 650);
        frame.setLocationRelativeTo(null);

        // Panel
        BoxLayout lay = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(lay);

        frame.add(panel);

        // Table 1 title:
        // list of projects entered into the system
        table_title = new JLabel("List of projects entered into the system:");
        table_title.setFont(new Font("Courier", Font.BOLD, 14));
        table_title.setAlignmentX(JLabel.CENTER);
        panel.add(table_title);

        DefaultTableModel table1 = new DefaultTableModel();
        table1_setup(table1);

        frame.setVisible(true);

        // Set table
        JTable jtable1 = new JTable();
        jtable1.setModel(table1);

        // Add scroll bar
        JScrollPane scroll1 = new JScrollPane();
        scroll1.getViewport().add(jtable1);
        panel.add(scroll1);

        // Table 2 title:
        // list of projects according to specialization
        table_title = new JLabel("List of projects according to specialization:");
        table_title.setFont(new Font("Courier", Font.BOLD, 14));
        table_title.setAlignmentX(JLabel.CENTER);
        panel.add(table_title);

        DefaultTableModel table2 = new DefaultTableModel();
        table2_setup(table2);

        frame.setVisible(true);

        // Set table
        JTable jtable2 = new JTable();
        jtable2.setModel(table2);

        // Add scroll bar
        JScrollPane scroll2 = new JScrollPane();
        scroll2.getViewport().add(jtable2);
        panel.add(scroll2);

        // Table 3 title:
        // list of projects according to lecturers
        table_title = new JLabel("List of projects according to lecturers:");
        table_title.setFont(new Font("Courier", Font.BOLD, 14));
        table_title.setAlignmentX(JLabel.CENTER);
        panel.add(table_title);

        DefaultTableModel table3 = new DefaultTableModel();
        table3_setup(table3);

        frame.setVisible(true);

        // Set table
        JTable jtable3 = new JTable();
        jtable3.setModel(table3);

        // Add scroll bar
        JScrollPane scroll3 = new JScrollPane();
        scroll3.getViewport().add(jtable3);
        panel.add(scroll3);

        // Table 4 title:
        // list of inactive projects
        table_title = new JLabel("List of inactive projects:");
        table_title.setFont(new Font("Courier", Font.BOLD, 14));
        table_title.setAlignmentX(JLabel.CENTER);
        panel.add(table_title);

        DefaultTableModel table4 = new DefaultTableModel();
        table4_setup(table4);

        frame.setVisible(true);

        // Set table
        JTable jtable4 = new JTable();
        jtable4.setModel(table4);

        // Add scroll bar
        JScrollPane scroll4 = new JScrollPane();
        scroll4.getViewport().add(jtable4);
        panel.add(scroll4);

        back.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(back);

        next.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(next);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected void GUI2() throws IOException {

        // Frame
        frame = new JFrame("View Reports");
        frame.setSize(500, 650);
        frame.setLocationRelativeTo(null);

        // Panel
        JPanel panel = new JPanel();
        BoxLayout lay = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(lay);

        frame.add(panel);

        // Table 5 title:
        // list of active projects
        table_title = new JLabel("List of active projects:");
        table_title.setFont(new Font("Courier", Font.BOLD, 14));
        table_title.setAlignmentX(JLabel.CENTER);
        panel.add(table_title);

        DefaultTableModel table5 = new DefaultTableModel();
        table5_setup(table5);

        frame.setVisible(true);

        // Set table
        JTable jtable5 = new JTable();
        jtable5.setModel(table5);

        // Add scroll bar
        JScrollPane scroll5 = new JScrollPane();
        scroll5.getViewport().add(jtable5);
        panel.add(scroll5);

        // Table 6 title:
        // list of projects assigned to students
        table_title = new JLabel("List of projects assigned to students:");
        table_title.setFont(new Font("Courier", Font.BOLD, 14));
        table_title.setAlignmentX(JLabel.CENTER);
        panel.add(table_title);

        DefaultTableModel table6 = new DefaultTableModel();
        table6_setup(table6);

        frame.setVisible(true);

        // Set table
        JTable jtable6 = new JTable();
        jtable6.setModel(table6);

        // Add scroll bar
        JScrollPane scroll6 = new JScrollPane();
        scroll6.getViewport().add(jtable6);
        panel.add(scroll6);

        // Table 7 title:
        // list of project un-assign to students
        table_title = new JLabel("List of project un-assign to students:");
        table_title.setFont(new Font("Courier", Font.BOLD, 14));
        table_title.setAlignmentX(JLabel.CENTER);
        panel.add(table_title);

        DefaultTableModel table7 = new DefaultTableModel();
        table7_setup(table7);

        frame.setVisible(true);

        // Set table
        JTable jtable7 = new JTable();
        jtable7.setModel(table7);

        // Add scroll bar
        JScrollPane scroll7 = new JScrollPane();
        scroll7.getViewport().add(jtable7);
        panel.add(scroll7);

        // Table 8 title:
        // list of projects with comment
        table_title = new JLabel("List of projects with comment:");
        table_title.setFont(new Font("Courier", Font.BOLD, 14));
        table_title.setAlignmentX(JLabel.CENTER);
        panel.add(table_title);

        DefaultTableModel table8 = new DefaultTableModel();
        table8_setup(table8);

        frame.setVisible(true);

        // Set table
        JTable jtable8 = new JTable();
        jtable8.setModel(table8);

        // Add scroll bar
        JScrollPane scroll8 = new JScrollPane();
        scroll8.getViewport().add(jtable8);
        panel.add(scroll8);

        backpage.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(backpage);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Set up table 1:
    // list of projects entered into the system
    public void table1_setup(DefaultTableModel table1) {
        table1.addColumn("Project ID");
        table1.addColumn("Contents");

        for (int i = 0; i < content_project_list.size(); i++) {
            Vector<String> new_row = new Vector<String>();
            new_row.add(content_project_list.get(i).getProjectIDString());
            new_row.add(content_project_list.get(i).getContent());
            table1.addRow(new_row);
        }
    }

    // Set up table 2:
    // list of projects according to specialization
    public void table2_setup(DefaultTableModel table2) {
        table2.addColumn("Project ID");
        table2.addColumn("Specialization");

        for (int i = 0; i < project_list.size(); i++) {
            Vector<String> new_row = new Vector<String>();
            new_row.add(project_list.get(i).getProjectIDString());
            new_row.add(project_list.get(i).getSpecialization());
            table2.addRow(new_row);
        }
    }

    // Set up table 3:
    // list of projects according to lecturers
    public void table3_setup(DefaultTableModel table3) {
        table3.addColumn("Project ID");
        table3.addColumn("Lecturer ID");

        for (int i = 0; i < content_project_list.size(); i++) {
            Vector<String> new_row = new Vector<String>();
            new_row.add(content_project_list.get(i).getProjectIDString());
            new_row.add(content_project_list.get(i).getLecturerIDString());
            table3.addRow(new_row);
        }
    }

    // Set up table 4:
    // list of inactive projects
    public void table4_setup(DefaultTableModel table4) {
        table4.addColumn("Project ID");
        table4.addColumn("Status");

        for (int i = 0; i < project_list.size(); i++) {

            String project_status = project_list.get(i).getProjectStatus();

            if (project_status.equals("Deactivated")) {
                Vector<String> new_row = new Vector<String>();
                new_row.add(project_list.get(i).getProjectIDString());
                new_row.add(project_list.get(i).getProjectStatus());
                table4.addRow(new_row);
            }
        }
    }

    // Set up table 5:
    // list of active projects
    public void table5_setup(DefaultTableModel table5) {
        table5.addColumn("Project ID");
        table5.addColumn("Status");

        for (int i = 0; i < project_list.size(); i++) {

            String project_status = project_list.get(i).getProjectStatus();

            if (project_status.equals("Activated")) {
                Vector<String> new_row = new Vector<String>();
                new_row.add(project_list.get(i).getProjectIDString());
                new_row.add(project_list.get(i).getProjectStatus());
                table5.addRow(new_row);
            }
        }
    }

    // Set up table 6:
    // list of projects assigned to students
    public void table6_setup(DefaultTableModel table6) {
        table6.addColumn("Project ID");
        table6.addColumn("Student ID");

        for (int i = 0; i < assignment_list.size(); i++) {
            Vector<String> new_row = new Vector<String>();
            new_row.add(assignment_list.get(i).getProjectIDString());
            new_row.add(assignment_list.get(i).getStudentIDString());
            table6.addRow(new_row);
        }
    }

    // Set up table 7:
    // list of projects not assigned to students
    public void table7_setup(DefaultTableModel table7) {
        table7.addColumn("Project ID");
        table7.addColumn("Contents");

        Boolean compare = false;

        for (int i = 0; i < content_project_list.size(); i++) {
            for (int j = 0; j < assignment_list.size(); j++) {

                int assigned_id = assignment_list.get(j).getProjectID();
                int project_id = content_project_list.get(i).getProjectID();

                if (project_id == assigned_id) {
                    compare = false;
                    break;
                } else if (project_id != assigned_id) {
                    compare = true;
                }

            }
            if (compare == true) {
                Vector<String> new_row = new Vector<String>();
                new_row.add(content_project_list.get(i).getProjectIDString());
                new_row.add(content_project_list.get(i).getContent());
                table7.addRow(new_row);
            }
        }
    }

    // Set up table 8:
    // list of projects with comment
    public void table8_setup(DefaultTableModel table8) {
        table8.addColumn("Project ID");
        table8.addColumn("Comment");

        for (int i = 0; i < project_list.size(); i++) {

            String project_comment = project_list.get(i).getComment();

            if (!project_comment.equals("-")) {
                Vector<String> new_row = new Vector<String>();
                new_row.add(project_list.get(i).getProjectIDString());
                new_row.add(project_list.get(i).getComment());
                table8.addRow(new_row);
            }
        }
    }

    public void redirect() {

        frame.dispose();

        AdminInterfaceView theView = new AdminInterfaceView();
        new AdminInterfaceController(theView);
        theView.setVisible(true);
    }

    public void nextPage() {
        frame.dispose();
        try {
            GUI2();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void backPage() {
        try {
            frame.dispose();
            ViewReportsView theView = new ViewReportsView();
            new ViewReportsController(theView);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Ok button action listener
    void addNextButtonListener(ActionListener listener) {
        next.addActionListener(listener);
    }

    // Back button action listener
    void addBackButtonListener(ActionListener listener) {
        back.addActionListener(listener);
    }

    void addBackPageButtonListener(ActionListener listener) {
        backpage.addActionListener(listener);
    }
}
