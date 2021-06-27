package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.EducationLevelService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.EducationLevelDao;
import hrms.hrmsProject.entities.concretes.EducationLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationLevelManager implements EducationLevelService {

    private EducationLevelDao educationLevelDao;

    @Autowired
    public EducationLevelManager(EducationLevelDao educationLevelDao) {
        this.educationLevelDao = educationLevelDao;
    }

    @Override
    public DataResult<List<EducationLevel>> getAll() {
        return new SuccessDataResult<>(this.educationLevelDao.findAll());
    }

    @Override
    public DataResult<EducationLevel> getById(int id) {
        return null;
    }

    @Override
    public Result add(EducationLevel entity) {
        return null;
    }

    @Override
    public Result update(EducationLevel entity) {
        return null;
    }

    @Override
    public Result delete(EducationLevel entity) {
        return null;
    }
}
