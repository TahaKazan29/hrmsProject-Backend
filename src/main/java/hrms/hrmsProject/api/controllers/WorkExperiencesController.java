package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.WorkExperienceService;
import hrms.hrmsProject.entities.dtos.WorkExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workExperiences")
public class WorkExperiencesController {

    private WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperiencesController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody List<WorkExperienceDto> workExperienceDtos) {
        var result = workExperienceService.add(workExperienceDtos);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllByBusinessDate")
    public ResponseEntity getAllByBusinessDate(int jobSeekerId){
        var result = workExperienceService.getByBusinessDate(jobSeekerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }




}
