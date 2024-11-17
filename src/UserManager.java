package src;

import java.io.*;
import java.util.*;

public class UserManager implements AuthenticationService, FileService, PrivilegeService {
    private static final String USER_FILE = "src.User.csv";
    private static final String ADMIN_FILE = "src.Admin.csv";
    private static UserManager instance;
    private UserManager() {}

    public static UserManager getInstance() {
        if (instance == null) {
            synchronized (UserManager.class) {
                if (instance == null) {
                    instance = new UserManager();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean authenticateUser(String username, String password, String userType) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                userType.equals("src.Admin") ? ADMIN_FILE : USER_FILE));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields[1].equals(username) && fields[3].equals(password)) {
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }

    @Override
    public boolean addUser(User user) throws IOException {
        String fileName = user.getUserType().equals("src.Admin") ? ADMIN_FILE : USER_FILE;
        return writeToFile(user, fileName);
    }

    @Override
    public List<User> readUsers(String userType) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                userType.equals("src.Admin") ? ADMIN_FILE : USER_FILE));
        List<User> users = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            users.add(new User(fields[0], fields[1], fields[2], fields[3], fields[4]));
        }
        reader.close();
        return users;
    }

    @Override
    public boolean renameFile(String oldName, String newName, String currentUserType) {
        if (!currentUserType.equals("src.Admin")) return false;
        File oldFile = new File(oldName);
        File newFile = new File(newName);
        return oldFile.renameTo(newFile);
    }

    private boolean writeToFile(User user, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(user.toString() + "\n");
        writer.close();
        return true;
    }
}
