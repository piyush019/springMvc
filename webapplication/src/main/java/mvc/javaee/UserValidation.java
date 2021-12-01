package mvc.javaee;

import org.springframework.stereotype.Service;

@Service
public class UserValidation {
    public boolean isValid(String name, String password) {
        if (name.equals("Piyush Raj") && password.equals("12345678")){
            return true;
        } else {
            return false;
        }
    }
}
