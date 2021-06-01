package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.WorkExperienceService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.WorkExperienceDao;
import hrms.hrmsProject.entities.concretes.Resume;
import hrms.hrmsProject.entities.concretes.School;
import hrms.hrmsProject.entities.concretes.WorkExperience;
import hrms.hrmsProject.entities.dtos.SchoolDto;
import hrms.hrmsProject.entities.dtos.WorkExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkExperienceManager implements WorkExperienceService {

    private WorkExperienceDao workExperienceDao;

    @Autowired
    public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }


    @Override
    public Result add(List<WorkExperienceDto> workExperienceDtos) {
        List<WorkExperience> workExperiences = new ArrayList<WorkExperience>();
        for (WorkExperienceDto workExperienceDto : workExperienceDtos){
            var resume = new Resume();
            var workExperience = new WorkExperience();
            workExperience.setId(workExperienceDto.getId());
            workExperience.setDepartureDate(workExperienceDto.getDepartureDate());
            workExperience.setDateOfStart(workExperienceDto.getDateOfStart());
            workExperience.setJobPosition(workExperienceDto.getJobPosition());
            workExperience.setWorkPlaceName(workExperienceDto.getWorkPlaceName());
            resume.setId(workExperienceDto.getResumeId());
            workExperience.setResume(resume);
            workExperiences.add(workExperience);
        }
        this.workExperienceDao.saveAll(workExperiences);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<WorkExperience>> getByBusinessDate(int jobSeekerId) {
        return new SuccessDataResult<>(this.workExperienceDao.getByBusinessDate(jobSeekerId));
    }
}
