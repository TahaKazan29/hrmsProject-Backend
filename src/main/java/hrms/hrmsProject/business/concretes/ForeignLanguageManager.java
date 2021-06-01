package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.ForeignLanguageService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.ForeignLanguageDao;
import hrms.hrmsProject.entities.concretes.ForeignLanguage;
import hrms.hrmsProject.entities.concretes.Resume;
import hrms.hrmsProject.entities.concretes.WorkExperience;
import hrms.hrmsProject.entities.dtos.ForeignLanguageDto;
import hrms.hrmsProject.entities.dtos.WorkExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }

    @Override
    public Result add(List<ForeignLanguageDto> foreignLanguageDtos) {
        List<ForeignLanguage> foreignLanguages = new ArrayList<ForeignLanguage>();
        for (ForeignLanguageDto foreignLanguageDto : foreignLanguageDtos){
            var resume = new Resume();
            var foreignLanguage = new ForeignLanguage();
            foreignLanguage.setId(foreignLanguageDto.getId());
            foreignLanguage.setLanguageName(foreignLanguageDto.getLanguageName());
            foreignLanguage.setLanguagelevel(foreignLanguageDto.getLanguagelevel());
            resume.setId(foreignLanguageDto.getResumeId());
            foreignLanguage.setResume(resume);
            foreignLanguages.add(foreignLanguage);
        }
        this.foreignLanguageDao.saveAll(foreignLanguages);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll(int jobSekerId) {
        return new SuccessDataResult<>(this.foreignLanguageDao.getAll(jobSekerId));
    }
}
