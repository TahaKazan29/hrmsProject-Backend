package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.PostService;
import hrms.hrmsProject.entities.dtos.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    private PostService postService;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PostDto postDto) {
        var result = postService.add(postDto.toNewModel());
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        var result = postService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsActive")
    public ResponseEntity getIsActive(){
        var result = postService.getAllActives();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllActivesByDate")
    public ResponseEntity getAllActivesByDate(){
        var result = postService.getAllActivesByDate();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsPassive")
    public ResponseEntity getIsPassive(){
        var result = postService.getAllPassive();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsRejected")
    public ResponseEntity getIsRejected(){
        var result = postService.getAllRejections();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsWaitingApproval")
    public ResponseEntity getAllIsWaitingApproval(){
        var result = postService.getAllWaitingApproval();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsExpired")
    public ResponseEntity getAllIsExpired(){
        var result = postService.getAllExpired();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllActivesByCompany")
    public ResponseEntity getAllActivesByCompany(int employerId){
        var result = postService.getAllActivesByCompany(employerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


}
