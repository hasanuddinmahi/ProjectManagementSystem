import java.io.IOException;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

// View for Register ac Account for Admin / Student / Lecturer - by Adrian Chong Keat Seong
public class RegisterAccountView extends JFrame{
    
    private JFrame frame = new JFrame("Please fill in the detail");;
    private JPanel panel = new JPanel();

    private JLabel instruction = new JLabel("Enter a new user id: ");
    private JLabel instruction1 = new JLabel("Enter a new password: ");
    private JLabel instruction2 = new JLabel("Enter the user's role. (Admin / Student / Lecturer): ");
    
    private JTextField textField = new JTextField();
    private JTextField textField1 = new JTextField();
    private JTextField textField2 = new JTextField();

    private JButton ok = new JButton("OK");
    private JButton back = new JButton("Back");

    public RegisterAccountView() throws IOException {
        frame.add(panel);
        frame.setVisible(true);
        GUI();
    }

    protected void GUI(){
        // Frame
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);

        // Panel
        BoxLayout lay = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(lay);

        // Instruction and Input text field
        instruction.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction);
        textField.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(textField);

        instruction1.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction1);
        textField1.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(textField1);

        instruction2.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(instruction2);
    
        textField2.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(textField2);

        // Ok button
        ok.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(ok);

        // Back button
        back.setFont(new Font("Courier", Font.BOLD, 12));
        panel.add(back);
    }

    // Get UserID from text field
    public String getUserID(){
        return textField.getText();
    }

    // Get Password from text field
    public String getPassword(){
        return textField1.getText();
    }

    // Get UserRole from text field
    public String getRole(){
        return textField2.getText();
    }

    // Set text field to null
    public void resetText() {
        textField.setText(null);
        textField1.setText(null);
        textField2.setText(null);
        textField.requestFocus();
    }

    // Ok button action listener
    void addOkButtonListener(ActionListener listener) {
        ok.addActionListener(listener);
    }

    // Back button action listener
    void addBackButtonListener(ActionListener listener) {
        back.addActionListener(listener);
    }

    // Redirect to Admin option
    public void redirect() {
        frame.dispose();

        AdminInterfaceView theView = new AdminInterfaceView();
        new AdminInterfaceController(theView);
        theView.setVisible(true);
    }
}
