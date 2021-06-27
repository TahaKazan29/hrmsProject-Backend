package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.FavoritePostService;
import hrms.hrmsProject.entities.concretes.FavoritePost;
import hrms.hrmsProject.entities.dtos.FavoritePostDto;
import hrms.hrmsProject.entities.dtos.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/favoritePosts")
public class FavoritePostsController {

    private FavoritePostService favoritePostService;

    @Autowired
    public FavoritePostsController(FavoritePostService favoritePostService) {
        this.favoritePostService = favoritePostService;
    }

    @GetMapping("/getall")
    private ResponseEntity getAll(){
        var result = favoritePostService.getAll();
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getByJobSeekerId")
    private ResponseEntity getByJobSeekerId(int jobSeekerId){
        var result = favoritePostService.getAllByJobSeekerId(jobSeekerId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody FavoritePostDto favoritePostDto) {
        var result = favoritePostService.add(favoritePostDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/delete")
    public ResponseEntity delete(int id) {
        var result = favoritePostService.delete(id);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


}
