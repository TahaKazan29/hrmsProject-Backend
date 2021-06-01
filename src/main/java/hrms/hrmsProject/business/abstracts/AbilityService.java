package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Ability;
import hrms.hrmsProject.entities.dtos.AbilityDto;

import java.util.List;

public interface AbilityService {

    Result add(List<AbilityDto> abilityDto);
    DataResult<List<Ability>> getAll(int jobSekerId);

}
