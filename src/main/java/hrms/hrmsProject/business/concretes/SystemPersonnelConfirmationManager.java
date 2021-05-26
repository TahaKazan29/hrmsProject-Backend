package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.SystemPersonnelConfirmationService;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.SystemPersonnelConfirmationDao;
import hrms.hrmsProject.entities.concretes.SystemPersonnelConfirmation;
import org.springframework.stereotype.Service;

@Service
public class SystemPersonnelConfirmationManager implements SystemPersonnelConfirmationService {

    private SystemPersonnelConfirmationDao systemPersonnelConfirmationDao;

    public SystemPersonnelConfirmationManager(SystemPersonnelConfirmationDao systemPersonnelConfirmationDao) {
        this.systemPersonnelConfirmationDao = systemPersonnelConfirmationDao;
    }

    @Override
    public Result add(SystemPersonnelConfirmation systemPersonnelConfirmation) {
        this.systemPersonnelConfirmationDao.save(systemPersonnelConfirmation);
        return new SuccessResult();
    }
}
