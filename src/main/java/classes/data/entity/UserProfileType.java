package classes.data.entity;

import lombok.Getter;

public enum UserProfileType {

    USER("USER"),
    ADMIN("ADMIN");

    @Getter
    String userProfileType;

    UserProfileType(String userProfileType) {
        this.userProfileType = userProfileType;
    }

}
