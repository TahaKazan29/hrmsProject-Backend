package hrms.hrmsProject.core.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="passwordHash")
    private byte[] passwordHash;

    @Column(name="passwordSalt")
    private byte[] passwordSalt;

    @Column(name="confirmPassword")
    private byte[] confirmPassword;

}
