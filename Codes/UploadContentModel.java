import java.io.IOException;
import java.util.ArrayList;

// Model for uploading contents by lecturer  - by Yeak Yi Han
public class UploadContentModel {

    ArrayList<LecturerDetails> lecturer_details = new ArrayList<LecturerDetails>();

    public Boolean checkProjectID(int project_id, String content) throws IOException {

        ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();
        ArrayList<ContentDetails> content_list = ContentDetails.readContentDetails();

        Boolean project_exist = false;
        Boolean duplicate_content = false;

        checkLecturerProjects();

        for (int i = 0; i < project_list.size(); i++) {

            if (project_id == project_list.get(i).getProjectID()) {
                project_exist = true;
            }
        }
            
        for (int i = 0; i < content_list.size(); i++) {

            if (project_id == content_list.get(i).getProjectID()
                    && content.equals(content_list.get(i).getContent())) {
                duplicate_content = true;
                break;
            }
        }

        if (project_exist && duplicate_content == false) {

            for (int j = 0; j < lecturer_details.size(); j++){
                int lec_project_id = lecturer_details.get(j).getProjectID();

                if ( project_id == lec_project_id ){
                    content_list.add(new ContentDetails(User.save_id, project_id, content, "Uploaded"));
                    ContentDetails.saveContentDetails(content_list);
                    return true;
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
