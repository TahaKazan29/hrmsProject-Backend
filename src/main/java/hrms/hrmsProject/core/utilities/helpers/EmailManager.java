package hrms.hrmsProject.core.utilities.helpers;

import hrms.hrmsProject.business.constants.Messages;
import hrms.hrmsProject.core.utilities.results.Result;
import hrms.hrmsProject.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements  EmailService{

    @Override
    public Result send(String receiver, String title, String message) {
        return new SuccessResult(Messages.verificationSent());
    }

}
