package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

    JobSeeker getByIdentityNumber(String identityNumber);

}
