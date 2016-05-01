package bsi.pp_2016_1.easter.Services;

/**
 * Created by franc on 30/04/2016.
 */
public class LoginServices {
    public static boolean login(String username, String password){
        StringBuilder password2 = new StringBuilder();
        password2.append(password);
        password2.append("StanLee");


        return true;
    };
}
