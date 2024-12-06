package schoolrental.domain;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import lombok.Data;
import schoolrental.AnalysisApplication;

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
        
        Optional<Analysis> optionalAnalysis = repository().findById(facilityReserved.getSchoolName());

        if (optionalAnalysis.isPresent()) {
            Analysis analysis = optionalAnalysis.get();
            analysis.setPlaceName(facilityReserved.getPlaceName());
            analysis.setUseCount(analysis.getUseCount() + 1);
            repository().save(analysis);

            

            
        } else {
            Analysis newAnalysis = new Analysis();
            newAnalysis.setPlaceName(facilityReserved.getPlaceName());
            newAnalysis.setUseCount(1); 
            repository().save(newAnalysis);

            DataReceived dataReceived = new DataReceived(newAnalysis);
            dataReceived.publishAfterCommit();
        }

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
