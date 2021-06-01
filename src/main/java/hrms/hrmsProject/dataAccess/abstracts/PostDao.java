package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.Post;
import hrms.hrmsProject.entities.concretes.PostStatus;
import hrms.hrmsProject.entities.dtos.PostListDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostDao extends JpaRepository<Post,Integer> {

    @Query("Select new hrms.hrmsProject.entities.dtos.PostListDto(p.id,p.description,p.positionCount," +
            "p.lastApplyDate,p.jobPosition.positionName,p.releaseDate,p.employer.companyName,p.city.name) From Post p")
    List<PostListDto> getByStatus(PostStatus postStatus);

//    List<Post> getByStatus(PostStatus postStatus);

    @Query("Select new hrms.hrmsProject.entities.dtos.PostListDto(p.id,p.description,p.positionCount," +
        "p.lastApplyDate,p.jobPosition.positionName,p.releaseDate,p.employer.companyName,p.city.name) From Post p")
    List<PostListDto> getByStatus(PostStatus postStatus, Sort sort);

    //@Query("From Post where employer.id=:employerId and status =:status")
    @Query("Select new hrms.hrmsProject.entities.dtos.PostListDto(p.id,p.description,p.positionCount," +
            "p.lastApplyDate,p.jobPosition.positionName,p.releaseDate,p.employer.companyName,p.city.name) From Post p  where p.status=:status and p.employer.id =:employerId")
    List<PostListDto> getAllActivesByCompany(int employerId,PostStatus status);


}
