import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;

// View for student interface - by Lee Jiang Yoong
public class StudentInterfaceView extends JFrame {

    private JPanel panel = new JPanel();

    private JLabel title = new JLabel("Select an option:");

    private JLabel option1 = new JLabel("1. View project(s)");
    private JLabel option2 = new JLabel("2. Logout");

    private JLabel arrow = new JLabel("-> ");

    private JTextField choice = new JTextField(1);
    
    private JButton ok = new JButton("OK");

    public StudentInterfaceView() {
        super("Student Interface");

        GUI();
    }

    protected void GUI() {

        // Set Font
        title.setFont(new Font("Courier", Font.BOLD, 15));
        option1.setFont(new Font("Courier", Font.BOLD, 15));
        option2.setFont(new Font("Courier", Font.BOLD, 15));
        choice.setFont(new Font("Courier", Font.BOLD, 15));
        ok.setFont(new Font("Courier", Font.BOLD, 13));

        // Set Position
        title.setBounds(105, 0, 400, 20);
        option1.setBounds(10, 20, 400, 20);
        option2.setBounds(10, 40, 400, 20);
        arrow.setBounds(10, 80, 30, 20);
        choice.setBounds(30, 80, 20, 20);
        ok.setBounds(70, 80, 50, 20);

        // Add to panel
        panel.add(title);
        panel.add(option1);
        panel.add(option2);
        panel.add(arrow);
        panel.add(choice);
        panel.add(ok);

        setContentPane(panel);

        // Window
        panel.setLayout(null);
        setSize(450, 150);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

     // Get choice from text field
    public String getChoice() {
        return choice.getText();
    }

    // Set text to null
    public void resetText() {
        choice.setText("");
        choice.requestFocus();
    }

    // Ok button action listener
    void addOkButtonListener(ActionListener listener) {
        ok.addActionListener(listener);
    }
}
