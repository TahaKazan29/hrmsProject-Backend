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
@Table(name="faculuties")
public class Faculity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int type;
    private int status;

    @ManyToOne()
    @JoinColumn(name = "university_id")
    @JsonIgnore
    private University university;


    @OneToMany(mappedBy = "faculity")
    @JsonIgnore
    private List<Section> sections;




}
