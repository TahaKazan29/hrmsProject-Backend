package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AbilityDao extends JpaRepository<Ability,Integer> {

    @Query("Select a from Resume r join r.abilities a where r.jobSeeker.id=:jobSeekerId")
    List<Ability> getAll(int jobSeekerId);

}
