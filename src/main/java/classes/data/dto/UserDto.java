package classes.data.dto;

import classes.data.entity.UserProfile;
import classes.data.validation.PasswordMatches;
import classes.data.validation.ValidEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
public class UserDto {

    @NotNull
    @Size(min = 3, max = 20, message = "Your first name should be from 3 to 20 symbols!")
    @Getter
    @Setter
    private String firstName;

    @NotNull
    @Size(min = 3, max = 20, message = "Your last name should be from 3 to 20 symbols!")
    @Getter
    @Setter
    private String lastName;

    @NotNull
    @Size(min = 5, max = 10, message = "Your username should be from 5 to 20 symbols!")
    @Getter
    @Setter
    private String userName;

    @NotNull
    @Size(min = 5, max = 20, message = "Your password should be from 5 to 20 symbols!")
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @Size(min = 5, max = 20, message = "Your email should be from 5 to 20 symbols!")
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private UserProfile userProfile;
}
