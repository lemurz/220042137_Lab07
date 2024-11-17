package src;

public class User {
    private String userID;
    private String username;
    private String email;
    private String password;
    private String userType;

    public User(String userID, String username, String email, String password, String userType) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    // Getters
    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return userType;
    }

    // Password is intentionally not provided with a getter for security

    // Setter for password (for updating it if needed)
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public String toString() {
        return userID + "," + username + "," + email + "," + password + "," + userType;
    }
}
