package schoolrental.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schoolrental.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/facilities")
@Transactional
public class FacilityController {

    @Autowired
    FacilityRepository facilityRepository;

    @RequestMapping(
        value = "/facilities/{id}/reservation",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Facility reservation(
        @PathVariable(value = "id") Long id,
        @RequestBody ReservationCommand reservationCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /facility/reservation  called #####");
        Optional<Facility> optionalFacility = facilityRepository.findById(id);

        optionalFacility.orElseThrow(() -> new Exception("No Entity Found"));
        Facility facility = optionalFacility.get();
        facility.reservation(reservationCommand);

        facilityRepository.save(facility);
        return facility;
    }
}
//>>> Clean Arch / Inbound Adaptor
