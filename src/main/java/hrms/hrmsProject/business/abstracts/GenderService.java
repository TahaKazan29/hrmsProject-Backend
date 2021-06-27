package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.Gender;
import hrms.hrmsProject.entities.dtos.GenderDto;

import java.util.List;

public interface GenderService{

    Result add(GenderDto genderDto);
    Result delete(GenderDto genderDto);
    Result update(GenderDto genderDto);
    DataResult<List<Gender>> getAll();
    DataResult<Gender> getById(int id);
    DataResult<Gender> getByJobSeeker(int id);

}
