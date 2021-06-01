package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Ability;
import hrms.hrmsProject.entities.concretes.ForeignLanguage;
import hrms.hrmsProject.entities.dtos.ForeignLanguageDto;

import java.util.List;

public interface ForeignLanguageService {

    Result add(List<ForeignLanguageDto> foreignLanguageDtos);
    DataResult<List<ForeignLanguage>> getAll(int jobSekerId);


}
