package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReservationCommand {

    private String userId;
    private Date reserveDate;
    private Long id;
}
