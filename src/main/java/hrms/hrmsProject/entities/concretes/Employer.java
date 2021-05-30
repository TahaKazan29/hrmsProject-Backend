package hrms.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hrms.hrmsProject.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","posts"})
@Table(name="employers")
public class Employer extends User {

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "web_site")
    private String webSite;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @OneToMany(mappedBy = "employer")
    private List<Post> posts;

}
