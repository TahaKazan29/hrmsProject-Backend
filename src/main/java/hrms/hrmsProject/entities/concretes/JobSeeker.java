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

@Table(name="job_seekers")
public class JobSeeker extends User {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "identity_number")
    private String identityNumber;
    @Column(name = "birth_year")
    private int birthYear;
}
