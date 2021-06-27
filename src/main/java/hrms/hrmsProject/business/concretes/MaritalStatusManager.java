package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.MaritalStatusService;
import hrms.hrmsProject.business.abstracts.MilitaryStatusService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.MaritalStatusDao;
import hrms.hrmsProject.dataAccess.abstracts.MilitaryStatusDao;
import hrms.hrmsProject.entities.concretes.MaritalStatus;
import hrms.hrmsProject.entities.concretes.MilitaryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaritalStatusManager implements MaritalStatusService {

    private MaritalStatusDao maritalStatusDao;

    @Autowired
    public MaritalStatusManager(MaritalStatusDao maritalStatusDao) {
        this.maritalStatusDao = maritalStatusDao;
    }

    @Override
    public DataResult<List<MaritalStatus>> getAll() {
        var result = this.maritalStatusDao.findAll();
        result.remove(0);
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<MaritalStatus> getById(int id) {
        return null;
    }

    @Override
    public Result add(MaritalStatus entity) {
        return null;
    }

    @Override
    public Result update(MaritalStatus entity) {
        return null;
    }

    @Override
    public Result delete(MaritalStatus entity) {
        return null;
    }
}
