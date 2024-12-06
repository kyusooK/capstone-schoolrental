package schoolrental.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "FacilityUtilizationRate_table")
@Data
public class FacilityUtilizationRate {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String placeName;

    private Integer useCount;
}
