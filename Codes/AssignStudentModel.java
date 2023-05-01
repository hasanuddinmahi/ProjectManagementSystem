import java.io.IOException;
import java.util.ArrayList;

// Model for assigning student to lecturer's project - By Lee Jiang Yoong
public class AssignStudentModel {

    ArrayList<LecturerDetails> lecturers_project = new ArrayList<LecturerDetails>();

    public Boolean verify(int input_student_id, int input_project_id) throws IOException {

        ArrayList<AssignmentList> assignment_list = AssignmentList.readAssignmentList();
        ArrayList<StudentDetails> student_list = StudentDetails.readStudentList();
        ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();

        // Return false if its already been assigned before
        // (Input student id and project id == student id and project id in assignment list)

        for (int i = 0; i < assignment_list.size(); i++) {
            if (input_student_id == assignment_list.get(i).getStudentID()
                    && input_project_id == assignment_list.get(i).getProjectID()) {
                return false;
            }
        }

        // 1. Input student id = student_id in student list
        // 2. Input project id = project id in project list
        // 3. Input project id = project id in lecturers project

        for (int i = 0; i < student_list.size(); i++) {
            for (int j = 0; j < project_list.size(); j++) {
                for (int k = 0; k < lecturers_project.size(); k++) {
                    int student_id = student_list.get(i).getStudentID();
                    int project_id = project_list.get(j).getProjectID();
                    int lecturers_project_id = lecturers_project.get(k).getProjectID();

                    if (input_student_id == student_id && input_project_id == project_id
                            && input_project_id == lecturers_project_id) {

                        assignment_list.add(new AssignmentList(student_id, project_id));
                        AssignmentList.saveToAssignmentList(assignment_list);
                        AssignmentList.Assigned_Student_Assignment_List_Report(assignment_list);

                        return true;
                    }

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
                lecturers_project.add(new LecturerDetails(lec.getProjectID()));
            }
        }
    }

}
