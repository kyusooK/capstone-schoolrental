package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class MaintainSpaceCommand {

    private Boolean isMaintenance;
    private Long id;
}
