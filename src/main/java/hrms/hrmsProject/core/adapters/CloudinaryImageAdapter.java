package hrms.hrmsProject.core.adapters;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import hrms.hrmsProject.core.utilities.results.DataResult;
import hrms.hrmsProject.core.utilities.results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryImageAdapter implements ImageService{

    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryImageAdapter(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }


    @Override
    public DataResult<Map> save(MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(uploadResult);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return new ErrorDataResult<Map>();
    }
}
