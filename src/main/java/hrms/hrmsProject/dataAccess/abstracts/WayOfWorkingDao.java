package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.WayOfWorking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WayOfWorkingDao extends JpaRepository<WayOfWorking,Integer> {
}
