import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Admin extends User{

    public Admin (int user_ID, String password){
        super(user_ID, password);
    }

    protected static ArrayList<User> readAdminList() throws IOException {
        ArrayList<User> admin_list = new ArrayList<>();

        // read DistributionCenter.csv into a list of lines.
        List<String> lines = Files.readAllLines(Paths.get("Admin.csv")); // read file as String
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma
            String[] items = lines.get(i).split(",");

            int user_ID = Integer.parseInt(items[0]); // convert String to int

            admin_list.add(new User(user_ID, items[1])); // add to file
        }
        return admin_list;
    }
}
