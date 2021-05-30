package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.SystemPersonnelService;
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
