package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import schoolrental.domain.*;
import schoolrental.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FacilityRegistered extends AbstractEvent {

    private Long id;
    private Long spaceId;
    private String schoolName;
    private String placeName;
    private Integer headCount;
    private Long price;
    private String userId;
    private String address;
    private Boolean isReserve;

    public FacilityRegistered(Facility aggregate) {
        super(aggregate);
    }

    public FacilityRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
