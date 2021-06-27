package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyDao extends JpaRepository<Hobby,Integer> {
}
