package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.EducationLevelService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.EducationLevel;
import hrms.hrmsProject.entities.concretes.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/educationLevels")
public class EducationLevelsController {

    private EducationLevelService educationLevelService;

    @Autowired
    public EducationLevelsController(EducationLevelService educationLevelService) {
        this.educationLevelService = educationLevelService;
    }

    @GetMapping("/getall")
    public DataResult<List<EducationLevel>> getAll(){
        return this.educationLevelService.getAll();
    }


}
