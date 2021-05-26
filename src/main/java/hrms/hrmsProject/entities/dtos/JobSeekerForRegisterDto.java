package hrms.hrmsProject.entities.dtos;

import hrms.hrmsProject.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerForRegisterDto implements Dto {

    private String firstName;
    private String lastName;
    private String identityNumber;
    private String birthYear;
    private String email;
    private String password;
    private String passwordConfirm;

}
