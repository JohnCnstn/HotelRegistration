package classes.data.repository;

import classes.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.firstName = :firstName")
    User findByName(String firstName);

    @Query("select u from User u where u.userName = :userName")
    User findByUserName(@Param("userName")String userName);

    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);
}
