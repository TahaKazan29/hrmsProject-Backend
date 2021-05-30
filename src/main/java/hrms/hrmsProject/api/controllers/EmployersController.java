package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.EmployerService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.JobSeeker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/passivePost")
    public ResponseEntity passivePost(int postId){
        var result = this.employerService.passivePost(postId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }



}
