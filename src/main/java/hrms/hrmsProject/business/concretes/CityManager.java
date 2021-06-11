package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.CityService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.CityDao;
import hrms.hrmsProject.entities.concretes.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    private CityDao cityDao;

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<>(this.cityDao.findAll());
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(this.cityDao.findById(id).get());
    }

    @Override
    public Result add(City entity) {
        return null;
    }

    @Override
    public Result update(City entity) {
        return null;
    }

    @Override
    public Result delete(City entity) {
        return null;
    }
}
