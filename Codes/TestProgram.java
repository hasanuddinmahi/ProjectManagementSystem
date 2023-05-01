import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestProgram {
    public static void main(String[] agrs) throws IOException {

        Scanner input = new Scanner(System.in);

        ArrayList<ContentDetails> content_list = ContentDetails.readContentDetails();
        ArrayList<ProjectDetails> project_list = ProjectDetails.readProjectList();
        ArrayList<LecturerDetails> lecturer_list = LecturerDetails.readLecturerDetails();
        ArrayList<ContentDetails> lecturer_details = new ArrayList<ContentDetails>();

        System.out.println("Select an option:");
        System.out.println("1. Upload");
        System.out.println("2. Publish");
        int option = input.nextInt();

        switch (option) {
            case 1:
                upload(input, content_list, project_list);
            case 2:
                publish(input, content_list, project_list, lecturer_list, lecturer_details);
            default:
        }

    }

    public static void upload(Scanner input, ArrayList<ContentDetails> content_list,
            ArrayList<ProjectDetails> project_list) throws IOException {

        Boolean project_valid = true;

        String input_pro_id = input.next();

        int project_id = Integer.parseInt(input_pro_id);

        for (int i = 0; i < project_list.size(); i++) {

            if (project_id == project_list.get(i).getProjectID()) {
                project_valid = true;
                break;
            } else
                project_valid = false;

        }

        if (project_valid) {
            String content = input.next();

            content_list.add(new ContentDetails(User.save_id, project_id, content, "Uploaded"));
            ContentDetails.saveContentDetails(content_list);
        }

    }

    public static void publish(Scanner input, ArrayList<ContentDetails> content_list,
            ArrayList<ProjectDetails> project_list, ArrayList<LecturerDetails> lecturer_list,
            ArrayList<ContentDetails> lecturer_details) throws IOException {

        Boolean project_valid = true;
        //Boolean lecturer_id_valid = true;

        checkLecturerProjects(content_list, lecturer_details);

        String input_pro_id = input.next();

        int project_id = Integer.parseInt(input_pro_id);

        for (int i = 0; i < project_list.size(); i++) {
            if ( project_id == project_list.get(i).getProjectID() ) {
                project_valid = true;
                break;
            } else
                project_valid = false;
        }

        if (project_valid){
            for (int i = 0; i < content_list.size(); i++){
                for (int j = 0; j < lecturer_details.size(); j++){

                    int lec_project_id = lecturer_details.get(j).getProjectID();
                    int content_id = content_list.get(i).getProjectID();
                    String content_status = content_list.get(i).getContentStatus();

                    if ( project_id == lec_project_id && project_id == content_id 
                    && content_status.equals("Uploaded")){
                        System.out.println("Puvlished");
                        content_list.get(i).setContentStatus("Published");
                        break;
                    }
                }
            }

            ContentDetails.saveContentDetails(content_list);
 
        }  

        

    }

    // Add project id to array if user id matched with lecturer id in lecturer
    // details file
    public static void checkLecturerProjects(ArrayList<ContentDetails> content_list, 
    ArrayList<ContentDetails> lecturer_details) {
        for (ContentDetails lec : content_list) {
            // dummy id
            int id = 123123;
            if (id == lec.getLecturerID()) {
                lecturer_details.add( new ContentDetails(lec.getProjectID()) );
            }
        }

    }
}
