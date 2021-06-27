package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.GenderService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.Gender;
import hrms.hrmsProject.entities.dtos.ForeignLanguageDto;
import hrms.hrmsProject.entities.dtos.GenderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/genders")
public class GendersController {

    private GenderService genderService;
    private ModelMapper modelMapper;


    @Autowired
    public GendersController(GenderService genderService,ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.genderService = genderService;
    }

    @GetMapping("/getall")
    public DataResult<List<Gender>> getAll(){
        return this.genderService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody GenderDto genderDto) {
        var result = genderService.add(genderDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }




}
