package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.entities.concretes.User;
import hrms.hrmsProject.core.utilities.results.DataResult;


public interface UserService extends BaseService<User> {

    DataResult<User> getByEmail(String email);
}
