package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
}
