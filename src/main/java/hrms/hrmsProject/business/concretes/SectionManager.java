package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.SectionService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.SectionDao;
import hrms.hrmsProject.entities.concretes.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionManager implements SectionService {

    private SectionDao sectionDao;

    @Autowired
    public SectionManager(SectionDao sectionDao) {
        this.sectionDao = sectionDao;
    }

    @Override
    public DataResult<List<Section>> getAll() {
        return new SuccessDataResult<>(this.sectionDao.findAll());
    }

    @Override
    public DataResult<List<Section>> getByFaculity(int uniId,int faculityId) {
        return new SuccessDataResult<>(this.sectionDao.getByFaculityIdAndUniversityId(uniId,faculityId));
    }

    @Override
    public DataResult<Section> getById(int id) {
        return null;
    }

    @Override
    public Result add(Section entity) {
        return null;
    }

    @Override
    public Result update(Section entity) {
        return null;
    }

    @Override
    public Result delete(Section entity) {
        return null;
    }
}
