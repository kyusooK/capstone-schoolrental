package schoolrental.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;

import lombok.Data;
import schoolrental.ReserveApplication;

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

    @PostUpdate
    public void onPostUpdate() {
        repository().findById(id).ifPresent(facility->{
            facility.setIsReserve(true);
            repository().save(facility);
        });
        FacilityReserved facilityReserved = new FacilityReserved(this);
        facilityReserved.publishAfterCommit();
    }

    public static FacilityRepository repository() {
        FacilityRepository facilityRepository = ReserveApplication.applicationContext.getBean(
            FacilityRepository.class
        );
        return facilityRepository;
    }

    //<<< Clean Arch / Port Method
    public static void registerFacility(SpaceMaintained spaceMaintained) {
        Facility facility = new Facility();
        facility.setId(spaceMaintained.getId());
        facility.setSpaceId(spaceMaintained.getId());
        facility.setSchoolName(spaceMaintained.getSchoolName());
        facility.setPlaceName(spaceMaintained.getPlaceName());
        facility.setHeadCount(spaceMaintained.getHeadcount());
        facility.setPrice(spaceMaintained.getPrice());
        facility.setAddress(spaceMaintained.getAddress());
        facility.setIsReserve(false);
        repository().save(facility);

        FacilityRegistered facilityRegistered = new FacilityRegistered(facility);
        facilityRegistered.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
