package schoolrental.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import schoolrental.domain.*;

@Component
public class FacilityHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Facility>> {

    @Override
    public EntityModel<Facility> process(EntityModel<Facility> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/reservation")
                .withRel("reservation")
        );

        return model;
    }
}
