package test;

import org.junit.Test;
import static org.junit.Assert.*;

import src.UserManager;
import src.User;

import java.io.IOException;
import java.util.List;

public class UserManagerTest {
    @Test
    public void testAddUser() throws IOException {
        UserManager manager = UserManager.getInstance();
        User user = new User("U001", "johndoe", "john@example.com", "password123", "Regular");
        assertTrue(manager.addUser(user));
    }

    @Test
    public void testAuthenticateUser() throws IOException {
        UserManager manager = UserManager.getInstance();
        assertTrue(manager.authenticateUser("johndoe", "password123", "Regular"));
    }

    @Test
    public void testReadUsers() throws IOException {
        UserManager manager = UserManager.getInstance();
        List<User> users = manager.readUsers("Regular");
        assertFalse(users.isEmpty());
    }

    @Test
    public void testRenameFile() {
        UserManager manager = UserManager.getInstance();
        assertFalse(manager.renameFile("User.csv", "NewUser.csv", "Regular")); // Regular user cannot rename
    }
}
