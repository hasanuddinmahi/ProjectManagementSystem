import java.io.IOException;
import java.util.ArrayList;

// Model for login page - by Lee Jiang Yoong
public class LoginModel {

    // Login process
    public Boolean login(int user_ID, String password) throws IOException {

        ArrayList<Student> student_list = Student.readStudentList(); // read student list
        ArrayList<Lecturer> lecturer_list = Lecturer.readLecturerList(); // read lecturer list
        ArrayList<User> admin_list = Admin.readAdminList(); // read admin list

        User.save_id = user_ID; // Save user id

        return verifyLogin(user_ID, password, admin_list, student_list, lecturer_list);

    }

    // Verify Login: Check username and password
    public Boolean verifyLogin(int user_ID, String password,
            ArrayList<User> admin_list, ArrayList<Student> student_list,
            ArrayList<Lecturer> lecturer_list) {

        for (User admin : admin_list) { // Check if its admin
            if (user_ID == admin.getUserID() && password.equals(admin.getPassword())) {

                AdminInterfaceView theView = new AdminInterfaceView();
                new AdminInterfaceController(theView);
                theView.setVisible(true);
                
                return true;

            }
        }

        for (Student student : student_list) { // Check if its student
            if (user_ID == student.getUserID() && password.equals(student.getPassword())) {
                
                StudentInterfaceView theView = new StudentInterfaceView();
                new StudentInterfaceController(theView);
                theView.setVisible(true);

                return true;
            }
        }

        for (Lecturer lec : lecturer_list) { // Check if its lecturer
            if (user_ID == lec.getUserID() && password.equals(lec.getPassword())) {

                LecturerInterfaceView theView = new LecturerInterfaceView();
                new LecturerInterfaceController(theView);
                theView.setVisible(true);
                
                return true;

            }
        }
        return false;
    }

}
