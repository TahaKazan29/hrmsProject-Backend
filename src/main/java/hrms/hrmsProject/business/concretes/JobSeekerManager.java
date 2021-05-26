package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.JobSeekerService;
import hrms.hrmsProject.business.abstracts.UserService;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.utilities.helpers.EmailService;
import hrms.hrmsProject.core.utilities.results.*;
import hrms.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import hrms.hrmsProject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private EmailService emailService;
    private UserService userService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,EmailService emailService,UserService userService){
        this.jobSeekerDao = jobSeekerDao;
        this.emailService = emailService;
        this.userService = userService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),Messages.jobSeekersListed());
    }

    @Override
    public DataResult<JobSeeker> getById(int id) {
        return null;
    }

    @Override
    public Result add(JobSeeker entity) {
        this.emailService.send(entity.getEmail(),"Doğrulama Kodu", UUID.randomUUID().toString());
        if (!this.isVerified()){
            return new ErrorResult();
        }
        this.jobSeekerDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public Result update(JobSeeker entity) {
        return null;
    }

    @Override
    public boolean isVerified() {
        return true;
    }

    @Override
    public Result delete(JobSeeker entity) {
        return null;
    }

    @Override
    public DataResult<JobSeeker> getByIdentityNumber(String identityNumber) {
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByIdentityNumber(identityNumber));
    }
}
