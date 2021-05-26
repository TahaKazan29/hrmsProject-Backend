package hrms.hrmsProject.core.utilities.helpers;

import hrms.hrmsProject.core.utilities.results.Result;

public interface EmailService {

    Result send(String receiver,String title, String message);

}
