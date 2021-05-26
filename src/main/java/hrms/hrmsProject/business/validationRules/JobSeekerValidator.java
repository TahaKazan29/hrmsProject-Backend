package hrms.hrmsProject.business.validationRules;

import hrms.hrmsProject.business.constants.Messages;

public class JobSeekerValidator {

    public static boolean checkName(String name) {
        if(name.length() == 0) {
            Messages.checkName();
            return false;
        }
        return true;
    }

    public static boolean checkLastName(String lastName) {
        if(lastName.length() == 0) {
            return false;
        }
        return true;
    }

    public static boolean checkIdentityNumber(String identityNumber) {
        if(identityNumber.length() == 0) {
            return false;
        }
        return true;
    }

    public static boolean checkBirthYear(int birthYear) {
        String year = String.valueOf(birthYear);
        if(year.length() == 0) {
            return false;
        }
        return true;
    }

    public static boolean checkEmail(String email) {
        if(email.length() == 0) {
            return false;
        }
        return true;
    }

    public static boolean checkPassword(String password) {
        if(password.length() == 0) {
            return false;
        }
        return true;
    }

    public static boolean checkConfirmPassword(String password) {
        if(password.length() == 0) {
            return false;
        }
        return true;
    }

}
