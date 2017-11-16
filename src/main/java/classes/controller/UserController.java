package classes.controller;

import classes.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService studentService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUserPage(Model model) {
        model.addAttribute("list", studentService.getAll());
        return "user";
    }
}
