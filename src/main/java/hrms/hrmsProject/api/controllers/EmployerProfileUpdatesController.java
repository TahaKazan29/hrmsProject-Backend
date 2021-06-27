package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.EmployerProfileUpdateService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.EmployerProfileUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/employerProfileUpdates")
public class EmployerProfileUpdatesController {

    private EmployerProfileUpdateService employerProfileUpdateService;

    @Autowired
    public EmployerProfileUpdatesController(EmployerProfileUpdateService employerProfileUpdateService) {
        this.employerProfileUpdateService = employerProfileUpdateService;
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        var result = employerProfileUpdateService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getById")
    public ResponseEntity getById(int id){
        var result = employerProfileUpdateService.getById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody EmployerProfileUpdate employerProfileUpdate) {
        var result = employerProfileUpdateService.add(employerProfileUpdate);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

}
