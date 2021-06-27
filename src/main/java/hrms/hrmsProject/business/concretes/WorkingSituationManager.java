package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.WorkingSituationService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.WorkingSituationDao;
import hrms.hrmsProject.entities.concretes.WorkingSituation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingSituationManager implements WorkingSituationService {

    private WorkingSituationDao workingSituationDao;

    @Autowired
    public WorkingSituationManager(WorkingSituationDao workingSituationDao) {
        this.workingSituationDao = workingSituationDao;
    }

    @Override
    public DataResult<List<WorkingSituation>> getAll() {
        var result = this.workingSituationDao.findAll();
        result.remove(0);
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<WorkingSituation> getById(int id) {
        return null;
    }

    @Override
    public Result add(WorkingSituation entity) {
        return null;
    }

    @Override
    public Result update(WorkingSituation entity) {
        return null;
    }

    @Override
    public Result delete(WorkingSituation entity) {
        return null;
    }
}
