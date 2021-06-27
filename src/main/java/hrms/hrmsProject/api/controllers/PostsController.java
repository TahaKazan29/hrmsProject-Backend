package hrms.hrmsProject.api.controllers;

import hrms.hrmsProject.business.abstracts.PostService;
import hrms.hrmsProject.entities.concretes.Post;
import hrms.hrmsProject.entities.dtos.PostByFilterDto;
import hrms.hrmsProject.entities.dtos.PostDto;
import hrms.hrmsProject.entities.dtos.PostListDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/posts")
public class PostsController {

    private PostService postService;
    private ModelMapper modelMapper;

    @Autowired
    public PostsController(PostService postService,ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody PostDto postDto) {
        var result = postService.add(postDto.toNewModel());
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/getFilter")
    public ResponseEntity getfilter(@RequestBody PostByFilterDto postByFilterDto,int pageNumber){
        var result = postService.getFilter(postByFilterDto,pageNumber);
        if (result.isSuccess()){
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
    public ResponseEntity getAllActives(){
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

    @GetMapping("/getActivesByDate")
    public ResponseEntity getActivesByDate(@RequestParam int postId){
        var result = postService.getActivesByDate(postId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsPassive")
    public ResponseEntity getAllIsPassive(){
        var result = postService.getAllPassive();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsRejected")
    public ResponseEntity getAllIsRejected(){
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

    @GetMapping("/getById")
    public ResponseEntity getById(int postId){
        var result = postService.getById(postId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getByPostDetail")
    public ResponseEntity getByPostDetail(int postId){
        var result = postService.getByPostDetail(postId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


}
