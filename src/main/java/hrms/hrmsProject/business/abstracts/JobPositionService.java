package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.JobPosition;

public interface JobPositionService extends BaseService<JobPosition> {

    DataResult<JobPosition> getByPositionName(String positionName);

}
