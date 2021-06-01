package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.School;
import hrms.hrmsProject.entities.concretes.WorkExperience;
import hrms.hrmsProject.entities.dtos.WorkExperienceDto;

import java.util.List;

public interface WorkExperienceService {

    Result add (List<WorkExperienceDto> workExperienceDtos);
    DataResult<List<WorkExperience>> getByBusinessDate(int jobSeekerId);

}
