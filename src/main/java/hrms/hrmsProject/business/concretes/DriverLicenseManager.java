package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.DriverLicenseService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.DriverLicenseDao;
import hrms.hrmsProject.entities.concretes.DriverLicense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverLicenseManager implements DriverLicenseService {

    private DriverLicenseDao driverLicenseDao;

    @Autowired
    public DriverLicenseManager(DriverLicenseDao driverLicenseDao) {
        this.driverLicenseDao = driverLicenseDao;
    }

    @Override
    public DataResult<List<DriverLicense>> getAll() {
        var result = this.driverLicenseDao.findAll();
        result.remove(0);
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<DriverLicense> getById(int id) {
        return null;
    }

    @Override
    public Result add(DriverLicense entity) {
        return null;
    }

    @Override
    public Result update(DriverLicense entity) {
        return null;
    }

    @Override
    public Result delete(DriverLicense entity) {
        return null;
    }
}
