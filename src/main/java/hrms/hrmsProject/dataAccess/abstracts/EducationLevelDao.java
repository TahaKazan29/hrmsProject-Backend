package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.EducationLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationLevelDao extends JpaRepository<EducationLevel,Integer> {
}
