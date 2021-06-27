package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.EmployerProfileUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployerProfileUpdateDao extends JpaRepository<EmployerProfileUpdate,Integer> {

    EmployerProfileUpdate getByEmployerId (int id);

}
