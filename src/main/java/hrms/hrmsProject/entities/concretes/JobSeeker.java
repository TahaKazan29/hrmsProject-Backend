package hrms.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hrms.hrmsProject.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_seekers")
public class JobSeeker extends User {

    @NotBlank
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @NotNull
    @Column(name = "identity_number")
    private String identityNumber;

    @NotBlank
    @NotNull
    @Column(name = "birth_year")
    private int birthYear;

    @OneToMany(mappedBy = "jobSeeker")
    @JsonIgnore
    private List<Resume> resumes;

    @OneToMany(mappedBy = "jobSeeker")
    @JsonIgnore()
    private List<JobSeekerImage> jobSeekerImages;
}
