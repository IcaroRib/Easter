package bsi.pp_2016_1.easter.Domain;

/**
 * Created by Lucas on 25/05/2016.
 */
public class Session {
    private User loggedUser;
    private static Session _instance;

    private Session(){};

    public static Session getInstance() {
        if(_instance == null) {
            _instance = new Session();
        }

        return _instance;
    }

    public void login(User user) {
        if(this.loggedUser == null) {
            this.loggedUser = user;
        }
    }

    public void logout() {
        this.loggedUser = null;
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}
