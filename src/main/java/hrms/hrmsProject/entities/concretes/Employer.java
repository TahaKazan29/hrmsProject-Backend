package hrms.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hrms.hrmsProject.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","posts"})
@Table(name="employers")
public class Employer extends User {

    @NotNull
    @NotBlank
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @NotBlank
    @Column(name = "web_site")
    private String webSite;

    @NotNull
    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @OneToMany(mappedBy = "employer")
    private List<Post> posts;

}
