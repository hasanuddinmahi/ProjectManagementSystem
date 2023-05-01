import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;

// View for deactivating lecturer's project - by Lee Jiang Yoong
public class LecturerInterfaceView extends JFrame {

    JPanel panel = new JPanel();

    private JLabel title = new JLabel("Select an option:");

    private JLabel option1 = new JLabel("1. View available projects");
    private JLabel option2 = new JLabel("2. Upload the content");
    private JLabel option3 = new JLabel("3. Publish the content");
    private JLabel option4 = new JLabel("4. Modify the content");
    private JLabel option5 = new JLabel("5. Assign student to the project");
    private JLabel option6 = new JLabel("6. Unassign student to the project");
    private JLabel option7 = new JLabel("7. Activate project from viewboard");
    private JLabel option8 = new JLabel("8. Deactivate project from viewboard");
    private JLabel option9 = new JLabel("9. Logout");
    
    private JLabel arrow = new JLabel("-> ");

    private JTextField choice = new JTextField(1);

    private JButton ok = new JButton("OK");

    public LecturerInterfaceView() {
        // Window's title
        super("Lecturer Interface");

        GUI();
    }

    protected void GUI() {

        // Set Font
        title.setFont(new Font("Courier", Font.BOLD, 15));
        option1.setFont(new Font("Courier", Font.BOLD, 15));
        option2.setFont(new Font("Courier", Font.BOLD, 15));
        option3.setFont(new Font("Courier", Font.BOLD, 15));
        option4.setFont(new Font("Courier", Font.BOLD, 15));
        option5.setFont(new Font("Courier", Font.BOLD, 15));
        option6.setFont(new Font("Courier", Font.BOLD, 15));
        option7.setFont(new Font("Courier", Font.BOLD, 15));
        option8.setFont(new Font("Courier", Font.BOLD, 15));
        option9.setFont(new Font("Courier", Font.BOLD, 15));
        choice.setFont(new Font("Courier", Font.BOLD, 15));
        ok.setFont(new Font("Courier", Font.BOLD, 13));

        // Set Position
        title.setBounds(105, 0, 400, 20);
        option1.setBounds(10, 20, 400, 20);
        option2.setBounds(10, 40, 400, 20);
        option3.setBounds(10, 60, 400, 20);
        option4.setBounds(10, 80, 400, 20);
        option5.setBounds(10, 100, 400, 20);
        option6.setBounds(10, 120, 400, 20);
        option7.setBounds(10, 140, 400, 20);
        option8.setBounds(10, 160, 400, 20);
        option9.setBounds(10, 180, 400, 20);
        arrow.setBounds(10, 220, 30, 20);
        choice.setBounds(30, 220, 20, 20);
        ok.setBounds(70, 220, 50, 20);

        // Add to panel
        panel.add(title);
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(option4);
        panel.add(option5);
        panel.add(option6);
        panel.add(option7);
        panel.add(option8);
        panel.add(option9);
        panel.add(arrow);
        panel.add(choice);
        panel.add(ok);

        setContentPane(panel);

        // Window
        panel.setLayout(null);
        setSize(450, 290);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // Get choice from text field
    public String getChoice() {
        return choice.getText();
    }

    // Set text field to null
    public void resetText() {
        choice.setText("");
        choice.requestFocus();
    }

    // Ok button action listener
    void addOkButtonListener(ActionListener listener) {
        ok.addActionListener(listener);
    }
}
