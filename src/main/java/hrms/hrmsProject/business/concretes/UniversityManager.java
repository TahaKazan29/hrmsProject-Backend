package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.UniversityService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.UniversityDao;
import hrms.hrmsProject.entities.concretes.University;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityManager implements UniversityService {

    private UniversityDao universityDao;

    public UniversityManager(UniversityDao universityDao) {
        this.universityDao = universityDao;
    }

    @Override
    public DataResult<List<University>> getAll() {
        return new SuccessDataResult<>(this.universityDao.findAll());
    }

    @Override
    public DataResult<University> getById(int id) {
        return null;
    }

    @Override
    public Result add(University entity) {
        return null;
    }

    @Override
    public Result update(University entity) {
        return null;
    }

    @Override
    public Result delete(University entity) {
        return null;
    }
}
