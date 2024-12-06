package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import schoolrental.infra.AbstractEvent;

@Data
public class ManagerAssigned extends AbstractEvent {

    private Long id;
    private String schoolName;
    private String placeName;
    private Integer headcount;
    private Long price;
    private String address;
    private Boolean isMaintenance;
    private Boolean isReserve;
    private String managerId;
}
