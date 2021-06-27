package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.SystemPersonnelService;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.SystemPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/systempersonnels")
public class SystemPersonnelsController {

    private SystemPersonnelService systemPersonnelService;

    @Autowired
    public SystemPersonnelsController(SystemPersonnelService systemPersonnelService) {
        this.systemPersonnelService = systemPersonnelService;
    }

    @GetMapping("/getById")
    public ResponseEntity getById(int id){
        var result = this.systemPersonnelService.getById(id);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody SystemPersonnel systemPersonnel){
        var result = this.systemPersonnelService.update(systemPersonnel);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/employerProfileUpdateAccept")
    public ResponseEntity employerProfileUpdateAccept(int employerId){
        var result = this.systemPersonnelService.employerProfileUpdateAccept(employerId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/employerProfileUpdateReject")
    public ResponseEntity employerProfileUpdateReject(int employerId){
        var result = this.systemPersonnelService.employerProfileUpdateReject(employerId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/activeEmployer")
    public ResponseEntity activeEmployer(int employerId){
        var result = this.systemPersonnelService.activeEmployerRegistration(employerId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/rejectEmployer")
    public ResponseEntity rejectEmployer(int employerId){
        var result = this.systemPersonnelService.rejectEmployerRegistration(employerId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/passiveEmployer")
    public ResponseEntity passiveEmployer(int employerId){
        var result = this.systemPersonnelService.passiveEmployerRegistration(employerId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/activePost")
    public ResponseEntity activePost(int postId){
        var result = this.systemPersonnelService.activePost(postId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/passivePost")
    public ResponseEntity passivePost(int postId){
        var result = this.systemPersonnelService.passivePost(postId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/rejectPost")
    public ResponseEntity rejectPost(int postId){
        var result = this.systemPersonnelService.rejectPost(postId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


}
