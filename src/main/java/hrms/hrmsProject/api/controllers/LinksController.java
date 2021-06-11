package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.LinkService;
import hrms.hrmsProject.entities.dtos.LinkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/links")
public class LinksController {

    private LinkService linkService;

    @Autowired
    public LinksController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(int jobSeekerId){
        var result = linkService.getAll(jobSeekerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody LinkDto linkDto) {
        var result = linkService.add(linkDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }




}
