import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// To read and/or save lecturer details
public class LecturerDetails {
    
    int lecturer_id;
    int project_id;

    public LecturerDetails(int lecturer_id, int project_id){
        this.lecturer_id = lecturer_id;
        this.project_id = project_id;
    }

    public LecturerDetails(int project_id){
        this.project_id = project_id;
    }

    public int getProjectID(){
        return project_id;
    }

    public int getLecturerID(){
        return lecturer_id;
    }

    protected static ArrayList<LecturerDetails> readLecturerDetails() throws IOException {
        ArrayList<LecturerDetails> lecturer_details = new ArrayList<>();

        // read DistributionCenter.csv into a list of lines.
        List<String> lines = Files.readAllLines(Paths.get("LecturerDetails.csv")); // read file as String
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma 
            String[] items = lines.get(i).split(",");

            int lecturer_id = Integer.parseInt(items[0]); // convert String to int
            int project_id = Integer.parseInt(items[1]); // convert String to int

            lecturer_details.add (new LecturerDetails(lecturer_id, project_id) ); // add to file
        }
        return lecturer_details;
    }

    protected static void saveLecturerDetails(ArrayList<LecturerDetails> list) throws IOException{
        // read LecturertDetail.csv into a list of lines.
        StringBuilder sb = new StringBuilder(); // = many String variables
        for (int i = 0; i < list.size(); i++)
            sb.append (list.get(i).toCSVString() + "\n");   // convert list to string 
        Files.write(Paths.get("LecturerDetails.csv"), sb.toString().getBytes());  // write Strings to "LecturertDetail.csv" 
    }

    public String toCSVString() {
        return lecturer_id + "," + project_id;
    }
}
