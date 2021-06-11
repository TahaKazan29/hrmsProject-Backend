package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.WayOfWorkingService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.City;
import hrms.hrmsProject.entities.concretes.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/waysofworking")
@CrossOrigin
public class WaysOfWorkingController {

    private WayOfWorkingService wayOfWorkingService;

    @Autowired
    public WaysOfWorkingController(WayOfWorkingService wayOfWorkingService) {
        this.wayOfWorkingService = wayOfWorkingService;
    }

    @GetMapping("/getall")
    public DataResult<List<WayOfWorking>> getAll(){
        return this.wayOfWorkingService.getAll();
    }


}
