package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenderDao extends JpaRepository<Gender,Integer> {

    @Query("Select g from Resume r join r.gender g where r.jobSeeker=:id")
    Gender getByJobSeeker(int id);

}
