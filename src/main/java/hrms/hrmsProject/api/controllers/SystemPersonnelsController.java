package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.SystemPersonnelService;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.JobPosition;
import hrms.hrmsProject.entities.concretes.SystemPersonnelConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/systempersonnels")
public class SystemPersonnelsController {

    private SystemPersonnelService systemPersonnelService;

    @Autowired
    public SystemPersonnelsController(SystemPersonnelService systemPersonnelService) {
        this.systemPersonnelService = systemPersonnelService;
    }

    @PostMapping("/confirm")
    public ResponseEntity confirm(int employerId,int personelId){
        var result = this.systemPersonnelService.confirmEmployerRegistration(employerId,personelId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/reject")
    public ResponseEntity reject(int employerId){
        var result = this.systemPersonnelService.rejectEmployerRegistration(employerId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


}
