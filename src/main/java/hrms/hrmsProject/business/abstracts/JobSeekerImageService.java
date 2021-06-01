package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.JobSeekerImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobSeekerImageService {

    Result add(JobSeekerImage jobSeekerImage);
    Result addPhoto(JobSeekerImage jobSeekerImage, MultipartFile multipartFile);
    DataResult<List<JobSeekerImage>> getAll();
    DataResult<List<JobSeekerImage>> getAllByJobSeekerId(int jobSeekerId);

}
