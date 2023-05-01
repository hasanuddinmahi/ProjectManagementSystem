import java.io.IOException;
import java.util.ArrayList;

// Model for publishing contents for lecturers - by Yeak Yi Han
public class PublishContentModel {

    ArrayList<LecturerDetails> lecturer_details = new ArrayList<LecturerDetails>();

    // Verify project validity
    public Boolean checkValidity(int project_id, String content) throws IOException{
        
        ArrayList<ContentDetails> content_list = ContentDetails.readContentDetails();
        ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();
        
        Boolean project_valid = true;
        Boolean comment_exist = false;

        checkLecturerProjects();

        for (int i = 0; i < project_list.size(); i++) {
            if ( project_id == project_list.get(i).getProjectID() ) {
                project_valid = true;
                break;
            } else
                project_valid = false;
        }

        for (int i = 0; i < project_list.size(); i++) {
            for (int j = 0; j < content_list.size(); j++){
                if (project_id == project_list.get(i).getProjectID() && content.equals(content_list.get(i).getContent())){
                    comment_exist = true;
                }
            }
        }

        if (project_valid && comment_exist == false){

            for (int i = 0; i < content_list.size(); i++){
                for (int j = 0; j < lecturer_details.size(); j++){

                    int lec_project_id = lecturer_details.get(j).getProjectID();
                    int content_id = content_list.get(i).getProjectID();
                    String content_status = content_list.get(i).getContentStatus();

                    if ( project_id == lec_project_id && project_id == content_id 
                    && content_status.equals("Uploaded")){

                        content_list.get(i).setContentStatus("Published");
                        ContentDetails.saveContentDetails(content_list);
                        return true;
                    }
                }
            }
 
        }  
        return false;
    }

    // Add to array if user id matched with lecturer id
    public void checkLecturerProjects() throws IOException {
        
        ArrayList<LecturerDetails> lec_project_list = LecturerDetails.readLecturerDetails();

        for (LecturerDetails lec : lec_project_list) {
            if (User.save_id == lec.getLecturerID()) {
                lecturer_details.add(new LecturerDetails(lec.getProjectID()));
            }
        }
    }
}
