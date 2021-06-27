package hrms.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="university_informations")
public class UniversityInformation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date startingDate;
    private Date dateOfGraduation;

    @ManyToOne
    @JoinColumn(name="university_id")
    private University university;

    @ManyToOne
    @JoinColumn(name="resume_id")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name="education_level_id")
    private EducationLevel educationLevel;
}
