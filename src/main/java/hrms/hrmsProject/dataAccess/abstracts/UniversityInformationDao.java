package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.UniversityInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityInformationDao extends JpaRepository<UniversityInformation,Integer> {
}
