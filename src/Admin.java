package src;

public class Admin extends User {
    public Admin(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Admin");
    }
}
