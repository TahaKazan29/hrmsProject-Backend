package hrms.hrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDto {

    private int id;
    private int resumeId;
    private String schoolName;
    private String sectionName;
    private Date startingDate;
    private Date dateOfGraduation;

}
