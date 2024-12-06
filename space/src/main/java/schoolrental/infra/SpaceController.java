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
// @RequestMapping(value="/spaces")
@Transactional
public class SpaceController {

    @Autowired
    SpaceRepository spaceRepository;

    @RequestMapping(
        value = "/spaces/{id}/maintainspace",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Space maintainSpace(
        @PathVariable(value = "id") Long id,
        @RequestBody MaintainSpaceCommand maintainSpaceCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /space/maintainSpace  called #####");
        Optional<Space> optionalSpace = spaceRepository.findById(id);

        optionalSpace.orElseThrow(() -> new Exception("No Entity Found"));
        Space space = optionalSpace.get();
        space.maintainSpace(maintainSpaceCommand);

        spaceRepository.save(space);
        return space;
    }

    @RequestMapping(
        value = "/spaces/{id}/assignmanager",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Space assignManager(
        @PathVariable(value = "id") Long id,
        @RequestBody AssignManagerCommand assignManagerCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /space/assignManager  called #####");
        Optional<Space> optionalSpace = spaceRepository.findById(id);

        optionalSpace.orElseThrow(() -> new Exception("No Entity Found"));
        Space space = optionalSpace.get();
        space.assignManager(assignManagerCommand);

        spaceRepository.save(space);
        return space;
    }
}
//>>> Clean Arch / Inbound Adaptor
