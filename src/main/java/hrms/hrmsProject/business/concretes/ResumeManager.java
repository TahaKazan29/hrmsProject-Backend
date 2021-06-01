package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.*;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.ResumeDao;
import hrms.hrmsProject.entities.concretes.JobSeeker;
import hrms.hrmsProject.entities.concretes.Resume;
import hrms.hrmsProject.entities.dtos.JobSeekerResumeDto;
import hrms.hrmsProject.entities.dtos.ResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;
    private JobSeekerService jobSeekerService;
    private SchoolService schoolService;
    private ForeignLanguageService foreignLanguageService;
    private AbilityService abilityService;
    private WorkExperienceService workExperienceService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao,JobSeekerService jobSeekerService,
                         SchoolService schoolService,ForeignLanguageService foreignLanguageService,
                         AbilityService abilityService,WorkExperienceService workExperienceService) {
        this.resumeDao = resumeDao;
        this.jobSeekerService=jobSeekerService;
        this.schoolService = schoolService;
        this.foreignLanguageService = foreignLanguageService;
        this.abilityService = abilityService;
        this.workExperienceService = workExperienceService;
    }

    @Override
    public Result add(ResumeDto resumeDto) {
        var jobSeeker = new JobSeeker();
        jobSeeker.setId(resumeDto.getJobSeekerId());
        var resume = new Resume();
        resume.setId(resume.getId());
        resume.setJobSeeker(jobSeeker);
        resume.setDescription(resumeDto.getDescription());
        resume.setGithubAddress(resumeDto.getGithubAddress());
        resume.setLinkedinAddress(resumeDto.getLinkedinAddress());
        this.resumeDao.save(resume);
        return new SuccessResult(Messages.resumeCreated());
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<>(this.resumeDao.findAll());
    }

    @Override
    public DataResult<Resume> getByJobSeekerForResume(int jobSeekerId) {
        return new SuccessDataResult<Resume>(this.resumeDao.getByJobSeekerId(jobSeekerId));
    }

    @Override
    public DataResult<Resume> getAllForInOrder(int jobSeekerId) {
        var result = this.resumeDao.getByJobSeekerId(jobSeekerId);
        result.setAbilities(this.abilityService.getAll(jobSeekerId).getData());
        result.setForeignLanguages(this.foreignLanguageService.getAll(jobSeekerId).getData());
        result.setWorkExperiences(this.workExperienceService.getByBusinessDate(jobSeekerId).getData());
        result.setSchools(this.schoolService.getAllByJobSeekerOrderByDateOfGraduation(jobSeekerId).getData());
        return new SuccessDataResult<>(result);
    }
}
