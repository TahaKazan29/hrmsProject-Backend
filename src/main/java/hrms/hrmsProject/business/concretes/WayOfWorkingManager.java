package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.WayOfWorkingService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.WayOfWorkingDao;
import hrms.hrmsProject.entities.concretes.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WayOfWorkingManager implements WayOfWorkingService {

    private WayOfWorkingDao wayOfWorkingDao;

    @Autowired
    public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingDao) {
        this.wayOfWorkingDao = wayOfWorkingDao;
    }

    @Override
    public DataResult<List<WayOfWorking>> getAll() {
        return new SuccessDataResult<>(this.wayOfWorkingDao.findAll());
    }

    @Override
    public DataResult<WayOfWorking> getById(int id) {
        return new SuccessDataResult<>(this.wayOfWorkingDao.getOne(id));
    }

    @Override
    public Result add(WayOfWorking entity) {
        this.wayOfWorkingDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public Result update(WayOfWorking entity) {
        return null;
    }

    @Override
    public Result delete(WayOfWorking entity) {
        return null;
    }
}
