package hrms.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String schoolName;
    private String sectionName;
    private Date startingDate;
    private Date dateOfGraduation;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="resume_id")
    private Resume resume;


}
