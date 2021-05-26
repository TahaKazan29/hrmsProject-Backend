package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.AuthService;
import hrms.hrmsProject.business.abstracts.EmployerService;
import hrms.hrmsProject.business.abstracts.JobSeekerService;
import hrms.hrmsProject.business.abstracts.UserService;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.adapters.JobSeekerCheckService;
import hrms.hrmsProject.entities.concretes.EmployerPendingApproval;
import hrms.hrmsProject.entities.dtos.EmployerForRegisterDto;
import hrms.hrmsProject.entities.dtos.JobSeekerForRegisterDto;
import hrms.hrmsProject.core.entities.concretes.User;
import hrms.hrmsProject.entities.dtos.UserForLoginDto;
import hrms.hrmsProject.core.utilities.business.BusinessRules;
import hrms.hrmsProject.core.utilities.results.*;
import hrms.hrmsProject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthManager implements AuthService {

    private UserService userService;
    private JobSeekerService jobSeekerService;
    private EmployerService employerService;
    private JobSeekerCheckService jobSeekerCheckService;

    @Autowired
    public AuthManager(UserService userService,JobSeekerService jobSeekerService,EmployerService employerService,
                       JobSeekerCheckService jobSeekerCheckService){
        this.userService = userService;
        this.jobSeekerService = jobSeekerService;
        this.employerService = employerService;
        this.jobSeekerCheckService = jobSeekerCheckService;
    }

    @Override
    public Result jobSeekerForRegister(JobSeekerForRegisterDto jobSeekerForRegisterDto) {

        if(jobSeekerForRegisterDto.getFirstName() == "" ||
                jobSeekerForRegisterDto.getLastName() == "" ||
                jobSeekerForRegisterDto.getIdentityNumber() == "" ||
                jobSeekerForRegisterDto.getBirthYear() == "" ||
                jobSeekerForRegisterDto.getEmail() == "" ||
                jobSeekerForRegisterDto.getPassword() == "" ||
                jobSeekerForRegisterDto.getPasswordConfirm() == ""){
            return new ErrorResult(Messages.mustBeAllInformation());
        }

        var result = BusinessRules.run(checkEmail(jobSeekerForRegisterDto.getEmail()),
                checkIdentityNumber(jobSeekerForRegisterDto.getIdentityNumber()),checkIfRealPerson(jobSeekerForRegisterDto),
                checkPassword(jobSeekerForRegisterDto.getPassword(), jobSeekerForRegisterDto.getPasswordConfirm()));

        if(result != null){
            return  result;
        }

        var jobSeeker = new JobSeeker();
        jobSeeker.setFirstName(jobSeekerForRegisterDto.getFirstName());
        jobSeeker.setLastName(jobSeekerForRegisterDto.getLastName());
        jobSeeker.setBirthYear(Integer.parseInt(jobSeekerForRegisterDto.getBirthYear()));
        jobSeeker.setEmail(jobSeekerForRegisterDto.getEmail());
        jobSeeker.setPassword(jobSeekerForRegisterDto.getPassword());
        jobSeeker.setIdentityNumber(jobSeekerForRegisterDto.getIdentityNumber());

        var checkVerification = this.jobSeekerService.add(jobSeeker);
        if(!checkVerification.isSuccess()){
            return new ErrorResult(Messages.verificationFailed());
        }
        return new SuccessResult(Messages.jobSeekerRegistered());
    }

    @Override
    public Result employerForRegister(EmployerForRegisterDto employerForRegisterDto) {

        if(employerForRegisterDto.getCompanyName() == "" ||
                employerForRegisterDto.getWebsite() == "" ||
                employerForRegisterDto.getEmail() == "" ||
                employerForRegisterDto.getPhoneNumber() == "" ||
                employerForRegisterDto.getPassword() == "" ||
                employerForRegisterDto.getPasswordConfirm() == ""){
            return new ErrorResult(Messages.mustBeAllInformation());
        }

        var result = BusinessRules.run(checkDomain(employerForRegisterDto),
                checkEmail(employerForRegisterDto.getEmail()),
                checkPassword(employerForRegisterDto.getPassword(), employerForRegisterDto.getPasswordConfirm()));

        if(result != null){
            return result;
        }

        var employerPendingApproval = new EmployerPendingApproval();
        employerPendingApproval.setCompanyName(employerForRegisterDto.getCompanyName());
        employerPendingApproval.setPhoneNumber(employerForRegisterDto.getPhoneNumber());
        employerPendingApproval.setEmail(employerForRegisterDto.getEmail());
        employerPendingApproval.setWebSite(employerForRegisterDto.getWebsite());
        employerPendingApproval.setPassword(employerForRegisterDto.getPassword());

        var checkVerification = this.employerService.checkEmailConfirm(employerPendingApproval);
        if(!checkVerification.isSuccess()){
            return new ErrorResult(Messages.verificationFailed());
        }
        return new SuccessResult(Messages.pendingApproval());
    }

    @Override
    public DataResult<User> login(UserForLoginDto userForLoginDto) {
        return null;
    }

    public Result checkIdentityNumber(String identityNumber){
        var result = jobSeekerService.getByIdentityNumber(identityNumber);
        if(result.getData() != null) {
            return new ErrorResult(Messages.identityNumberIsAlreadyInUse());
        }
        return new SuccessResult();
    }

    public Result checkEmail(String email){
        var result = userService.getByEmail(email);
        if(result.getData() != null) {
            return new ErrorResult(Messages.emailIsAlreadyInUse());
        }
        return new SuccessResult();
    }

    public Result checkIfRealPerson(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
        var result = jobSeekerCheckService.checkIfRealPerson(jobSeekerForRegisterDto);
        if(!result){
            return new ErrorResult(Messages.notAValidPerson());
        }
        return new SuccessResult();
    }

    public Result checkDomain(EmployerForRegisterDto employerForRegisterDto){
        var result = employerForRegisterDto.getEmail().split("@");
        if (!result[1].equals(employerForRegisterDto.getWebsite())){
            return new ErrorResult(Messages.checkDomain());
        }
        return new SuccessResult();
    }

    public Result checkPassword(String password,String confirmPassword) {
        if(!password.equals(confirmPassword)){
            return new ErrorResult(Messages.passwordsAreIncompatible());
        }
        return new SuccessResult();
    }

}
