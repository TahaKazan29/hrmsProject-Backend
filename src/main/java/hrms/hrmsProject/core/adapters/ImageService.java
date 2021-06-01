package hrms.hrmsProject.core.adapters;

import hrms.hrmsProject.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    DataResult<?> save (MultipartFile file);

}
