package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.JobPositionService;
import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.utilities.business.BusinessRules;
import hrms.hrmsProject.core.utilities.results.*;
import hrms.hrmsProject.dataAccess.abstracts.JobPositionDao;
import hrms.hrmsProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }


    @Override
    public DataResult<List<JobPosition>> getAll() {
        var result = this.jobPositionDao.findAll();
        result.remove(0);
        return new SuccessDataResult<List<JobPosition>>(result,Messages.positionListed());
    }

    @Override
    public DataResult<JobPosition> getById(int id) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.findById(id).get());
    }

    @Override
    public Result add(JobPosition jobPosition) {
        var result = BusinessRules.run(positionNameExists(jobPosition.getPositionName()));

        if(result != null){
            return result;
        }

        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.jobPositionAdded(jobPosition.getPositionName()));
    }

    @Override
    public Result update(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Pozisyon güncellendi");
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        this.jobPositionDao.delete(jobPosition);
        return new SuccessResult("Pozisyon silindi");
    }

    @Override
    public DataResult<JobPosition> getByPositionName(String positionName) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.getByPositionName(positionName));
    }

    public Result positionNameExists(String positionName){
        var result = getByPositionName(positionName);
        if(result.getData() != null) {
            return new ErrorResult(Messages.positionNameIsAlreadyAvailable());
        }
        return new SuccessResult();
    }
}
