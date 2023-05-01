import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// To read and/or save student's project assignment - by Lee Jiang Yoong
public class AssignmentList {

    private int student_id;
    private int project_id;

    public AssignmentList(int student_id, int project_id){
        this.student_id = student_id;
        this.project_id = project_id;
    }

    public int getProjectID(){
        return project_id;
    }

    public int getStudentID(){
        return student_id;
    }

    public String getStudentIDString(){ //
        return student_id + "";
    }

    public String getProjectIDString(){ //
        return project_id + "";
    }
    

    protected static ArrayList<AssignmentList> readAssignmentList() throws IOException {
        ArrayList<AssignmentList> assignment_list = new ArrayList<>();

        // read DistributionCenter.csv into a list of lines.
        List<String> lines = Files.readAllLines(Paths.get("AssignmentList.csv")); // read file as String
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma 
            String[] items = lines.get(i).split(",");

            int student_id = Integer.parseInt(items[0]); // convert String to int
            int project_id = Integer.parseInt(items[1]); // convert String to int

            assignment_list.add (new AssignmentList(student_id, project_id) ); // add to file
        }
        return assignment_list;
    }

    protected static void saveToAssignmentList(ArrayList<AssignmentList> list) throws IOException{
        // read recievedList.csv into a list of lines.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
            sb.append (list.get(i).toCSVString() + "\n");   // convert list to string 
        Files.write(Paths.get("AssignmentList.csv"), sb.toString().getBytes());  // write Strings to "recievedList.csv" 
    }

    public String toCSVString() {
        return student_id + "," + project_id;
    }

    public String Unassigned_Student_Assignment_List_Report_CSV_String() {
        return student_id + "," + project_id;
    }

        //generate an Assigned Student Report with heading - by Adrian Chong Keat Seong
        protected static void Assigned_Student_Assignment_List_Report(ArrayList<AssignmentList> list) throws IOException {

            StringBuilder sb = new StringBuilder();
    
            //header
            String header1 = "Student ID";
            String header2 = "Project ID";
    
            sb.append (header1 + "," + header2 + "\n");
    
            for (int i = 0; i < list.size(); i++)
                sb.append (list.get(i).toCSVString() + "\n");   // convert list to string 
            Files.write(Paths.get("AssignmentListReport.csv"), sb.toString().getBytes());  // write Strings to "AssignmentListReport.csv" 
    
        }
    
        //generate a Unassigned Student Report with heading - by Adrian Chong Keat Seong
        protected static void Unassigned_Student_Assignment_List_Report(ArrayList<AssignmentList> list) throws IOException {
    
            StringBuilder sb = new StringBuilder();
    
            //header
            String header1 = "Unassigned Student ID";
            String header2 = "Project ID";
    
            sb.append (header1 + "," + header2 + "\n");
    
            for (int i = 0; i < list.size(); i++)
                sb.append (list.get(i).Unassigned_Student_Assignment_List_Report_CSV_String() + "\n");   // convert list to string 
            Files.write(Paths.get("UnassignStudentListReport.csv"), sb.toString().getBytes());  // write Strings to "AssignmentListReport.csv" 
    
        }
}
