package classes.controller;

import classes.data.dto.UserDto;
import classes.data.service.UserService;
import classes.data.validation.exception.EmailExistsException;
import classes.data.validation.exception.UserNameExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public ModelAndView showSignUpForm() {

        ModelAndView model = new ModelAndView();

        model.setViewName("sign-up");
        model.addObject("user", new UserDto());

        return model;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(
            @Valid @ModelAttribute("user") UserDto accountDto,
            BindingResult result) {

        ModelAndView model = new ModelAndView();

        if (!result.hasErrors()) {
            createUserAccount(accountDto, result);
        }

        if (result.hasErrors()) {
            model.setViewName("sign-up");
        } else {
            model.setViewName("user");
        }
        model.addObject("user", accountDto);
        return model;
    }

    private void createUserAccount(UserDto accountDto, BindingResult result) {
        try {
            service.registerNewUserAccount(accountDto);
        } catch (UserNameExistsException e) {
            result.rejectValue("userName", "message", "Username already exists");
        } catch (EmailExistsException e) {
            result.rejectValue("email", "message", "Email already exists");
        }
    }
}
