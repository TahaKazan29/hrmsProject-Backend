package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.HighSchoolService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.HighSchoolDao;
import hrms.hrmsProject.entities.concretes.HighSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighSchoolManager implements HighSchoolService {

    private HighSchoolDao highSchoolDao;

    @Autowired
    public HighSchoolManager(HighSchoolDao highSchoolDao) {
        this.highSchoolDao = highSchoolDao;
    }

    @Override
    public DataResult<List<HighSchool>> getAll() {
        var result = this.highSchoolDao.findAll();
        result.remove(0);
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<HighSchool> getById(int id) {
        return null;
    }

    @Override
    public Result add(HighSchool entity) {
        return null;
    }

    @Override
    public Result update(HighSchool entity) {
        return null;
    }

    @Override
    public Result delete(HighSchool entity) {
        return null;
    }
}
