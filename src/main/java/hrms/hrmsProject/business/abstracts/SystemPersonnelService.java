package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService extends BaseService<SystemPersonnel>{
    Result confirmEmployerRegistration(int employerId,int personnelId);
    Result rejectEmployerRegistration(int employerId);
    Result activePost(int postId);
    Result passivePost(int postId);
    Result rejectPost(int postId);


}
