package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import schoolrental.domain.*;
import schoolrental.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReserveStatusUpdated extends AbstractEvent {

    private Long id;
    private Boolean isReserve;
    private String schoolName;
    private String placeName;
    private String address;

    public ReserveStatusUpdated(Space aggregate) {
        super(aggregate);
    }

    public ReserveStatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
