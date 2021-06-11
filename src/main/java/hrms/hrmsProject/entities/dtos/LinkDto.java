package hrms.hrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDto {

    private int id;
    private int resumeId;
    private String githubLink;
    private String linkedinLink;

}
