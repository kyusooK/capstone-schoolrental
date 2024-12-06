package schoolrental.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import schoolrental.ReserveApplication;
import schoolrental.domain.FacilityRegistered;

@Entity
@Table(name = "Facility_table")
@Data
//<<< DDD / Aggregate Root
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @PostPersist
    public void onPostPersist() {
        FacilityRegistered facilityRegistered = new FacilityRegistered(this);
        facilityRegistered.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static FacilityRepository repository() {
        FacilityRepository facilityRepository = ReserveApplication.applicationContext.getBean(
            FacilityRepository.class
        );
        return facilityRepository;
    }

    //<<< Clean Arch / Port Method
    public void reservation(ReservationCommand reservationCommand) {
        //implement business logic here:

        FacilityReserved facilityReserved = new FacilityReserved(this);
        facilityReserved.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void registerFacility(SpaceMaintained spaceMaintained) {
        //implement business logic here:

        /** Example 1:  new item 
        Facility facility = new Facility();
        repository().save(facility);

        FacilityRegistered facilityRegistered = new FacilityRegistered(facility);
        facilityRegistered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(spaceMaintained.get???()).ifPresent(facility->{
            
            facility // do something
            repository().save(facility);

            FacilityRegistered facilityRegistered = new FacilityRegistered(facility);
            facilityRegistered.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
