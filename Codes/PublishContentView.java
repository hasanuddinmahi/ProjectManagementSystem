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

// View for publishing contents by lecturers - by Yeak Yi Han
public class PublishContentView extends JFrame{

    private PublishContentModel theModel;

    private JFrame frame = new JFrame("Publish content");
    private JPanel panel = new JPanel();

    private JLabel title = new JLabel("Projects contents");
    private JLabel instruction = new JLabel("Project ID");
    private JLabel instruction2 = new JLabel("Content");
    private JTable table = new JTable();
    private JScrollPane scroll = new JScrollPane();
    private DefaultTableModel content_table = new DefaultTableModel();

    private JTextField projectID_text = new JTextField();
    private JTextField content_text = new JTextField();
    private JButton ok = new JButton("OK");
    private JButton back = new JButton("Back");
    

    public PublishContentView(PublishContentModel theModel) throws IOException{

        this.theModel = theModel;

        theModel.lecturer_details.clear();

        GUI();
    }

    protected void GUI() throws IOException{
        // Frame
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        // Panel
        BoxLayout lay = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(lay);

        frame.add(panel);

        // Table title
        title.setFont(new Font("Courier", Font.BOLD, 14));
        title.setAlignmentX(JLabel.CENTER);
        panel.add(title);

        // Header for table
        content_table.addColumn("Project ID");
        content_table.addColumn("Content Status");
        content_table.addColumn("Status");

        // Table content
        ArrayList<ContentDetails> content_list = ContentDetails.readContentDetails();

        theModel.checkLecturerProjects();

        for (int i = 0; i < theModel.lecturer_details.size(); i++) {

            for (int j = 0; j < content_list.size(); j++){

                if ( theModel.lecturer_details.get(i).getProjectID() == content_list.get(j).getProjectID() ){
                    Vector<String> row = new Vector<String>();
                    row.add(content_list.get(j).getProjectIDString());
                    row.add(content_list.get(j).getContent());
                    row.add(content_list.get(j).getContentStatus());
                    content_table.addRow(row);
                }
            }
        }

        // Set table 
        table.setModel(content_table);

        // Add scroll bar for table 
        scroll.getViewport().add(table);
        panel.add(scroll);

        // Instruction
        instruction.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction);

        // Project ID text field
        projectID_text.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(projectID_text);

        // Instruction
        instruction2.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction2);
        
        // Project ID text field
        content_text.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(content_text);

        // Ok button
        ok.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(ok);

        // Back button
        back.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(back);

        frame.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    // Get project id from text field
    public int getProjectText() {
        return Integer.parseInt(projectID_text.getText());
    }

        // Get project id from text field
        public String getContentText() {
            return content_text.getText();
        }

    // Set text field to null
    public void resetText() {
        projectID_text.setText("");
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
