package hrms.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="abilities")
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String abilityName;
    private String technologyName;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="resume_id")
    private Resume resume;


}
