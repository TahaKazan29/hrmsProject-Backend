package hrms.hrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbilityDto {

    private int id;
    private int resumeId;
    private String abilityName;
    private String technologyName;

}
