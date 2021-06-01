package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.AuthService;
import hrms.hrmsProject.entities.dtos.EmployerForRegisterDto;
import hrms.hrmsProject.entities.dtos.JobSeekerForRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/jobseekerforregister")
    public ResponseEntity jobSeekerForRegister(@Valid @RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto) {
        var result = authService.jobSeekerForRegister(jobSeekerForRegisterDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/employerforregister")
    public ResponseEntity employerForRegister(@Valid @RequestBody EmployerForRegisterDto employerForRegisterDto) {
        var result = authService.employerForRegister(employerForRegisterDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
