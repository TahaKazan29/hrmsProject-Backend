package hrms.hrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForeignLanguageDto {

    private int id;
    private int resumeId;
    private String languageName;
    private int languagelevel;

}
