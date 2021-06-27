package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.UniversityInformationService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.UniversityDao;
import hrms.hrmsProject.dataAccess.abstracts.UniversityInformationDao;
import hrms.hrmsProject.entities.concretes.UniversityInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityInformationManager implements UniversityInformationService {

    private UniversityInformationDao universityInformationDao;

    @Autowired
    public UniversityInformationManager(UniversityInformationDao universityInformationDao) {
        this.universityInformationDao = universityInformationDao;
    }

    @Override
    public DataResult<List<UniversityInformation>> getAll() {
        return new SuccessDataResult<List<UniversityInformation>>(this.universityInformationDao.findAll());
    }

    @Override
    public DataResult<UniversityInformation> getById(int id) {
        return null;
    }

    @Override
    public Result add(UniversityInformation entity) {
        return null;
    }

    @Override
    public Result update(UniversityInformation entity) {
        return null;
    }

    @Override
    public Result delete(UniversityInformation entity) {
        return null;
    }
}
