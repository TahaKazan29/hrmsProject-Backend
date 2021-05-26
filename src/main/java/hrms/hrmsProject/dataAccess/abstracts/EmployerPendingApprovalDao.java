package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.EmployerPendingApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerPendingApprovalDao extends JpaRepository<EmployerPendingApproval,Integer> {
}
