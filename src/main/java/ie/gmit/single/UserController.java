package ie.gmit.single;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {
    private Validate validate = new Validate();
    private StoreUser storeUser = new StoreUser();

    //Create a new user
    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);
        Validate myUser = new Validate();

        boolean checkUser = myUser.checkUser(user);
        if(!checkUser) {
            return "ERROR";
        }
       storeUser.saveUser(user);
        return "SUCCESS";
    }
 }

