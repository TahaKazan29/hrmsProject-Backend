package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.FavoritePostService;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.utilities.business.BusinessRules;
import hrms.hrmsProject.core.utilities.results.*;
import hrms.hrmsProject.dataAccess.abstracts.FavotirePostDao;
import hrms.hrmsProject.entities.concretes.FavoritePost;
import hrms.hrmsProject.entities.concretes.JobSeeker;
import hrms.hrmsProject.entities.concretes.Post;
import hrms.hrmsProject.entities.dtos.FavoritePostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritePostManager implements FavoritePostService {

    private FavotirePostDao favotirePostDao;

    @Autowired
    public FavoritePostManager(FavotirePostDao favotirePostDao) {
        this.favotirePostDao = favotirePostDao;
    }

    @Override
    public DataResult<List<FavoritePost>> getAll() {
        return new SuccessDataResult<>(this.favotirePostDao.findAll());
    }

    @Override
    public DataResult<FavoritePost> getById(int id) {
        return new SuccessDataResult<>(this.favotirePostDao.findById(id).get());
    }

    @Override
    public DataResult<List<FavoritePost>> getAllByJobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<>(this.favotirePostDao.getAllByJobSeekerId(jobSeekerId));
    }

    @Override
    public DataResult<FavoritePost> getAllByJobSeekerIdAndPostId(int jobSeekerId, int postId) {
        return new SuccessDataResult<>(this.favotirePostDao.findByJobSeekerIdAndPostId(jobSeekerId,postId));
    }

    @Override
    public DataResult<FavoritePost> add(FavoritePostDto favoritePostDto) {
        Post post = new Post();
        post.setId(favoritePostDto.getPostId());
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setId(favoritePostDto.getJobSeekerId());
        FavoritePost favoritePost = new FavoritePost();
        favoritePost.setPost(post);
        favoritePost.setJobSeeker(jobSeeker);

        var result = BusinessRules.run(checkFavoritePost(favoritePostDto));

        if(result != null ){
            return new ErrorDataResult<>(result.getMessage());
        }

        this.favotirePostDao.save(favoritePost);
        return new SuccessDataResult<>(favoritePost);
    }

    @Override
    public DataResult<FavoritePost> delete(int id) {
        FavoritePost favoritePost = new FavoritePost();
        favoritePost.setId(id);
        this.favotirePostDao.delete(favoritePost);
        return new SuccessDataResult<>(favoritePost);
    }

    public Result checkFavoritePost(FavoritePostDto favoritePostDto){
        var result = getAllByJobSeekerIdAndPostId(favoritePostDto.getJobSeekerId(),favoritePostDto.getPostId()).getData();
        if(result != null){
            return new ErrorResult(Messages.favoritePostError());
        }
        return new SuccessResult();
    }
}
