package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.EmployerProfileUpdate;

import java.util.List;

public interface EmployerProfileUpdateService {

    DataResult<EmployerProfileUpdate> add(EmployerProfileUpdate employerProfileUpdate);
    DataResult<EmployerProfileUpdate> delete(EmployerProfileUpdate employerProfileUpdate);
    DataResult<List<EmployerProfileUpdate>> getAll();
    DataResult<EmployerProfileUpdate> getById(int id);
    DataResult<EmployerProfileUpdate> getByEmployerId(int id);

}
