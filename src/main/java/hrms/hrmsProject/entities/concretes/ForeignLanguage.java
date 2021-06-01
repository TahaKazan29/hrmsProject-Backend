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
@Table(name="foreign_languages")
public class ForeignLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String languageName;
    private int languagelevel;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="resume_id")
    private Resume resume;

}
