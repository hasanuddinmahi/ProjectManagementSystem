import java.io.IOException;
import java.util.ArrayList;

// Model for unassining student from lecturer's project - by Lee Jiang Yoong
public class UnassignStudentModel {

    ArrayList<LecturerDetails> lecturers_project = new ArrayList<LecturerDetails>();

    // Add to array if user id matched with lecturer id
    public void checkLecturerProjects() throws IOException {

        ArrayList<LecturerDetails> lec_project_list = LecturerDetails.readLecturerDetails();

        for (LecturerDetails lec : lec_project_list) {
            if (User.save_id == lec.getLecturerID()) {
                lecturers_project.add(new LecturerDetails(lec.getProjectID()));
            }
        }
    }

    // To verify input based on conditions
    public Boolean verify(int input_student_id, int input_project_id) throws IOException {

        ArrayList<AssignmentList> assignment_list = AssignmentList.readAssignmentList();

        // 1. Input student id = student id in assignment list
        // 2. Input project id = project id in assignment list
        // 3. Input project id = project id in lecturers project

        for (int i = 0; i < assignment_list.size(); i++) {
            for (int j = 0; j < lecturers_project.size(); j++) {

                int assigned_stu_id = assignment_list.get(i).getStudentID();
                int assigned_proj_id = assignment_list.get(i).getProjectID();
                int lecturers_project_id = lecturers_project.get(j).getProjectID();

                if (input_student_id == assigned_stu_id
                        && input_project_id == assigned_proj_id
                        && input_project_id == lecturers_project_id) {
                    assignment_list.remove(i);
                    AssignmentList.saveToAssignmentList(assignment_list);
                    AssignmentList.Unassigned_Student_Assignment_List_Report(assignment_list);
                    return true;
                }
            }

        }

        return false;
    }
}
