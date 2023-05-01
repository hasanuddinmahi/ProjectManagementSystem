import java.io.IOException;
import java.util.ArrayList;

// Model for Modify Project content
// Ahmed Adam
public class ModifyModel {

    ArrayList<LecturerDetails> lecturer_details = new ArrayList<LecturerDetails>();
    ArrayList<ProjectDetails> project_list = new ArrayList<ProjectDetails>();
    ArrayList<LecturerDetails> lec_project_list = new ArrayList<LecturerDetails>();
    ArrayList<ContentDetails> content_project_list = new ArrayList<ContentDetails>();

    // Modify the project content
    public Boolean modifyContent(int option, String new_content) throws IOException {

        ArrayList<ContentDetails> content_project_list = ContentDetails.readContentDetails();

        for (int i = 0; i < content_project_list.size(); i++) {
            for (int j = 0; j < lecturer_details.size(); j++) {

                int lec_project_id = lecturer_details.get(j).getProjectID();
                int project_id = content_project_list.get(i).getProjectID();

                if (option == lec_project_id  && option == project_id) {

                    content_project_list.get(i).setProjectContent(new_content);

                    try {
                        ContentDetails.saveContentDetails(content_project_list);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    return true;
                }
            }
        }
    return false;
}

    // Add project id to array if user id matched with lecturer id in lecturer details file
    public void checkLecturerProjects() throws IOException {

        ArrayList<LecturerDetails> lec_project_list = LecturerDetails.readLecturerDetails();

        for (LecturerDetails lec : lec_project_list) {
            if (User.save_id == lec.getLecturerID()) {
                lecturer_details.add(new LecturerDetails(lec.getProjectID()));
            }
        }
    }

}
