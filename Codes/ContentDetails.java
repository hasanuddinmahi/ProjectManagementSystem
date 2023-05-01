import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// To read and/or save content details
// Ahmed Adam 
public class ContentDetails {
    
    int lecturer_id, project_id;
    String project_content, status;

    public ContentDetails(int lecturer_id, int project_id, String project_content, String status){
        this.lecturer_id = lecturer_id;
        this.project_id = project_id;
        this.project_content = project_content;
        this.status =  status;
    }

    public ContentDetails(int project_id){
        this.project_id = project_id;
    }

    public int getProjectID(){
        return project_id;
    }

    public String getProjectIDString(){ //
        return (project_id + "");
    }

    public int getLecturerID(){
        return lecturer_id;
    }

    public String getLecturerIDString(){ //
        return (lecturer_id + "");
    }

    public String getContent(){
        return project_content;
    }

    public String getContentStatus(){
        return status;
    }

    public void setProjectContent(String project_content){
        this.project_content = project_content;
    }

    public void setContentStatus(String status){
        this.status = status;
    }

    protected static ArrayList<ContentDetails> readContentDetails() throws IOException {
        ArrayList<ContentDetails> content_details = new ArrayList<>();

        // read DistributionCenter.csv into a list of lines.
        List<String> lines = Files.readAllLines(Paths.get("ContentDetails.csv")); // read file as String
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma 
            String[] items = lines.get(i).split(",");

            int lecturer_id = Integer.parseInt(items[0]); // convert String to int
            int project_id = Integer.parseInt(items[1]); // convert String to int

            content_details.add (new ContentDetails(lecturer_id, project_id, items[2], items[3]) ); // add to file
        }
        return content_details;
    }

    protected static void saveContentDetails(ArrayList<ContentDetails> list) throws IOException{
        // read ContentDetails.csv into a list of lines.
        StringBuilder sb = new StringBuilder(); // = many String variables
        for (int i = 0; i < list.size(); i++)
            sb.append (list.get(i).toCSVString() + "\n");   // convert list to string 
        Files.write(Paths.get("ContentDetails.csv"), sb.toString().getBytes());  // write Strings to "ContentDetails.csv" 
    }

    public String toCSVString() {
        return lecturer_id + "," + project_id + "," + project_content + "," + status;
    }

    public String toString(){
        return lecturer_id + "," + project_id + "," + project_content + "," + status;
    }
}
