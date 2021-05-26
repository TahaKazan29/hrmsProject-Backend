package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.entities.concretes.JobPosition;

import java.util.List;

public interface BaseService<T> {
    DataResult<List<T>> getAll();
    DataResult<T> getById(int id);
    Result add(T entity);
    Result update(T entity);
    Result delete(T entity);
}
