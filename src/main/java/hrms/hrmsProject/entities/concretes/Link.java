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
@Table(name="links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String githubLink;
    private String linkedinLink;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="resume_id")
    private Resume resume;

}
