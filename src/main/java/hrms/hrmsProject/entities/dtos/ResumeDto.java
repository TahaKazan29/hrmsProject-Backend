package hrms.hrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDto {

    private int id;
    private int jobSeekerId;
    private int genderId;
    private int cityId;
    private int driverLicenseId;
    private int hightSchoolId;
    private int maritalStatusId;
    private int militaryStatusId;
    private int workingSituationId;
    private String hobby;
    private String description;
    private String name;
    private String lastName;
    private String email;
    private String address;
    private Date birthDay;

}
