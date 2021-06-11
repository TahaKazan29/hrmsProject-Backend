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
@Table(name="ways_of_working")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","posts"})
public class WayOfWorking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String working;

    @OneToMany(mappedBy = "wayOfWorking")
    private List<Post> posts;
}
