package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.AbilityService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.AbilityDao;
import hrms.hrmsProject.entities.concretes.Ability;
import hrms.hrmsProject.entities.concretes.Resume;
import hrms.hrmsProject.entities.concretes.School;
import hrms.hrmsProject.entities.dtos.AbilityDto;
import hrms.hrmsProject.entities.dtos.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbilityManager implements AbilityService {

    private AbilityDao abilityDao;

    @Autowired
    public AbilityManager(AbilityDao abilityDao) {
        this.abilityDao = abilityDao;
    }


    @Override
    public Result add(List<AbilityDto> abilityDtos) {
        List<Ability> abilities = new ArrayList<Ability>();
        for (AbilityDto abilityDto : abilityDtos){
            var resume = new Resume();
            var ability = new Ability();
            ability.setId(abilityDto.getId());
            ability.setAbilityName(abilityDto.getAbilityName());
            ability.setTechnologyName(abilityDto.getTechnologyName());
            resume.setId(abilityDto.getResumeId());
            ability.setResume(resume);
            abilities.add(ability);
        }
        this.abilityDao.saveAll(abilities);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Ability>> getAll(int jobSekerId) {
        return new SuccessDataResult<>(this.abilityDao.getAll(jobSekerId));
    }
}
