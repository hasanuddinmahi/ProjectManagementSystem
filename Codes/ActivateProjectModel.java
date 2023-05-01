import java.io.IOException;
import java.util.ArrayList;

// Model for activating lecturer's project - by Lee Jiang Yoong
public class ActivateProjectModel {

    ArrayList<ProjectDetails> deactivated_list = new ArrayList<ProjectDetails>();
    ArrayList<LecturerDetails> lecturer_details = new ArrayList<LecturerDetails>();

    // Assign deactivated projects to arrays
    public void arrange_projects() throws IOException {

        ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();

        for (int i = 0; i < project_list.size(); i++) {

            String project_status = project_list.get(i).getProjectStatus();

            if (project_status.equals("Deactivated")) {
                deactivated_list.add(project_list.get(i));
            }

        }

    }

    // Activate the project
    public Boolean activate_project(int option) throws IOException {
        ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();

        for (int i = 0; i < deactivated_list.size(); i++) {
            for (int j = 0; j < project_list.size(); j++) {
                for (int k = 0; k < lecturer_details.size(); k++) {

                    int deactivated_id = deactivated_list.get(i).getProjectID();
                    int project_id = project_list.get(j).getProjectID();
                    int lec_project_id = lecturer_details.get(k).getProjectID();

                    // 1. Input project id = lecturer project id -(to prevent activation of projects of other lec)
                    // 2. Input project id = deactivated project id
                    // 3. Deactivated project id = project id in project details
                    if (option == lec_project_id && option == deactivated_id
                            && deactivated_id == project_id) {

                        project_list.get(j).setProjectStatus("Activated");
                        deactivated_list.remove(i);

                        try {
                            ProjectDetails.saveProjectDetails(project_list);
                            ProjectDetails.saveProjectListReport(project_list);
                            ProjectDetails.Active_Project_List_Report(project_list);
                            
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
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
