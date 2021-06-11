package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.JobPositionService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        super();
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody JobPosition position){
        var result = this.jobPositionService.add(position);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public Result update(JobPosition position){
        return this.jobPositionService.update(position);
    }

    @DeleteMapping("/delete")
    public Result delete(JobPosition position){
        return this.jobPositionService.delete(position);
    }



}
