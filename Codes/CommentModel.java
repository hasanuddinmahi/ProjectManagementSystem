import java.io.IOException;
import java.util.ArrayList;


// Model for Comment on Project
// Ahmed Adam
public class CommentModel {

    // Modify the project content
    public Boolean leave_comment(int option, String comment) throws IOException {

        ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();

        for (int i = 0; i < project_list.size(); i++) {

            int project_id = project_list.get(i).getProjectID();

            // check if the input option is the same as the project id
            if (option == project_id) {

                // set the new input to comment
                project_list.get(i).setProjectComment(comment);

                try {
                    ProjectDetails.saveProjectDetails(project_list);
                    ProjectDetails.Comment_Project_List_Report(project_list);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                return true;
            }
        }
        return false;
}

}
