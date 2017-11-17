package classes.controller;

import classes.data.detail.CustomUserDetail;
import classes.data.dto.HotelDto;
import classes.data.entity.User;
import classes.data.service.HotelService;
import classes.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService studentService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showUserPage(Model model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("list", studentService.getAll());
        return "admin";
    }

    @RequestMapping(value = "/admin/{id}/delete", method = RequestMethod.GET)
    public String deleteRegistration(@PathVariable("id") int id) {
        User user = studentService.findOne(id);
        user.setHotel(null);
        studentService.save(user);
        return "registr-success";
    }

    private User getPrincipal(){
        CustomUserDetail customUserDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customUserDetail.getUser();
    }
}
