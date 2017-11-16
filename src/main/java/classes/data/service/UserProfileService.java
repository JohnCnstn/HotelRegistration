package classes.data.service;

import classes.data.entity.UserProfile;

import java.util.List;

public interface UserProfileService {
    UserProfile getById(long id);
    UserProfile getByType(String type);
    List<UserProfile> getAll();
}
