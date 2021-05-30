package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.CityService;
import hrms.hrmsProject.business.abstracts.JobPositionService;
import hrms.hrmsProject.business.abstracts.PostService;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.utilities.results.*;
import hrms.hrmsProject.dataAccess.abstracts.PostDao;
import hrms.hrmsProject.entities.concretes.Post;
import hrms.hrmsProject.entities.concretes.PostStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostManager implements PostService {

    private PostDao postDao;

    @Autowired
    public PostManager(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public DataResult<List<Post>> getAll() {
        return new SuccessDataResult<List<Post>>(this.postDao.findAll());
    }

    @Override
    public DataResult<List<Post>> getAllActives() {
        return new SuccessDataResult<List<Post>>(this.postDao.getByStatus(PostStatus.ACTIVE));
    }

    @Override
    public DataResult<List<Post>> getAllActivesByDate() {
        Sort sort = Sort.by(Sort.Direction.DESC,"lastApplyDate");
        return new SuccessDataResult<List<Post>>(this.postDao.getByStatus(PostStatus.ACTIVE,sort));
    }

    @Override
    public DataResult<List<Post>> getAllPassive() {
        return new SuccessDataResult<List<Post>>(this.postDao.getByStatus(PostStatus.PASSIVE));
    }

    @Override
    public DataResult<List<Post>> getAllRejections() {
        return new SuccessDataResult<List<Post>>(this.postDao.getByStatus(PostStatus.REJECTED));
    }

    @Override
    public DataResult<List<Post>> getAllWaitingApproval() {
        return new SuccessDataResult<List<Post>>(this.postDao.getByStatus(PostStatus.WAITING_APPROVAL));
    }

    @Override
    public DataResult<List<Post>> getAllExpired() {
        return new SuccessDataResult<List<Post>>(this.postDao.getByStatus(PostStatus.EXPIRED));
    }

    @Override
    public DataResult<List<Post>> getAllActivesByCompany(int employerId) {
        return new SuccessDataResult<List<Post>>(this.postDao.getAllActivesByCompany(employerId,PostStatus.ACTIVE));
    }

    @Override
    public DataResult<Post> getById(int id) {
        return new SuccessDataResult<Post>(this.postDao.findById(id).get());
    }

    @Override
    public Result add(Post post) {
        if(String.valueOf(post.getCity()) == null || post.getDescription() == ""
        || String.valueOf(post.getEmployer()) == null || String.valueOf(post.getPositionCount()) == ""
        || post.getJobPosition() == null){
            return new ErrorResult(Messages.postValidationError());
        }
        this.postDao.save(post);
        return new SuccessResult(Messages.postAdded());
    }

    @Override
    public Result update(Post entity) {
        this.postDao.save(entity);
        return new SuccessResult(Messages.postUpdated());
    }

    @Override
    public Result delete(Post entity) {
        return null;
    }
}
