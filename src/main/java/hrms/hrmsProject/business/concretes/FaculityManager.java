package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.FaculityService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.FaculityDao;
import hrms.hrmsProject.entities.concretes.Faculity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaculityManager implements FaculityService {

    private FaculityDao faculityDao;

    public FaculityManager(FaculityDao faculityDao) {
        this.faculityDao = faculityDao;
    }

    @Override
    public DataResult<List<Faculity>> getAll() {
        return new SuccessDataResult<>(this.faculityDao.findAll());
    }

    @Override
    public DataResult<List<Faculity>> getByUniversity(int id) {
        return new SuccessDataResult<>(this.faculityDao.getByUniversityId(id));
    }

    @Override
    public DataResult<Faculity> getById(int id) {
        return null;
    }

    @Override
    public Result add(Faculity entity) {
        return null;
    }

    @Override
    public Result update(Faculity entity) {
        return null;
    }

    @Override
    public Result delete(Faculity entity) {
        return null;
    }

}
