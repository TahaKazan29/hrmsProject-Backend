package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.entities.dtos.EmployerForRegisterDto;
import hrms.hrmsProject.entities.dtos.JobSeekerForRegisterDto;
import hrms.hrmsProject.core.entities.concretes.User;
import hrms.hrmsProject.core.entities.dtos.UserForLoginDto;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;

public interface AuthService {

    Result jobSeekerForRegister(JobSeekerForRegisterDto jobSeekerForRegisterDto);
    Result employerForRegister(EmployerForRegisterDto employerForRegisterDto);
    DataResult<User> login(UserForLoginDto userForLoginDto);
}
