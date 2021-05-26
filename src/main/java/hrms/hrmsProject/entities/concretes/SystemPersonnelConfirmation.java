package hrms.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="system_personnel_confirmations")
public class SystemPersonnelConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "system_personnel_id")
    private int systemPersonnelId;
    @Column(name = "employer_id")
    private int employerId;
    @Column(name = "confirmed_date")
    private String confirmedDate;
}
