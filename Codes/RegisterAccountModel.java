import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;

import java.nio.file.Paths;
import javax.swing.JOptionPane;

//Model for Register an Account for Admin / Student / Lecturer - by Adrian Chong Keat Seong
public class RegisterAccountModel {
    
    // Create the Account for the Specific people after done the checking is valid
    public Boolean createAccount(String userID_text, String userPassword_text, String userRole_text)throws IOException {

        ArrayList<Student> readStudentList = Student.readStudentList(); // read student list
        ArrayList<Lecturer> readLectureList = Lecturer.readLecturerList(); // read lecturer list
        ArrayList<User> readAdminList = Admin.readAdminList(); // read admin list
        
        Boolean createAcc = verifyCreateAccount(userID_text, userPassword_text, userRole_text, readAdminList,
                readStudentList, readLectureList);

        if (userRole_text.equals("Admin")) {
            if (createAcc) {
                File AdminFile = new File("Admin.csv");
    
                FileWriter fileWriter = new FileWriter(AdminFile, true);
                fileWriter.write("\n" + userID_text + "," + userPassword_text);
                fileWriter.close();
    
                JOptionPane.showMessageDialog(null, "Admin account created successfully.");
            } 
        } else if(userRole_text.equals("Student")) {

            try {

                String SpecialiazationInput = JOptionPane.showInputDialog(null, "Please key in the specialization ( Cyber Security / Data Science / Software Engineering / Game Development ):");

                if (SpecialiazationInput.equals("Cyber Security") || SpecialiazationInput.equals("Data Science")|| SpecialiazationInput.equals("Software Engineering") || SpecialiazationInput.equals("Game Development")) {
                    if (createAcc) {

                        File StudentDetailFile = new File("StudentDetails.csv");
                        FileWriter fileWriter = new FileWriter(StudentDetailFile, true);
                        fileWriter.write("\n" + userID_text + "," + SpecialiazationInput);
                        fileWriter.close();

                        File StudentFile = new File("Student.csv");
                        fileWriter = new FileWriter(StudentFile, true);
                        fileWriter.write("\n" + userID_text + "," + userPassword_text);
                        fileWriter.close();
            
                        JOptionPane.showMessageDialog(null, "Student account created successfully.");
                    }

                }else {

                    JOptionPane.showMessageDialog(null, "Invalid input");
                    return createAcc;
                    
                }

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        } else if(userRole_text.equals("Lecturer")) {
            if (createAcc) {
                File LectureFile = new File("Lecturer.csv");
    
                FileWriter fileWriter = new FileWriter(LectureFile, true);
                fileWriter.write("\n" + userID_text + "," + userPassword_text);
                fileWriter.close();
    
                JOptionPane.showMessageDialog(null, "Lecturer account created successfully.");
            }
        } 
                
        return createAcc;

    }

    // Do a checking and tell the user this user account already exist
    public Boolean verifyCreateAccount(String userID, String userPassword, String userRole,ArrayList<User> readAdminList, 
    ArrayList<Student> readStudentList, ArrayList<Lecturer> readLectureList)throws IOException {

        for (int i = 0; i < readAdminList.size(); i++) {

            String admin_id = Integer.toString(readAdminList.get(i).getUserID());

            if (userID.equals(admin_id) ) {
                JOptionPane.showMessageDialog(null, "This admin account already exists.");
                return false;

            } else if ( !userID.equals(admin_id) ) {
                continue;
            }
        }

        for (int i = 0; i < readStudentList.size(); i++) {

            String student_id = Integer.toString(readStudentList.get(i).getUserID());

            if (userID.equals( student_id ) ) {
                JOptionPane.showMessageDialog(null, "This Student account already exists.");
                return false;

            } else if ( !userID.equals(student_id ) ) {
                continue;
            }
        }

        for (int i = 0; i < readLectureList.size(); i++) {

            String lecturer_id = Integer.toString(readStudentList.get(i).getUserID());

            if (userID.equals( lecturer_id) ) {
                JOptionPane.showMessageDialog(null, "This Lecturer account already exists.");
                return false;

            } else if ( !userID.equals(lecturer_id) ) {
                continue;
            }
        }

        return true;
    }

}
