package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.JobSeekerImageService;
import hrms.hrmsProject.core.adapters.ImageService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.JobSeekerImageDao;
import hrms.hrmsProject.entities.concretes.JobSeekerImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class JobSeekerImageManager implements JobSeekerImageService {

    private JobSeekerImageDao jobSeekerImageDao;
    private ImageService imageService;

    @Autowired
    public JobSeekerImageManager(JobSeekerImageDao jobSeekerImageDao,ImageService imageService) {
        this.jobSeekerImageDao = jobSeekerImageDao;
        this.imageService = imageService;
    }


    @Override
    public Result add(JobSeekerImage jobSeekerImage) {
        this.jobSeekerImageDao.save(jobSeekerImage);
        return new SuccessResult();
    }

    @Override
    public Result addPhoto(JobSeekerImage jobSeekerImage, MultipartFile multipartFile) {
        Map<String,String> result = (Map<String,String>)imageService.save(multipartFile).getData();
        String url = result.get("url");
        jobSeekerImage.setUrl(url);
        jobSeekerImage.setUploadedAt(LocalDate.now());
        return add(jobSeekerImage);
    }

    @Override
    public DataResult<List<JobSeekerImage>> getAll() {
        return new SuccessDataResult<>(this.jobSeekerImageDao.findAll());
    }

    @Override
    public DataResult<List<JobSeekerImage>> getAllByJobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<>(this.jobSeekerImageDao.getAllByJobSeekerId(jobSeekerId));
    }
}
