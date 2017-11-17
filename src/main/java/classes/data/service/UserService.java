package classes.data.service;

import classes.data.dto.HotelDto;
import classes.data.dto.UserDto;
import classes.data.entity.User;
import classes.data.validation.exception.EmailExistsException;
import classes.data.validation.exception.UserNameExistsException;

import java.util.List;

public interface UserService {
    void save(User user);
    User getByUserName(String userName);
    void registerHotel(User user, HotelDto hotelDto);
    User registerNewUserAccount(UserDto accountDto) throws UserNameExistsException, EmailExistsException;
    User findOne(long id);
    List<User> getAll();
}
