package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.WorkingSituationService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.Gender;
import hrms.hrmsProject.entities.concretes.WorkingSituation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/workingSituations")
public class WorkingSituationsController {

    private WorkingSituationService workingSituationService;

    @Autowired
    public WorkingSituationsController(WorkingSituationService workingSituationService) {
        this.workingSituationService = workingSituationService;
    }

    @GetMapping("/getall")
    public DataResult<List<WorkingSituation>> getAll(){
        return this.workingSituationService.getAll();
    }




}
