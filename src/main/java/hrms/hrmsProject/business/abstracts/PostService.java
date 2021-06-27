package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Post;
import hrms.hrmsProject.entities.dtos.PostByFilterDto;
import hrms.hrmsProject.entities.dtos.PostListDto;

import java.util.List;

public interface PostService {

    DataResult<List<PostListDto>> getFilter(PostByFilterDto postByFilterDto,int pageNumber);
    DataResult<List<PostListDto>> getAll();
    DataResult<Post> getById(int postId);
    DataResult<PostListDto> getByPostDetail(int postId);
    DataResult<List<PostListDto>> getAllActives();
    DataResult<List<PostListDto>> getAllActivesByDate();
    DataResult<PostListDto> getActivesByDate(int postId);
    DataResult<List<PostListDto>> getAllPassive();
    DataResult<List<PostListDto>> getAllRejections();
    DataResult<List<PostListDto>> getAllWaitingApproval();
    DataResult<List<PostListDto>> getAllExpired();
    DataResult<List<PostListDto>> getAllActivesByCompany(int employerId);
    DataResult<List<Post>> getAllActivesByEmployerId(int employerId);
    DataResult<PostListDto> add(Post post);
    Result update(Post entity);
    Result delete(Post entity);

}
