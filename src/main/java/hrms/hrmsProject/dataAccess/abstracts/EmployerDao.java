package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.enums.EmployerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer,Integer> {

    @Query("From Employer e where e.status=:status")
    List<Employer> getByStatus(EmployerStatus status);
    @Query("Select e From EmployerProfileUpdate up join up.employer e  where e.id= up.employer.id")
    List<Employer> getAllByEmployerProfileUpdates();

}
