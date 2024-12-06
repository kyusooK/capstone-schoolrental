package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import schoolrental.domain.*;
import schoolrental.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SpaceRegistered extends AbstractEvent {

    private Long id;
    private String schoolName;
    private String placeName;
    private Integer headcount;
    private Long price;
    private String address;
    private Boolean isMaintenance;

    public SpaceRegistered(Space aggregate) {
        super(aggregate);
    }

    public SpaceRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
