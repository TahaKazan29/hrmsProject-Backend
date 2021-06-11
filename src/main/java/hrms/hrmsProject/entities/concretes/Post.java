package hrms.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotNull
    private String description;
    private double minSalary;
    private double maxSalary;

    @NotNull
    private int positionCount;

    private Date lastApplyDate;
    private Date releaseDate;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "jobPosition_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "way_of_working_id")
    private WayOfWorking wayOfWorking;

    @ManyToOne()
    @JoinColumn(name = "working_time_id")
    private WorkingTime workingTime;

    private PostStatus status;
}
