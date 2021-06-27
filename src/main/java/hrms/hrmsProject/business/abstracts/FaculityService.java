package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.Faculity;

import java.util.List;

public interface FaculityService extends BaseService<Faculity>{

    DataResult<List<Faculity>> getByUniversity(int id);

}
