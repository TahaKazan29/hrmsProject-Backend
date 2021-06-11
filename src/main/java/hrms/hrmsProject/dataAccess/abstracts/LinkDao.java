package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LinkDao extends JpaRepository<Link,Integer> {

    @Query("Select a from Resume r join r.links a where r.jobSeeker.id=:jobSeekerId")
    List<Link> getAll(int jobSeekerId);

}
