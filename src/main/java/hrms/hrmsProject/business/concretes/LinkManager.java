package hrms.hrmsProject.business.concretes;

import hrms.hrmsProject.business.abstracts.LinkService;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.LinkDao;
import hrms.hrmsProject.entities.concretes.Link;
import hrms.hrmsProject.entities.concretes.Resume;
import hrms.hrmsProject.entities.dtos.LinkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkManager implements LinkService {

    private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    @Override
    public Result add(LinkDto link) {
        var linkModel = new Link();
        link.setId((link.getId()));
        link.setLinkedinLink(link.getLinkedinLink());
        link.setGithubLink(link.getGithubLink());
        var resume = new Resume();
        resume.setId(link.getResumeId());
        linkModel.setResume(resume);
        this.linkDao.save(linkModel);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Link>> getAll(int jobSeekerId) {
        return new SuccessDataResult<List<Link>>(this.linkDao.getAll(jobSeekerId));

    }
}
