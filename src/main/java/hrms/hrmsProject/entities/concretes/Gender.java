package hrms.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="genders")
public class Gender {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "gender")
    private List<Resume> resumes;

}
