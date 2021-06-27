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
@Table(name="driver_licenses")
public class DriverLicense {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "driverLicense")
    private List<Resume> resumes;

}
