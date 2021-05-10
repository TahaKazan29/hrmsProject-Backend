package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {

}
