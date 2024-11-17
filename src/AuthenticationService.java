package src;

import java.io.IOException;

public interface AuthenticationService {
    public boolean authenticateUser(String username, String password, String userType) throws IOException;
}
