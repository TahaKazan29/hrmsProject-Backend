package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.EmployerProfileUpdateService;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.utilities.business.BusinessRules;
import hrms.hrmsProject.core.utilities.results.*;
import hrms.hrmsProject.dataAccess.abstracts.EmployerProfileUpdateDao;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.EmployerProfileUpdate;
import hrms.hrmsProject.entities.enums.EmployerStatus;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerProfileUpdateManager implements EmployerProfileUpdateService {

    private EmployerProfileUpdateDao employerProfileUpdateDao;

    @Autowired
    public EmployerProfileUpdateManager(EmployerProfileUpdateDao employerProfileUpdateDao) {
        this.employerProfileUpdateDao = employerProfileUpdateDao;
    }

    @Override
    public DataResult<EmployerProfileUpdate> add(EmployerProfileUpdate employerProfileUpdate) {
        Employer employer = new Employer();
        employer.setId(employerProfileUpdate.getId());
        var result = BusinessRules.run(checkEmployerProfileUpdate(employer.getId()));
        if(result != null){
            return new ErrorDataResult<>();
        }
        employerProfileUpdate.setStatus(EmployerStatus.values()[4]);
        employerProfileUpdate.setEmployer(employer);
        return new SuccessDataResult<>(this.employerProfileUpdateDao.save(employerProfileUpdate));
    }

    @Override
    public DataResult<EmployerProfileUpdate> delete(EmployerProfileUpdate employerProfileUpdate) {
        this.employerProfileUpdateDao.delete(employerProfileUpdate);
        return new SuccessDataResult<>(employerProfileUpdate);
    }

    @Override
    public DataResult<List<EmployerProfileUpdate>> getAll() {
        return new SuccessDataResult<>(this.employerProfileUpdateDao.findAll());
    }

    @Override
    public DataResult<EmployerProfileUpdate> getById(int id) {
        return new SuccessDataResult<>(this.employerProfileUpdateDao.findById(id).get());
    }

    @Override
    public DataResult<EmployerProfileUpdate> getByEmployerId(int id) {
        return new SuccessDataResult<>(this.employerProfileUpdateDao.getByEmployerId(id));
    }

    public Result checkEmployerProfileUpdate(int id){
        var result = this.employerProfileUpdateDao.getByEmployerId(id);
        if(result != null){
           return new ErrorResult();
        }
        return new SuccessResult();
    }
}
