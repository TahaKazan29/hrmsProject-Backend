package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.EmployerPendingApprovalService;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.EmployerPendingApprovalDao;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.EmployerPendingApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerPendingApprovalManager implements EmployerPendingApprovalService {

    private EmployerPendingApprovalDao pendingApprovalDao;

    @Autowired
    public EmployerPendingApprovalManager(EmployerPendingApprovalDao pendingApprovalDao) {
        this.pendingApprovalDao = pendingApprovalDao;
    }

    @Override
    public Result save(EmployerPendingApproval employerPendingApproval) {
        this.pendingApprovalDao.save(employerPendingApproval);
        return new SuccessResult();
    }

    @Override
    public DataResult<EmployerPendingApproval> getById(int id) {
        return new SuccessDataResult<EmployerPendingApproval>(this.pendingApprovalDao.findById(id).get());
    }

    @Override
    public DataResult<List<EmployerPendingApproval>> getAll() {
        return new SuccessDataResult<List<EmployerPendingApproval>>(this.pendingApprovalDao.findAll(), Messages.pendingApprovalListed());
    }

    @Override
    public Result delete(EmployerPendingApproval employerPendingApproval) {
        this.pendingApprovalDao.delete(employerPendingApproval);
        return new SuccessResult();
    }
}
