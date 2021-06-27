package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaritalStatusDao extends JpaRepository<MaritalStatus,Integer> {
}
