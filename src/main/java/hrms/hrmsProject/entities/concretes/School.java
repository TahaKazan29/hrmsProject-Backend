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
@Table(name="schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date startingDate;
    private Date dateOfGraduation;

//    @ManyToOne()
//    @JsonIgnore
//    @JoinColumn(name="resume_id")
//    private Resume resume;


//    @OneToMany(mappedBy = "school")
//    private List<University> universities;
//
//    @OneToMany(mappedBy="school")
//    private List<Resume> resumes;


}
