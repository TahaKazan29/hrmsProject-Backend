package hrms.hrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDto {

    private int id;
    private int resumeId;
    private String workPlaceName;
    private String jobPosition;
    private Date dateOfStart;
    private Date departureDate;

}
