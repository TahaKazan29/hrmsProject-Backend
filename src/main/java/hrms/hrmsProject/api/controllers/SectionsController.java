package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.SectionService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.Faculity;
import hrms.hrmsProject.entities.concretes.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/sections")
public class SectionsController {

    private SectionService sectionService;

    @Autowired
    public SectionsController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/getall")
    public DataResult<List<Section>> getAll(){
        return this.sectionService.getAll();
    }

    @GetMapping("/getByFaculity")
    public DataResult<List<Section>> getByFaculity(int uniId,int faculityId){
        return this.sectionService.getByFaculity(uniId,faculityId);
    }



}
