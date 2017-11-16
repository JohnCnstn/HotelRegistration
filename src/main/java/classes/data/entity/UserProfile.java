package classes.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name="type", length=15, unique=true, nullable=false)
    @Getter
    @Setter
    private String type = UserProfileType.USER.getUserProfileType();

}
