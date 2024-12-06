package schoolrental.domain;

import java.util.Date;
import lombok.Data;

@Data
public class 시설물검색Query {

    private String schoolName;
    private String placeName;
}
