package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.SystemPersonnelConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemPersonnelConfirmationDao extends JpaRepository<SystemPersonnelConfirmation, Integer> {

}
