package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.GenderService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.GenderDao;
import hrms.hrmsProject.entities.concretes.Gender;
import hrms.hrmsProject.entities.concretes.Resume;
import hrms.hrmsProject.entities.dtos.GenderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderManager implements GenderService {

    private GenderDao genderDao;

    @Autowired
    public GenderManager(GenderDao genderDao) {
        this.genderDao = genderDao;
    }

    @Override
    public DataResult<List<Gender>> getAll() {
        var result = this.genderDao.findAll();
        result.remove(0);
        return new SuccessDataResult<List<Gender>>(result);
    }

    @Override
    public DataResult<Gender> getById(int id) {
        return new SuccessDataResult<>(this.genderDao.findById(id).get());
    }

    @Override
    public DataResult<Gender> getByJobSeeker(int id) {
        return new SuccessDataResult<>(this.genderDao.getByJobSeeker(id));
    }

    @Override
    public Result add(GenderDto genderDto) {
        return new SuccessResult();
    }

    @Override
    public Result update(GenderDto genderDto) {
        return null;
    }

    @Override
    public Result delete(GenderDto entity) {
        return null;
    }
}
