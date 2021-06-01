package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.School;
import hrms.hrmsProject.entities.dtos.SchoolDto;

import java.util.List;

public interface SchoolService {

    Result add(List<SchoolDto> schools);
    DataResult<List<School>> getAllByJobSeekerOrderByDateOfGraduation(int jobSeekerId);

}
