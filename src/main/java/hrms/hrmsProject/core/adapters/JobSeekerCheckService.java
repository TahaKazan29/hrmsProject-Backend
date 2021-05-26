package hrms.hrmsProject.core.adapters;

import hrms.hrmsProject.entities.dtos.JobSeekerForRegisterDto;

public interface JobSeekerCheckService {

    boolean checkIfRealPerson(JobSeekerForRegisterDto jobSeeker);

}
