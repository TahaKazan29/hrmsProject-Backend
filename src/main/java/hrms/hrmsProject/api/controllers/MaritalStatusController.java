package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.MaritalStatusService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.Gender;
import hrms.hrmsProject.entities.concretes.MaritalStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/maritalStatus")
public class MaritalStatusController {

    private MaritalStatusService maritalStatusService;

    @Autowired
    public MaritalStatusController(MaritalStatusService maritalStatusService) {
        this.maritalStatusService = maritalStatusService;
    }

    @GetMapping("/getall")
    public DataResult<List<MaritalStatus>> getAll(){
        return this.maritalStatusService.getAll();
    }


}
