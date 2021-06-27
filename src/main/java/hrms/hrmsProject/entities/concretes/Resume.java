package hrms.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastName;
    private String description;
    private String email;
    private String address;
    private Date birthDay;
    private String hobby;

    @OneToMany(mappedBy = "resume")
    private List<Ability> abilities;

    @OneToMany(mappedBy = "resume")
    private List<ForeignLanguage> foreignLanguages;

    @OneToMany(mappedBy = "resume")
    private List<WorkExperience> workExperiences ;

    @OneToMany(mappedBy = "resume")
    private List<UniversityInformation> universityInformations;

    @OneToMany(mappedBy = "resume")
    private List<Link> links ;

    @ManyToOne()
    @JoinColumn(name="job_seeker_id")
    private JobSeeker jobSeeker;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn()
    private WorkingSituation workingSituation;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn()
    private MilitaryStatus militaryStatus;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "marital_status_id")
    private MaritalStatus maritalStatus;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "driver_lincense_id")
    private DriverLicense driverLicense;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "high_school_id")
    private HighSchool highSchool;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;



}
