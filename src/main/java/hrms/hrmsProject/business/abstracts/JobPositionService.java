package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {

    List<JobPosition> getAll();

}
