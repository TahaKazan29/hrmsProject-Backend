package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.FavoritePost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavotirePostDao extends JpaRepository<FavoritePost,Integer> {

    List<FavoritePost> getAllByJobSeekerId(int jobSeekerId);
    FavoritePost findByJobSeekerIdAndPostId(int jobSeekerId,int postId);

}
