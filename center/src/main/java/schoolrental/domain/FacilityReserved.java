package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import schoolrental.infra.AbstractEvent;

@Data
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
