package classes.data.service.impl;

import classes.data.entity.UserProfile;
import classes.data.repository.UserProfileRepository;
import classes.data.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public UserProfile getById(long id) {
        return userProfileRepository.findById(id);
    }

    @Override
    public UserProfile getByType(String type) {
        return userProfileRepository.findByType(type);
    }

    @Override
    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }
}
