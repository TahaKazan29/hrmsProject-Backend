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
@Table(name="work_experiences")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String workPlaceName;
    private String jobPosition;
    private Date dateOfStart;
    private Date departureDate;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="resume_id")
    private Resume resume;

}
