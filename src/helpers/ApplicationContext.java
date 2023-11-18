package helpers;

import javax.swing.JPanel;
import models.User;

public class ApplicationContext {
    private static User user;
    private static JPanel mainContainer;
    
    public ApplicationContext() {}
    
    public static void setUser(User userToBeSaved) {
        user = userToBeSaved;
    }
    
    public static User getUser() {
        return user;
    }
    
    public static JPanel getMainContainer() {
        return mainContainer;
    }

    public static void setMainContainer(JPanel mainContainer) {
        ApplicationContext.mainContainer = mainContainer;
    }
}
