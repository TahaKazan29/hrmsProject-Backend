package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.SchoolService;
import hrms.hrmsProject.entities.dtos.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody List<SchoolDto> schools) {
        var result = schoolService.add(schools);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllByJobSeekerOrderByDateOfGraduation")
    public ResponseEntity getAllByJobSeekerOrderByDateOfGraduation(int jobSeekerId){
        var result = schoolService.getAllByJobSeekerOrderByDateOfGraduation(jobSeekerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }






}
