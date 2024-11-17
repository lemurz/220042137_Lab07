package src;

import java.io.IOException;
import java.util.List;

public interface FileService {
    public boolean addUser(User user) throws IOException;
    List<User> readUsers(String userType) throws IOException;
}
