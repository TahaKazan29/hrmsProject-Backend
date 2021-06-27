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
@Table(name="universities")
public class University{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int status;

    @OneToMany(mappedBy = "university")
    @JsonIgnore
    private List<Faculity> faculities;

    @OneToMany(mappedBy = "university")
    @JsonIgnore
    private List<Section> sections;

    @OneToMany(mappedBy = "university")
    @JsonIgnore
    private List<UniversityInformation> universityInformations;

}
