package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.HighSchoolService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.Gender;
import hrms.hrmsProject.entities.concretes.HighSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/highScholls")
public class HighSchoolsController {

    private HighSchoolService highSchoolService;

    @Autowired
    public HighSchoolsController(HighSchoolService highSchoolService) {
        this.highSchoolService = highSchoolService;
    }

    @GetMapping("/getall")
    public DataResult<List<HighSchool>> getAll(){
        return this.highSchoolService.getAll();
    }




}
