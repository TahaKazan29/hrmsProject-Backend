package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolDao extends JpaRepository<School,Integer> {

//    @Query("Select s from Resume r join r.schools s where r.jobSeeker.id=:jobSeekerId order by s.dateOfGraduation desc")
//    List<School> findByOrderByDateOfGraduationDesc(int jobSeekerId);

}
