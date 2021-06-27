package hrms.hrmsProject.entities.concretes;

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
@Table(name="highSchools")
public class HighSchool{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String schoolName;
    private String sectionName;
    private Date startingDate;
    private Date dateOfGraduation;

    @OneToMany(mappedBy = "highSchool")
    private List<Resume> resumes;

}
