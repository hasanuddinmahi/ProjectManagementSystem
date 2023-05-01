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

// View for Comment on Project
// Ahmed Adam
public class CommentView extends JFrame{

    private JFrame frame = new JFrame("Leave a comment");

    private JPanel panel = new JPanel();

    private JLabel table_title = new JLabel("Project list");
    private JLabel instruction = new JLabel("Input one project ID to comment on");
    private JLabel instruction2 = new JLabel("Leave comment");

    private JTable jtable = new JTable();

    private DefaultTableModel table = new DefaultTableModel();

    private JScrollPane scroll = new JScrollPane();

    private JTextField choice = new JTextField();
    private JTextField comment = new JTextField();

    private JButton ok = new JButton("OK");
    private JButton back = new JButton("Back");

    public CommentView() throws IOException {
        
        frame.add(panel);

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

        table_setup(table);

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

        comment.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(comment);

        // Ok button
        ok.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(ok);

        // Back button
        back.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(back);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   // Set up table
   public void table_setup(DefaultTableModel table) throws IOException {

    ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();

    table.addColumn("Project ID");
    table.addColumn("Specialization");
    table.addColumn("Comments");

    for (int i = 0; i < project_list.size(); i++) {
        Vector<String> new_row = new Vector<String>();
        new_row.add(project_list.get(i).getProjectIDString());
        new_row.add(project_list.get(i).getSpecialization());
        new_row.add(project_list.get(i).getComment());
        table.addRow(new_row);

    }
}    

    // Get choice from text field
    public int getChoice() {
        return Integer.parseInt(choice.getText());
    }

    public String getComment(){
        return comment.getText();
    }

    // Set text field to null
    public void resetText() {
        choice.setText(null);
        choice.requestFocus();
    }


    // Redirect to lecturer option
    public void redirect() {

        frame.dispose();

        AdminInterfaceView theView = new AdminInterfaceView();
        new AdminInterfaceController(theView);
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
