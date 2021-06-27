package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.DriverLicenseService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.DriverLicense;
import hrms.hrmsProject.entities.concretes.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/driverLicenses")
public class DriverLicensesController {

    private DriverLicenseService driverLicenseService;

    @Autowired
    public DriverLicensesController(DriverLicenseService driverLicenseService) {
        this.driverLicenseService = driverLicenseService;
    }

    @GetMapping("/getall")
    public DataResult<List<DriverLicense>> getAll(){
        return this.driverLicenseService.getAll();
    }


}
