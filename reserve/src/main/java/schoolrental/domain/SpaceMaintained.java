package schoolrental.domain;

import java.util.*;
import lombok.*;
import schoolrental.domain.*;
import schoolrental.infra.AbstractEvent;

@Data
@ToString
public class SpaceMaintained extends AbstractEvent {

    private Long id;
    private String schoolName;
    private String placeName;
    private Integer headcount;
    private Long price;
    private String address;
    private Boolean isMaintenance;
}
