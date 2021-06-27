package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.HighSchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HighSchoolDao extends JpaRepository<HighSchool,Integer> {
}
