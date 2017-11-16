package classes.controller;

import classes.data.detail.CustomUserDetail;
import classes.data.dto.HotelDto;
import classes.data.dto.UserDto;
import classes.data.entity.User;
import classes.data.service.HotelService;
import classes.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUserPage(Model model) {
        model.addAttribute("list", hotelService.getAll());
        return "user";
    }

    @RequestMapping(value = "/user/reg-hotel", method = RequestMethod.POST)
    public String regHotel() {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setId(1);
        registerHotel(getPrincipal(), hotelDto);
        return "registr-success";
    }

    private void registerHotel(User user, HotelDto hotelDto) {
        userService.registerHotel(user, hotelDto);
    }

    private User getPrincipal(){
        CustomUserDetail customUserDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customUserDetail.getUser();
    }
}
