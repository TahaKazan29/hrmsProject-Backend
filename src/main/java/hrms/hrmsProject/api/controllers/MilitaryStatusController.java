package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.MilitaryStatusService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.Gender;
import hrms.hrmsProject.entities.concretes.MilitaryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/militaryStatus")
public class MilitaryStatusController {

    private MilitaryStatusService militaryStatusService;

    @Autowired
    public MilitaryStatusController(MilitaryStatusService militaryStatusService) {
        this.militaryStatusService = militaryStatusService;
    }

    @GetMapping("/getall")
    public DataResult<List<MilitaryStatus>> getAll(){
        return this.militaryStatusService.getAll();
    }




}
