package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.ForeignLanguageService;
import hrms.hrmsProject.entities.dtos.ForeignLanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foreignlanguages")
public class ForeignLanguagesController {

    private ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
        this.foreignLanguageService = foreignLanguageService;
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(int jobSeekerId){
        var result = foreignLanguageService.getAll(jobSeekerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody List<ForeignLanguageDto> foreignLanguageDtos) {
        var result = foreignLanguageService.add(foreignLanguageDtos);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }




}
