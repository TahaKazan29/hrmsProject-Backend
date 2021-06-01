package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Post;
import hrms.hrmsProject.entities.dtos.PostDto;
import hrms.hrmsProject.entities.dtos.PostListDto;

import java.util.List;

public interface PostService {

    DataResult<List<Post>> getAll();
    DataResult<List<PostListDto>> getAllActives();
    DataResult<List<PostListDto>> getAllActivesByDate();
    DataResult<List<PostListDto>> getAllPassive();
    DataResult<List<PostListDto>> getAllRejections();
    DataResult<List<PostListDto>> getAllWaitingApproval();
    DataResult<List<PostListDto>> getAllExpired();
    DataResult<List<PostListDto>> getAllActivesByCompany(int employerId);
    DataResult<Post> getById(int id);
    Result add(Post post);
    Result update(Post entity);
    Result delete(Post entity);

}
