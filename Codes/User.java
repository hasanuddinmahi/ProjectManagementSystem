
// To store user details
public class User {

    protected static int save_id = 0;
    private int user_ID;
    private String password;

    public User(int user_ID, String password) {
        this.user_ID = user_ID;
        this.password = password;
    }

    public int getUserID() {
        return user_ID;
    }

    public String getPassword() {
        return password;
    }

}
