package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.JobSeekerImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerImageDao extends JpaRepository<JobSeekerImage,Integer> {
    List<JobSeekerImage> getAllByJobSeekerId(int jobSeekerId);
}
