import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// To read student login details - by Lee Jiang Yoong
public class Student extends User{

    public Student(int user_ID, String password){
        super(user_ID, password);
    }

    protected static ArrayList<Student> readStudentList() throws IOException {
        ArrayList<Student> student_list = new ArrayList<>();

        // read DistributionCenter.csv into a list of lines.
        List<String> lines = Files.readAllLines(Paths.get("Student.csv")); // read file as String
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma 
            String[] items = lines.get(i).split(",");

            int user_ID = Integer.parseInt(items[0]); // convert String to int

            student_list.add (new Student(user_ID, items[1]) ); // add to file
        }
        return student_list;
    }

}
