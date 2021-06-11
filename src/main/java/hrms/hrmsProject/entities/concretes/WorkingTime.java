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
@Table(name="working_times")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","posts"})
public class WorkingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String time;

    @OneToMany(mappedBy = "workingTime")
    private List<Post> posts;

}
