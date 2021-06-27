package hrms.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int status;

    @ManyToOne
    @JoinColumn(name = "faculity_id")
    @JsonIgnore
    private Faculity faculity;

    @ManyToOne
    @JoinColumn(name = "university_id")
    @JsonIgnore
    private University university;

}
