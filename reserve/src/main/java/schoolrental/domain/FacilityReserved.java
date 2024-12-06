package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import schoolrental.domain.*;
import schoolrental.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FacilityReserved extends AbstractEvent {

    private Long id;
    private Long spaceId;
    private String schoolName;
    private String placeName;
    private Integer headCount;
    private Long price;
    private String userId;
    private String address;
    private Date reserveDate;
    private Boolean isReserve;

    public FacilityReserved(Facility aggregate) {
        super(aggregate);
    }

    public FacilityReserved() {
        super();
    }
}
//>>> DDD / Domain Event
