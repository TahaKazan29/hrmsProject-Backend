package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTimeDao extends JpaRepository<WorkingTime,Integer> {
}
