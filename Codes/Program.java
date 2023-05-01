import java.io.IOException;

// Main page of the program
public class Program {

    public static void main(String[] args) throws IOException {

        LoginModel theModel = new LoginModel();
        LoginView theView = new LoginView();
        new LoginController(theView, theModel);

        theView.setVisible(true);

    }
    
}