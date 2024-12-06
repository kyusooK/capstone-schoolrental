package schoolrental.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import schoolrental.SpaceApplication;
import schoolrental.domain.ReserveStatusUpdated;
import schoolrental.domain.SpaceRegistered;

@Entity
@Table(name = "Space_table")
@Data
//<<< DDD / Aggregate Root
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String schoolName;

    private String placeName;

    private Integer headcount;

    private Long price;

    private String address;

    private Boolean isMaintenance;

    private Boolean isReserve;

    private String managerId;

    @PostPersist
    public void onPostPersist() {
        ReserveStatusUpdated reserveStatusUpdated = new ReserveStatusUpdated(
            this
        );
        reserveStatusUpdated.publishAfterCommit();

        SpaceRegistered spaceRegistered = new SpaceRegistered(this);
        spaceRegistered.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static SpaceRepository repository() {
        SpaceRepository spaceRepository = SpaceApplication.applicationContext.getBean(
            SpaceRepository.class
        );
        return spaceRepository;
    }

    //<<< Clean Arch / Port Method
    public void maintainSpace(MaintainSpaceCommand maintainSpaceCommand) {
        //implement business logic here:

        SpaceMaintained spaceMaintained = new SpaceMaintained(this);
        spaceMaintained.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void assignManager(AssignManagerCommand assignManagerCommand) {
        //implement business logic here:

        ManagerAssigned managerAssigned = new ManagerAssigned(this);
        managerAssigned.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void updateReserveStatus(FacilityReserved facilityReserved) {
        //implement business logic here:

        /** Example 1:  new item 
        Space space = new Space();
        repository().save(space);

        ReserveStatusUpdated reserveStatusUpdated = new ReserveStatusUpdated(space);
        reserveStatusUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(facilityReserved.get???()).ifPresent(space->{
            
            space // do something
            repository().save(space);

            ReserveStatusUpdated reserveStatusUpdated = new ReserveStatusUpdated(space);
            reserveStatusUpdated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
