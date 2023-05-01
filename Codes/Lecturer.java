import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// To read lecturer login details
public class Lecturer extends User{

    public Lecturer(int user_ID, String password){
        super(user_ID, password);
    }

    protected static ArrayList<Lecturer> readLecturerList() throws IOException {
        ArrayList<Lecturer> lecturer_list = new ArrayList<>();

        // read DistributionCenter.csv into a list of lines.
        List<String> lines = Files.readAllLines(Paths.get("Lecturer.csv")); // read file as String
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma 
            String[] items = lines.get(i).split(",");

            int user_ID = Integer.parseInt(items[0]); // convert String to int

            lecturer_list.add (new Lecturer(user_ID, items[1]) ); // add to file
        }
        return lecturer_list;
    }

}
