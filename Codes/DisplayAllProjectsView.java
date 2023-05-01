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

public class DisplayAllProjectsView extends JFrame {

    private JFrame frame = new JFrame("");

    private JPanel panel = new JPanel();

    private JLabel title = new JLabel("Activated projects");

    private JTable table = new JTable();

    private JScrollPane scroll = new JScrollPane();

    private DefaultTableModel project_table = new DefaultTableModel();

    private JButton back = new JButton("Back");

    public DisplayAllProjectsView() throws IOException {
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
        for (int i = 0; i < project_list.size(); i++) {

            Vector<String> row = new Vector<String>();
            row.add(project_list.get(i).getProjectIDString());
            row.add(project_list.get(i).getSpecialization());
            row.add(project_list.get(i).getProjectStatus());
            row.add(project_list.get(i).getComment());
            project_table.addRow(row);

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

        AdminInterfaceView theView = new AdminInterfaceView();
        new AdminInterfaceController(theView);
        theView.setVisible(true);
    }

    // Back button action listener
    void addBackButtonListener(ActionListener listener) {
        back.addActionListener(listener);
    }
}
