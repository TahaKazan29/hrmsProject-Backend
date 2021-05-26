package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.UserService;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.entities.concretes.User;
import hrms.hrmsProject.core.utilities.helpers.EmailService;
import hrms.hrmsProject.core.utilities.results.*;
import hrms.hrmsProject.dataAccess.abstracts.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;
    private EmailService emailService;

    @Autowired
    public UserManager(UserDao userDao, EmailService emailService){
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult();
    }

    @Override
    public Result update(User entity) {
        return null;
    }

    @Override
    public Result delete(User entity) {
        return null;
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.getByEmail(email));
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(),Messages.usersListed());
    }

    @Override
    public DataResult<User> getById(int id) {
        return null;
    }


}
