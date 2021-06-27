package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.FavoritePost;
import hrms.hrmsProject.entities.dtos.FavoritePostDto;

import java.util.List;

public interface FavoritePostService {

    DataResult<List<FavoritePost>> getAll();
    DataResult<FavoritePost> getById(int id);
    DataResult<List<FavoritePost>> getAllByJobSeekerId(int jobSeekerId);
    DataResult<FavoritePost> getAllByJobSeekerIdAndPostId(int jobSeekerId,int postId);
    DataResult<FavoritePost> add(FavoritePostDto favoritePostDto);
    DataResult<FavoritePost> delete(int id);

}
