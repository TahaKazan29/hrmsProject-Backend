package hrms.hrmsProject.entities.dtos;

import hrms.hrmsProject.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerForRegisterDto implements Dto {

    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String identityNumber;
    @NotNull
    @NotBlank
    private String birthYear;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String passwordConfirm;

}
