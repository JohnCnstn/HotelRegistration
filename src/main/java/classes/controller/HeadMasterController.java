package classes.controller;

import classes.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeadMasterController {

    @Autowired
    private UserService studentService;

    @RequestMapping(value = "/headMaster", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("listOfStudents", studentService.getAll());
        return "head-master";
    }
}
