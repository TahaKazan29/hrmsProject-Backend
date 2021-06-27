package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.*;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.utilities.business.BusinessRules;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.ResumeDao;
import hrms.hrmsProject.entities.concretes.*;
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
    private GenderService genderService;
    private SchoolService schoolService;
    private ForeignLanguageService foreignLanguageService;
    private AbilityService abilityService;
    private WorkExperienceService workExperienceService;
    private LinkService linkService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao,JobSeekerService jobSeekerService,
                         SchoolService schoolService,ForeignLanguageService foreignLanguageService,
                         AbilityService abilityService,WorkExperienceService workExperienceService,
                         LinkService linkService,GenderService genderService) {
        this.resumeDao = resumeDao;
        this.jobSeekerService=jobSeekerService;
        this.schoolService = schoolService;
        this.foreignLanguageService = foreignLanguageService;
        this.abilityService = abilityService;
        this.workExperienceService = workExperienceService;
        this.linkService = linkService;
        this.genderService = genderService;
    }

    // will be rearranged
    @Override
    public Result add(ResumeDto resumeDto) {
        var resume = new Resume();

        var city = new City();
        city.setId(resumeDto.getCityId());
        resume.setCity(city);

        var gender = new Gender();
        gender.setId(resumeDto.getGenderId());
        resume.setGender(gender);

        var military = new MilitaryStatus();
        military.setId(resumeDto.getMilitaryStatusId());
        resume.setMilitaryStatus(military);

        var marital = new MaritalStatus();
        marital.setId(resumeDto.getMaritalStatusId());
        resume.setMaritalStatus(marital);

        var driveLicense = new DriverLicense();
        driveLicense.setId(resumeDto.getDriverLicenseId());
        resume.setDriverLicense(driveLicense);

        var highSchool = new HighSchool();
        highSchool.setId(resumeDto.getHightSchoolId());
        resume.setHighSchool(highSchool);

        var workingSituation = new WorkingSituation();
        workingSituation.setId(resumeDto.getWorkingSituationId());
        resume.setWorkingSituation(workingSituation);

        var jobSeeker = new JobSeeker();
        jobSeeker.setId(resumeDto.getJobSeekerId());
        resume.setId(resume.getId());

        resume.setJobSeeker(jobSeeker);
        resume.setDescription(resumeDto.getDescription());
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
        result.setGender(this.genderService.getByJobSeeker(jobSeekerId).getData());
        result.setAbilities(this.abilityService.getAll(jobSeekerId).getData());
        result.setForeignLanguages(this.foreignLanguageService.getAll(jobSeekerId).getData());
        result.setWorkExperiences(this.workExperienceService.getByBusinessDate(jobSeekerId).getData());
//        result.setSchools(this.schoolService.getAllByJobSeekerOrderByDateOfGraduation(jobSeekerId).getData());
        result.setLinks(this.linkService.getAll(jobSeekerId).getData());
        return new SuccessDataResult<>(result);
    }


}
