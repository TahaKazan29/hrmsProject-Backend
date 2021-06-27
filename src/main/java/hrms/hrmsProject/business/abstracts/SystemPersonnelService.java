package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.EmployerProfileUpdate;
import hrms.hrmsProject.entities.concretes.SystemPersonnel;
import hrms.hrmsProject.entities.dtos.PostListDto;

import java.util.List;

public interface SystemPersonnelService {

    DataResult<List<SystemPersonnel>> getAll();
    DataResult<SystemPersonnel> getById(int id);
    DataResult<SystemPersonnel> add(SystemPersonnel systemPersonnel);
    DataResult<SystemPersonnel> update(SystemPersonnel systemPersonnel);
    DataResult<SystemPersonnel> delete(SystemPersonnel systemPersonnel);
    DataResult<Employer> activeEmployerRegistration(int employerId);
    DataResult<Employer> employerProfileUpdateAccept(int employerId);
    DataResult<EmployerProfileUpdate> employerProfileUpdateReject(int employerId);
    DataResult<Employer> rejectEmployerRegistration(int employerId);
    DataResult<Employer> passiveEmployerRegistration(int employerId);
    DataResult<PostListDto> activePost(int postId);
    DataResult<PostListDto> passivePost(int postId);
    DataResult<PostListDto> rejectPost(int postId);


}
