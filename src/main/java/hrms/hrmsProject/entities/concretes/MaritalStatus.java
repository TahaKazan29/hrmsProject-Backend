package hrms.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="marital_status")
public class MaritalStatus {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "maritalStatus")
    private List<Resume> resumes;

}
