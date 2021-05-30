package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.EmployerPendingApproval;
import hrms.hrmsProject.entities.concretes.JobSeeker;

public interface EmployerService extends BaseService<Employer>{
    Result checkEmailConfirm(EmployerPendingApproval entity);
    boolean isVerified();
    Result passivePost(int postId);

}
