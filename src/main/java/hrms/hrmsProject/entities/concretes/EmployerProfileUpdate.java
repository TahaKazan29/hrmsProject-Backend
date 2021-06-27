package hrms.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hrms.hrmsProject.entities.enums.EmployerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employer_profile_updates")
public class EmployerProfileUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String webSite;
    private String phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    @JsonIgnore
    private Employer employer;

    private EmployerStatus status;


}
