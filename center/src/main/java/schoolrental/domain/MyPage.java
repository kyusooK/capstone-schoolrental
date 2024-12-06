package schoolrental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "MyPage_table")
@Data
public class MyPage {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String schoolName;
    private String placeName;
    private Long price;
    private String managerId;
    private Boolean isReserve;
}
