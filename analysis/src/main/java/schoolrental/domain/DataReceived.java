package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import schoolrental.infra.AbstractEvent;

@Data
public class DataReceived extends AbstractEvent {

    private String placeName;
    private Integer useCount;
}
