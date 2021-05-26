package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.EmployerPendingApprovalService;
import hrms.hrmsProject.business.abstracts.EmployerService;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.utilities.helpers.EmailService;
import hrms.hrmsProject.core.utilities.results.*;
import hrms.hrmsProject.dataAccess.abstracts.EmployerDao;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.EmployerPendingApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailService emailService;
    private EmployerPendingApprovalService employerPendingApprovalService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,EmailService emailService,
                           EmployerPendingApprovalService employerPendingApprovalService) {
        this.employerDao = employerDao;
        this.emailService = emailService;
        this.employerPendingApprovalService = employerPendingApprovalService;
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
    public Result add(Employer entity) {
        this.employerDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public Result update(Employer entity) {
        return null;
    }

    @Override
    public Result delete(Employer entity) {
        return null;
    }

    @Override
    public boolean isVerified() {
        return true;
    }

    @Override
    public Result checkEmailConfirm(EmployerPendingApproval entity){
        this.emailService.send(entity.getEmail(),"Doğrulama Kodu", UUID.randomUUID().toString());
        if (!this.isVerified()){
            return new ErrorResult();
        }
        this.employerPendingApprovalService.save(entity);
        return new SuccessResult();
    }
}
