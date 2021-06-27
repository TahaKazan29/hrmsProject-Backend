package hrms.hrmsProject.business.constants;

public class Messages {

    public static String checkName() {
        return "İsim boş bırakılamaz ";
    }
    public static String notAValidPerson() {
        return "Geçersiz Kullanıcı";
    }
    public static String verificationSent() {
        return "Doğrulama Kodu Gönderildi";
    }
    public static String jobSeekerRegistered() {
        return "İş arayan olarak kayıt oldunuz";
    }
    public static String employerRegistered() {
        return "İş veren olarak kayıt oldunuz";
    }
    public static String verificationFailed() {
        return "Doğrulama başarısız , kayıt olunamadı";
    }
    public static String jobSeekersListed(){return "İş Arayanlar listelendi";}
    public static String employersListed(){return "İş Verenler listelendi";}
    public static String identityNumberIsAlreadyInUse(){return "Kimlik Numarasına ait bir kullanıcı zaten mevcut";}
    public static String emailIsAlreadyInUse(){return "E-Maile'e ait bir kullanıcı zaten mevcut";}
    public static String checkDomain(){return "E-Mail adresiniz , web siteniz ile aynı domaine sahip olmalı";}
    public static String jobPositionAdded(String positionName){return positionName + " pozisyonu eklendi";}
    public static String positionNameIsAlreadyAvailable(){return "Bu pozisyon zaten mevcut";}
    public static String positionListed(){return "İş pozisyonları listelendi";}
    public static String passwordsAreIncompatible(){return "Şifreler uyumsuz";}
    public static String approvedEmployer(String companyName){return companyName + " şirketini onayladınız kayıdı gerçekleşti";}
    public static String approvedEmployerError(String companyName){return companyName + " şirketi onaylanırken bir hata oluştu";}
    public static String rejectEmployer(String companyName){return companyName + " şirketini reddetdiniz , kayıdı gerçekleşmedi";}
    public static String rejectEmployerError(String companyName){return companyName + " şirketi reddedilirken bir hata oluştu";}
    public static String passiveEmployer(String companyName){return companyName + " şirketini pasif hale getirdiniz , tüm aktif ilanları pasif hale geldi";}
    public static String passiveEmployerError(String companyName){return companyName + " şirketi pasif hale getirilirken bir hata oluştu";}
    public static String pendingApproval() {return "İşleminiz tamamlandı , Sistem onayladıktan sonra kaydınız gerçekleşecek";}
    public static String pendingApprovalListed() {return "Onay bekleyen iş verenler listelendi";}
    public static String usersListed(){return "Tüm kullanıcılar listelendi";}
    public static String postAdded(){return "İlanınız eklendi";}
    public static String postUpdated(){return "İlanınız güncellendi";}
    public static String activatedPost(){return "ilan kabul edildi";}
    public static String activePostError(){return "ilan kabul edilirken hata oluştu";}
    public static String passivePostError(){return "ilan pasif hale gelirken bir hata oluştu";}
    public static String passivePost(){return "ilan pasifleştirildi";}
    public static String rejectPostError(){return "ilan reddedilirken bir hata oluştu";}
    public static String rejectPost(){return "ilan reddedildi";}
    public static String validationError(){return "Doğrulama hataları";}
    public static String resumeCreated(){return "Cv oluşturuldu";}
    public static String favoritePostError(){return "İlan favorilerinizde mevcut";}
    public static String employerProfileUpdateError(){return "Daha önce güncelleme yaptınız , onaylanmadan tekrar güncelleme yapılamaz";}
}
