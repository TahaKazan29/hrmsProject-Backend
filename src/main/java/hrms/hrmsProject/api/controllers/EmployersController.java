package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.EmployerService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.EmployerProfileUpdate;
import hrms.hrmsProject.entities.concretes.JobSeeker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employerService;

    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Employer> getById(int id){
        return this.employerService.getById(id);
    }

    @GetMapping("/getAllUpdateProfile")
    public DataResult<List<Employer>> getAllUpdateProfile(){
        return this.employerService.getAllUpdateProfile();
    }

    @GetMapping("/getAllActives")
    public DataResult<List<Employer>> getAllActives(){
        return this.employerService.getAllActives();
    }

    @GetMapping("/getAllPassive")
    public DataResult<List<Employer>> getAllPassive(){
        return this.employerService.getAllPassive();
    }

    @GetMapping("/getAllWaitingApproval")
    public DataResult<List<Employer>> getAllWaitingApproval(){
        return this.employerService.getAllWaitingApproval();
    }

    @GetMapping("/getAllRejected")
    public DataResult<List<Employer>> getAllRejected(){
        return this.employerService.getAllRejected();
    }

    @PostMapping("/passivePost")
    public ResponseEntity passivePost(int postId){
        var result = this.employerService.passivePost(postId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Employer employer){
        var result = this.employerService.update(employer);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/updateProfile")
    public ResponseEntity updateProfile(@RequestBody EmployerProfileUpdate employerProfileUpdate){
        var result = this.employerService.updateProfile(employerProfileUpdate);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }



}
