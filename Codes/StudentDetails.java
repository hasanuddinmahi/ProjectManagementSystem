import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// To read Student details
public class StudentDetails {

    private int student_id;
    private String specialization;

    public StudentDetails (int student_id, String specialization){
        this.student_id = student_id;
        this.specialization = specialization;
    }

    public int getStudentID(){
        return student_id;
    }

    public String getStudentIDString(){
        return student_id + "";
    }

    public String getSpecialization(){
        return specialization;
    }

    protected static ArrayList<StudentDetails> readStudentList() throws IOException {
        ArrayList<StudentDetails> student_list = new ArrayList<>();

        // read DistributionCenter.csv into a list of lines.
        List<String> lines = Files.readAllLines(Paths.get("StudentDetails.csv")); // read file as String
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma 
            String[] items = lines.get(i).split(",");

            int student_id = Integer.parseInt(items[0]); // convert String to int

            student_list.add (new StudentDetails(student_id, items[1]) ); // add to file
        }
        return student_list;
    }
}
