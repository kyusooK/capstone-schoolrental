package schoolrental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;
import schoolrental.SpaceApplication;

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

        SpaceRegistered spaceRegistered = new SpaceRegistered(this);
        spaceRegistered.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        SpaceMaintained spaceMaintained = new SpaceMaintained(this);
        spaceMaintained.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate(){
        ManagerAssigned managerAssigned = new ManagerAssigned(this);
        managerAssigned.publishAfterCommit();
    }

    public static SpaceRepository repository() {
        SpaceRepository spaceRepository = SpaceApplication.applicationContext.getBean(
            SpaceRepository.class
        );
        return spaceRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateReserveStatus(FacilityReserved facilityReserved) {
        
        repository().findById(facilityReserved.getSpaceId()).ifPresent(space->{
            
            space.setIsReserve(facilityReserved.getIsReserve());
            repository().save(space);

            ReserveStatusUpdated reserveStatusUpdated = new ReserveStatusUpdated(space);
            reserveStatusUpdated.publishAfterCommit();

         });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
