package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.Faculity;
import hrms.hrmsProject.entities.concretes.Section;

import java.util.List;

public interface SectionService extends BaseService<Section>{

    DataResult<List<Section>> getByFaculity(int uniId,int faculityId);

}
