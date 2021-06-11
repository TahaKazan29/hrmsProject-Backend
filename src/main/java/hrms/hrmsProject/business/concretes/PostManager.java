package hrms.hrmsProject.business.concretes;

import com.google.common.reflect.TypeToken;
import hrms.hrmsProject.business.abstracts.PostService;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.business.specifications.PostSpecs;
import hrms.hrmsProject.core.utilities.results.*;
import hrms.hrmsProject.dataAccess.abstracts.PostDao;
import hrms.hrmsProject.entities.concretes.Post;
import hrms.hrmsProject.entities.concretes.PostStatus;
import hrms.hrmsProject.entities.dtos.PostByFilterDto;
import hrms.hrmsProject.entities.dtos.PostListDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostManager implements PostService {

    private PostDao postDao;
    private ModelMapper modelMapper;

    @Autowired
    public PostManager(PostDao postDao,ModelMapper modelMapper) {
        this.postDao = postDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<PostListDto>> getFilter(PostByFilterDto postByFilterDto) {
        Specification<Post> spec1 = PostSpecs.postFilter(postByFilterDto);

        List<Post> result = this.postDao.findAll(spec1);
        List<Post> active = new ArrayList<>();

        for (Post post:result) {
            if(post.getStatus() == PostStatus.ACTIVE){
                active.add(post);
            }
        }

        Type listType = new TypeToken<List<PostListDto>>(){}.getType();
        List<PostListDto> dto = modelMapper.map(active,listType);
        return new SuccessDataResult<List<PostListDto>>(dto);
    }

    @Override
    public DataResult<List<Post>> getAll() {
        return new SuccessDataResult<List<Post>>(this.postDao.findAll());
    }

    @Override
    public DataResult<List<PostListDto>> getAllActives() {
        return new SuccessDataResult<List<PostListDto>>(this.postDao.getByStatus(PostStatus.ACTIVE));
    }

    @Override
    public DataResult<List<PostListDto>> getAllActivesByDate() {
        return new SuccessDataResult<List<PostListDto>>(this.postDao.getByStatusOrderByReleaseDate(PostStatus.ACTIVE));
    }

    @Override
    public DataResult<PostListDto> getActivesByDate(int postId) {
        return new SuccessDataResult<PostListDto>(this.postDao.getByIdAndStatus(postId,PostStatus.ACTIVE));
    }

    @Override
    public DataResult<List<PostListDto>> getAllPassive() {
        return new SuccessDataResult<List<PostListDto>>(this.postDao.getByStatus(PostStatus.PASSIVE));
    }

    @Override
    public DataResult<List<PostListDto>> getAllRejections() {
        return new SuccessDataResult<List<PostListDto>>(this.postDao.getByStatus(PostStatus.REJECTED));
    }

    @Override
    public DataResult<List<PostListDto>> getAllWaitingApproval() {
        return new SuccessDataResult<List<PostListDto>>(this.postDao.getByStatus(PostStatus.WAITING_APPROVAL));
    }

    @Override
    public DataResult<List<PostListDto>> getAllExpired() {
        return new SuccessDataResult<List<PostListDto>>(this.postDao.getByStatus(PostStatus.EXPIRED));
    }

    @Override
    public DataResult<List<PostListDto>> getAllActivesByCompany(int employerId) {
        return new SuccessDataResult<List<PostListDto>>(this.postDao.getAllActivesByCompany(employerId,PostStatus.ACTIVE));
    }

    @Override
    public DataResult<Post> getById(int id) {
        return new SuccessDataResult<Post>(this.postDao.findById(id).get());
    }

    @Override
    public Result add(Post post) {
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
