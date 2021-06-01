package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Resume;
import hrms.hrmsProject.entities.dtos.JobSeekerResumeDto;
import hrms.hrmsProject.entities.dtos.ResumeDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ResumeService {

    Result add(ResumeDto resumeDto);
    DataResult<List<Resume>> getAll();
    DataResult<Resume> getByJobSeekerForResume(int jobSeekerId);
    DataResult<Resume> getAllForInOrder(int jobSeekerId);


}
