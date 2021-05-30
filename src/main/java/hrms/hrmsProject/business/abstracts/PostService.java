package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Post;
import hrms.hrmsProject.entities.dtos.PostDto;

import java.util.List;

public interface PostService {

    DataResult<List<Post>> getAll();
    DataResult<List<Post>> getAllActives();
    DataResult<List<Post>> getAllActivesByDate();
    DataResult<List<Post>> getAllPassive();
    DataResult<List<Post>> getAllRejections();
    DataResult<List<Post>> getAllWaitingApproval();
    DataResult<List<Post>> getAllExpired();
    DataResult<List<Post>> getAllActivesByCompany(int employerId);
    DataResult<Post> getById(int id);
    Result add(Post post);
    Result update(Post entity);
    Result delete(Post entity);

}
