package hrms.hrmsProject.entities.concretes;

import hrms.hrmsProject.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name="system_personnels")
public class SystemPersonnel extends User {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "department_id")
    private String departmendId;

    /*@OneToOne()
    @JoinColumn(name="user_id")
    private User user;*/

}
