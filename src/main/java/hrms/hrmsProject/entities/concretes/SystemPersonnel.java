package hrms.hrmsProject.entities.concretes;

import hrms.hrmsProject.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name="system_personnels")
public class SystemPersonnel extends User {

    @NotBlank
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "department_id")
    private String departmendId;

}
