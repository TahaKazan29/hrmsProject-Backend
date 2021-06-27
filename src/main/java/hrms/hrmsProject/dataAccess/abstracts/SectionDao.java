package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionDao extends JpaRepository<Section,Integer> {

    List<Section> getByFaculityIdAndUniversityId(int uniId,int faculityId);

}
