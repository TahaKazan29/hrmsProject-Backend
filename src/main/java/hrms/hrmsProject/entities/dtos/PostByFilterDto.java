package hrms.hrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostByFilterDto {

    private ArrayList<Integer> cityIds;
    private ArrayList<Integer> positionIds;
    private ArrayList<Integer> wayOfWorkingIds;
    private ArrayList<Integer> workingTimeIds;

}
