package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.MilitaryStatusService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.MilitaryStatusDao;
import hrms.hrmsProject.entities.concretes.MilitaryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilitaryStatusManager implements MilitaryStatusService {

    private MilitaryStatusDao militaryStatusDao;

    @Autowired
    public MilitaryStatusManager(MilitaryStatusDao militaryStatusDao) {
        this.militaryStatusDao = militaryStatusDao;
    }

    @Override
    public DataResult<List<MilitaryStatus>> getAll() {
        var result = this.militaryStatusDao.findAll();
        result.remove(0);
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<MilitaryStatus> getById(int id) {
        return null;
    }

    @Override
    public Result add(MilitaryStatus entity) {
        return null;
    }

    @Override
    public Result update(MilitaryStatus entity) {
        return null;
    }

    @Override
    public Result delete(MilitaryStatus entity) {
        return null;
    }
}
