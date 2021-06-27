package hrms.hrmsProject.dataAccess.abstracts;

import hrms.hrmsProject.entities.concretes.DriverLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverLicenseDao extends JpaRepository<DriverLicense,Integer> {
}
