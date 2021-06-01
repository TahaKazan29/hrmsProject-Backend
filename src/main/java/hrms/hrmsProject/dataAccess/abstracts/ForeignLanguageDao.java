package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage,Integer> {

    @Query("Select f from Resume r join r.foreignLanguages f where r.jobSeeker.id=:jobSeekerId")
    List<ForeignLanguage> getAll(int jobSeekerId);

}
