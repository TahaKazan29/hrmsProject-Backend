package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.EmployerPendingApproval;

import java.util.List;

public interface EmployerPendingApprovalService {

    Result save(EmployerPendingApproval employerPendingApproval);
    DataResult<EmployerPendingApproval> getById(int id);
    DataResult<List<EmployerPendingApproval>> getAll();
    Result delete(EmployerPendingApproval employerPendingApproval);

}
