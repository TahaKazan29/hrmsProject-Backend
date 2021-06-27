package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.HobbyService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.HobbyDao;
import hrms.hrmsProject.entities.concretes.Hobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyManager implements HobbyService {

    private HobbyDao hobbyDao;

    @Autowired
    public HobbyManager(HobbyDao hobbyDao) {
        this.hobbyDao = hobbyDao;
    }


    @Override
    public DataResult<List<Hobby>> getAll() {
        return new SuccessDataResult<>(this.hobbyDao.findAll());
    }

    @Override
    public DataResult<Hobby> getById(int id) {
        return null;
    }

    @Override
    public Result add(Hobby entity) {
        return null;
    }

    @Override
    public Result update(Hobby entity) {
        return null;
    }

    @Override
    public Result delete(Hobby entity) {
        return null;
    }
}
