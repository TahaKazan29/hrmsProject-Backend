package hrms.hrmsProject.core.dataAccess;

import hrms.hrmsProject.core.entities.concretes.User;
import hrms.hrmsProject.core.utilities.results.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User getByEmail(String email);

}
