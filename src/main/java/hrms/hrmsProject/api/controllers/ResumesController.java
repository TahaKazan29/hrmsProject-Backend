package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.*;
import hrms.hrmsProject.entities.concretes.Resume;
import hrms.hrmsProject.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {

    private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody ResumeDto resumeDto) {
        var result = resumeService.add(resumeDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


    @GetMapping("/getAllForInOrder")
    public ResponseEntity getAll(){
        var result = resumeService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getByJobSeekerForResume")
    public ResponseEntity getByJobSeekerForResume(int jobSeekerId){
        var result = resumeService.getByJobSeekerForResume(jobSeekerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getBy")
    public ResponseEntity getAllForInOrder(int jobSeekerId){
        var result = resumeService.getByJobSeekerForResume(jobSeekerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }




}
