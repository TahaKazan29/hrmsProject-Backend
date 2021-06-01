package hrms.hrmsProject.entities.dtos;

import hrms.hrmsProject.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerResumeDto {

    private int id;
    private int jobSeekerId;

    public JobSeekerResumeDto(int id,int jobSeekerId,String description, String githubAddress,String linkedinAddress,List<School> schools) {
        this.id = id;
        this.description = description;
        this.githubAddress = githubAddress;
        this.linkedinAddress = linkedinAddress;
        this.schools = schools;
    }

    private String description;
    private String githubAddress;
    private String linkedinAddress;
    private List<School> schools;
    private List<Ability> abilities;
    private List<WorkExperience> workExperiences;
    private List<ForeignLanguage> foreignLanguages;


//    private List<Resume> resumes;
}
