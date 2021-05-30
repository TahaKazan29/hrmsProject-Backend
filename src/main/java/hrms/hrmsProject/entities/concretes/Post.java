package hrms.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String description;
    private double minSalary;
    private double maxSalary;
    private int positionCount;
    private Date lastApplyDate;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;


    private PostStatus status;
}
