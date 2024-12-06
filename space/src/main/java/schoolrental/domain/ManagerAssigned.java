package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import schoolrental.domain.*;
import schoolrental.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
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

    public ManagerAssigned(Space aggregate) {
        super(aggregate);
    }

    public ManagerAssigned() {
        super();
    }
}
//>>> DDD / Domain Event
