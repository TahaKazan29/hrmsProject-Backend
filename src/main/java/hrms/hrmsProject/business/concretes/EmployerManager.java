package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.EmployerProfileUpdateService;
import hrms.hrmsProject.business.abstracts.EmployerService;
import hrms.hrmsProject.business.abstracts.PostService;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.utilities.helpers.EmailService;
import hrms.hrmsProject.core.utilities.results.*;
import hrms.hrmsProject.dataAccess.abstracts.EmployerDao;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.EmployerProfileUpdate;
import hrms.hrmsProject.entities.enums.EmployerStatus;
import hrms.hrmsProject.entities.enums.PostStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailService emailService;
    private PostService postService;
    private EmployerProfileUpdateService employerProfileUpdateService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,EmailService emailService,
                           PostService postService,EmployerProfileUpdateService employerProfileUpdateService) {
        this.employerDao = employerDao;
        this.emailService = emailService;
        this.postService = postService;
        this.employerProfileUpdateService = employerProfileUpdateService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),Messages.employersListed());
    }

    @Override
    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(this.employerDao.findById(id).get());
    }

    @Override
    public DataResult<Employer> add(Employer entity) {
        this.emailService.send(entity.getEmail(),"Doğrulama Kodu", UUID.randomUUID().toString());
        if (!this.isVerified()){
            return new ErrorDataResult<>();
        }
        entity.setStatus(EmployerStatus.values()[0]);
        entity.setDateOfRegistration(Date.valueOf(LocalDate.now()));
        this.employerDao.save(entity);
        return new SuccessDataResult<>();
    }

    @Override
    public DataResult<Employer> update(Employer employer) {
        return new SuccessDataResult<>(this.employerDao.save(employer));
    }

    @Override
    public DataResult<Employer> updateProfile(EmployerProfileUpdate employerProfileUpdate) {
        var result = this.employerProfileUpdateService.add(employerProfileUpdate);
        if(!result.isSuccess()){
            return new ErrorDataResult<>(Messages.employerProfileUpdateError());
        }
        var employer = this.getById(employerProfileUpdate.getId());
        return new SuccessDataResult<>(employer.getData());
    }

    @Override
    public DataResult<Employer> delete(Employer entity) {
        return null;
    }

    @Override
    public DataResult<List<Employer>> getAllUpdateProfile() {
        var result = this.employerDao.getAllByEmployerProfileUpdates();
        for (Employer employer:result) {
            employer.setStatus(EmployerStatus.values()[4]);
        }
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<Employer>> getAllActives() {
        var result = this.employerDao.getByStatus(EmployerStatus.ACTIVE);
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<Employer>> getAllPassive() {
        var result = this.employerDao.getByStatus(EmployerStatus.PASSIVE);
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<Employer>> getAllWaitingApproval() {
        var result = this.employerDao.getByStatus(EmployerStatus.WAITING_APPROVAL);
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<Employer>> getAllRejected() {
        var result = this.employerDao.getByStatus(EmployerStatus.REJECTED);
        return new SuccessDataResult<>(result);
    }

    @Override
    public boolean isVerified() {
        return true;
    }

    @Override
    public Result passivePost(int postId) {
        var post = this.postService.getById(postId).getData();
        post.setStatus(PostStatus.values()[3]);
        var result = this.postService.update(post);
        if(!result.isSuccess()){
            return new ErrorResult(Messages.passivePostError());
        }
        return new SuccessResult(Messages.passivePost());
    }


}
