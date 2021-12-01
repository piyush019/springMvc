package mvc.springmvc;

import mvc.javaee.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    UserValidation userValidation;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String getHelloWorld(){
        /*
        it will print hello world in browser when /login is called
        because of ResponseBody annotation
         */
        return "Hello World";
    }

    //adding method in requestMapping can only process that type of request
    @RequestMapping(value = "/indexLogin", method = RequestMethod.GET)
    public String sayHello(){
        /*
        this is calling index.jsp file as we have configured the file in view resolver in todo-servlet.xml
         */
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap){
        if (!userValidation.isValid(name, password)){
            modelMap.put("error", "Invalid credentials");
            return "login";
        } else {
            modelMap.put("name", name);
            modelMap.put("password", password);
            return "welcome";
        }
    }
}
