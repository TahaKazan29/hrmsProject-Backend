package hrms.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","posts"})
public class JobPosition {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="position_name")
    private String positionName;

    @OneToMany(mappedBy = "jobPosition")
    private List<Post> posts;
    


}
