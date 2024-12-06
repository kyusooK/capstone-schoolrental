package schoolrental.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import schoolrental.AnalysisApplication;
import schoolrental.domain.DataReceived;

@Entity
@Table(name = "Analysis_table")
@Data
//<<< DDD / Aggregate Root
public class Analysis {

    @Id
    private String placeName;

    private Integer useCount;

    @PostPersist
    public void onPostPersist() {
        DataReceived dataReceived = new DataReceived(this);
        dataReceived.publishAfterCommit();
    }

    public static AnalysisRepository repository() {
        AnalysisRepository analysisRepository = AnalysisApplication.applicationContext.getBean(
            AnalysisRepository.class
        );
        return analysisRepository;
    }

    //<<< Clean Arch / Port Method
    public static void receiveReservationData(
        FacilityReserved facilityReserved
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Analysis analysis = new Analysis();
        repository().save(analysis);

        DataReceived dataReceived = new DataReceived(analysis);
        dataReceived.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(facilityReserved.get???()).ifPresent(analysis->{
            
            analysis // do something
            repository().save(analysis);

            DataReceived dataReceived = new DataReceived(analysis);
            dataReceived.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
