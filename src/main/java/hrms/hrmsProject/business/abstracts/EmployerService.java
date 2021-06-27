package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.EmployerProfileUpdate;

import java.util.List;

public interface EmployerService {
    DataResult<Employer> add(Employer employer);
    DataResult<Employer> updateProfile(EmployerProfileUpdate employerProfileUpdate);
    DataResult<Employer> update(Employer employer);
    DataResult<Employer> delete(Employer employer);
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int id);
    DataResult<List<Employer>> getAllUpdateProfile();
    DataResult<List<Employer>> getAllActives();
    DataResult<List<Employer>> getAllPassive();
    DataResult<List<Employer>> getAllWaitingApproval();
    DataResult<List<Employer>> getAllRejected();
    boolean isVerified();
    Result passivePost(int postId);

}
