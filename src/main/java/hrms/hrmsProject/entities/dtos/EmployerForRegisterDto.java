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
public class EmployerForRegisterDto implements Dto {

    @NotBlank
    @NotNull
    private String companyName;
    @NotBlank
    @NotNull
    private String website;
    @NotBlank
    @NotNull
    private String phoneNumber;
    @NotBlank
    @NotNull
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String password;
    @NotBlank
    @NotNull
    private String passwordConfirm;

}
