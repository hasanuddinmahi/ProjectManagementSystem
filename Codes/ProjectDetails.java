import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// To read and/or save project details
public class ProjectDetails {

    private int project_id;
    private String specialization;
    private String project_status;
    private String comment;

    public ProjectDetails(int project_id, String specialization, String comment, String project_status){
        this.project_id = project_id;
        this.specialization = specialization;
        this.project_status = project_status;
        this.comment = comment;
    }

    public int getProjectID(){
        return project_id;
    }

    public String getProjectIDString(){ //
        return (project_id + "");
    }

    public String getSpecialization(){
        return specialization;
    }

    public String getProjectStatus(){
        return project_status;
    }

    public String getComment(){
        return comment;
    }

    public void setProjectStatus(String status){
        this.project_status = status;
    }

    public void setProjectComment(String comment){
        this.comment = comment;
    }

    protected static ArrayList<ProjectDetails> readProjectList() throws IOException {
        ArrayList<ProjectDetails> project_list = new ArrayList<>();

        // read DistributionCenter.csv into a list of lines.
        List<String> lines = Files.readAllLines(Paths.get("ProjectDetails.csv")); // read file as String
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma 
            String[] items = lines.get(i).split(",");

            int project_id = Integer.parseInt(items[0]); // convert String to int

            project_list.add (new ProjectDetails(project_id, items[1], items[2], items[3]) ); // add to file
        }
        return project_list;
    }

    protected static void saveProjectDetails(ArrayList<ProjectDetails> list) throws IOException{
        // read ProjectDetail.csv into a list of lines.
        StringBuilder sb = new StringBuilder(); // = many String variables
        for (int i = 0; i < list.size(); i++)
            sb.append (list.get(i).toCSVString() + "\n");   // convert list to string 
        Files.write(Paths.get("ProjectDetails.csv"), sb.toString().getBytes());  // write Strings to "ProjectDetail.csv" 
    }

    public String toCSVString() {
        return project_id + "," + specialization + "," + comment + "," + project_status;
    }

    protected static void saveProjectListReport(ArrayList<ProjectDetails> list) throws IOException{
        // read ProjectDetail.csv into a list of lines.
        StringBuilder sb = new StringBuilder(); // = many String variables

        // header
        String header1 = "Project name";
        String header2 = "Specialization";
        String header3 = "Project status";
        String header4 = "Comment";

        sb.append (header1 + "," + header2 + "," + header3 + "," + header4 + "\n");
        
        for (int i = 0; i < list.size(); i++)
            sb.append (list.get(i).toCSVString() + "\n");   // convert list to string 
        Files.write(Paths.get("ProjectListReport.csv"), sb.toString().getBytes());  // write Strings to "ProjectDetail.csv" 
    }

    public String ActiveProjectReportCSVString() {
        return project_id + "," + project_status ;
    }

    public String InactiveProjectReportCSVString() {
        return project_id + "," + project_status ;
    }

    public String CommentReportCSVString() {
        return project_id + "," + comment ;
    }

    //generate an Active Status Project Report with heading - by Adrian Chong Keat Seong
    protected static void Active_Project_List_Report(ArrayList<ProjectDetails> list) throws IOException{
        // read ProjectDetail.csv into a list of lines.
        StringBuilder sb = new StringBuilder(); // = many String variables

        // header
        String header1 = "Project name";
        String header2 = "Project status";

        sb.append (header1 + "," + header2 + "\n");
        
        for (int i = 0; i < list.size(); i++)
            sb.append (list.get(i).ActiveProjectReportCSVString() + "\n");   // convert list to string 
        Files.write(Paths.get("ActiveProjectListReportListReport.csv"), sb.toString().getBytes());  // write Strings to "ActiveProjectListReportListReport.csv" 
    }

    //generate an Inactive Status Project Report with heading - by Adrian Chong Keat Seong
    protected static void Inactive_Project_List_Report(ArrayList<ProjectDetails> list) throws IOException{
        // read ProjectDetail.csv into a list of lines.
        StringBuilder sb = new StringBuilder(); // = many String variables

        // header
        String header1 = "Project name";
        String header2 = "Project status";

        sb.append (header1 + "," + header2 + "," + "\n");
        
        for (int i = 0; i < list.size(); i++)
            sb.append (list.get(i).InactiveProjectReportCSVString() + "\n");   // convert list to string 
        Files.write(Paths.get("InactiveProjectListReportListReport.csv"), sb.toString().getBytes());  // write Strings to "InactiveProjectListReportListReport.csv" 
    }

    //generate an Commented Project Report with heading - by Adrian Chong Keat Seong
    protected static void Comment_Project_List_Report(ArrayList<ProjectDetails> list) throws IOException{
        // read ProjectDetail.csv into a list of lines.
        StringBuilder sb = new StringBuilder(); // = many String variables

        // header
        String header1 = "Project name";
        String header2 = "Comment";

        sb.append (header1 + "," + header2 + "\n");
        
        for (int i = 0; i < list.size(); i++)
            sb.append (list.get(i).CommentReportCSVString() + "\n");   // convert list to string 
        Files.write(Paths.get("CommentListReport.csv"), sb.toString().getBytes());  // write Strings to "ProjectDetail.csv" 
    }
}
