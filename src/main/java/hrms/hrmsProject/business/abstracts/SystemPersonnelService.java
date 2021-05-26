package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.SystemPersonnel;
import hrms.hrmsProject.entities.concretes.SystemPersonnelConfirmation;

public interface SystemPersonnelService extends BaseService<SystemPersonnel>{
    Result confirmEmployerRegistration(int employerId,int personnelId);
    Result rejectEmployerRegistration(int employerId);


}
