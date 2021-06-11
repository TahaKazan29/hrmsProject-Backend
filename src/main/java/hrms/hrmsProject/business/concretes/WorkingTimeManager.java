package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.WorkingTimeService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.WorkingTimeDao;
import hrms.hrmsProject.entities.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeManager implements WorkingTimeService {

    private WorkingTimeDao workingTimeDao;

    @Autowired
    public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
        this.workingTimeDao = workingTimeDao;
    }


    @Override
    public DataResult<List<WorkingTime>> getAll() {
        return new SuccessDataResult<>(this.workingTimeDao.findAll());
    }

    @Override
    public DataResult<WorkingTime> getById(int id) {
        return null;
    }

    @Override
    public Result add(WorkingTime entity) {
        return null;
    }

    @Override
    public Result update(WorkingTime entity) {
        return null;
    }

    @Override
    public Result delete(WorkingTime entity) {
        return null;
    }
}
