package classes.data.repository;

import classes.data.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    @Query("select u from UserProfile u where u.type = :type")
    UserProfile findByType(@Param("type")String type);

    @Query("select u from UserProfile u where u.id = :id")
    UserProfile findById(long id);
}
