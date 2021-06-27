package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.WorkingSituation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingSituationDao extends JpaRepository<WorkingSituation,Integer> {
}
