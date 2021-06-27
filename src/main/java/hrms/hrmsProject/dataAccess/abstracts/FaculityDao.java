package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.Faculity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaculityDao extends JpaRepository<Faculity,Integer> {

    List<Faculity> getByUniversityId(int id);

}
