package hrms.hrmsProject.core.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.JobSeeker;
import hrms.hrmsProject.entities.concretes.SystemPersonnel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers"})
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="email",unique = true)
    private String email;

    @Column(name="password")
    private String password;

    /*@OneToOne(mappedBy = "user")
    private Employer employer;*/

    /*@OneToOne(mappedBy = "user")
    private JobSeeker jobSeeker;



    @OneToOne(mappedBy = "user")
    private SystemPersonnel systemPersonnel;
*/
}
