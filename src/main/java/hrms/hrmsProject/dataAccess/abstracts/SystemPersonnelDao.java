package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.SystemPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel, Integer> {

}
