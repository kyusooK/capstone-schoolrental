package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import schoolrental.domain.*;
import schoolrental.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DataReceived extends AbstractEvent {

    private String placeName;
    private Integer useCount;

    public DataReceived(Analysis aggregate) {
        super(aggregate);
    }

    public DataReceived() {
        super();
    }
}
//>>> DDD / Domain Event
