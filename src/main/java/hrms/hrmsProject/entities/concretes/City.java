package hrms.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","posts"})
public class City {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Post> posts;

    @OneToMany(mappedBy = "city")
    private List<Resume> resumes;


}
