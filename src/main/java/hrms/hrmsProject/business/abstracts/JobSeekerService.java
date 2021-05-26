package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.entities.concretes.JobSeeker;

public interface JobSeekerService extends BaseService<JobSeeker> {

    DataResult<JobSeeker> getByIdentityNumber(String identityNumber);
    boolean isVerified();
}
