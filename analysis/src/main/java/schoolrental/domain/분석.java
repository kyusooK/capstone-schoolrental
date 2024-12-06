package schoolrental.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import schoolrental.AnalysisApplication;
import schoolrental.domain.DataReceived;

@Entity
@Table(name = "분석_table")
@Data
//<<< DDD / Aggregate Root
public class 분석 {

    @Id
    private String placeName;

    private Integer useCount;

    @PostPersist
    public void onPostPersist() {
        DataReceived dataReceived = new DataReceived(this);
        dataReceived.publishAfterCommit();
    }

    public static 분석Repository repository() {
        분석Repository 분석Repository = AnalysisApplication.applicationContext.getBean(
            분석Repository.class
        );
        return 분석Repository;
    }

    //<<< Clean Arch / Port Method
    public static void receiveReservationData(
        FacilityReserved facilityReserved
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        분석 분석 = new 분석();
        repository().save(분석);

        DataReceived dataReceived = new DataReceived(분석);
        dataReceived.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(facilityReserved.get???()).ifPresent(분석->{
            
            분석 // do something
            repository().save(분석);

            DataReceived dataReceived = new DataReceived(분석);
            dataReceived.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
