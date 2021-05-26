package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.EmployerPendingApprovalService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.EmployerPendingApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employerpendingapprovals")
public class EmployerPendingApprovalsController {

    private EmployerPendingApprovalService employerPendingApprovalService;

    @Autowired
    public EmployerPendingApprovalsController(EmployerPendingApprovalService employerPendingApprovalService) {
        this.employerPendingApprovalService = employerPendingApprovalService;
    }

    @GetMapping("/getall")
    public DataResult<List<EmployerPendingApproval>> getAll(){
        return this.employerPendingApprovalService.getAll();
    }


}
