package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.JobPositionService;
import hrms.hrmsProject.dataAccess.abstracts.JobPositionDao;
import hrms.hrmsProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<JobPosition> getAll() {
       /* ArrayList<JobPosition> arrays = new ArrayList<JobPosition>();
        JobPosition job1 = new JobPosition();
        job1.setPositionName("taha");
        arrays.add(job1);*/
        return this.jobPositionDao.findAll();
    }
}
