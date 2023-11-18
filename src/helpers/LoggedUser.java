package helpers;

import models.User;

public class LoggedUser {
    private static User user;
    
    public LoggedUser() {}
    
    public static void setUser(User userToBeSaved) {
        user = userToBeSaved;
    }
    
    public static User getUser() {
        return user;
    }
}
