package schoolrental.domain;

import java.util.*;
import lombok.*;
import schoolrental.domain.*;
import schoolrental.infra.AbstractEvent;

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
}
