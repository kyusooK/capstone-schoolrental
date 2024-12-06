package schoolrental.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AssignManagerCommand {

    private String managerId;
    private Long id;
}
