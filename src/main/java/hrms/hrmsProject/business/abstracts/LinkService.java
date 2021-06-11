package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Link;
import hrms.hrmsProject.entities.dtos.LinkDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LinkService {

    Result add(LinkDto links);
    DataResult<List<Link>> getAll(int jobSeekerId);

}
