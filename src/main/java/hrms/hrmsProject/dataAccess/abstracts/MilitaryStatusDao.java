package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.MilitaryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilitaryStatusDao extends JpaRepository<MilitaryStatus,Integer> {
}
