package schoolrental.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import schoolrental.domain.*;

@Component
public class SpaceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Space>> {

    @Override
    public EntityModel<Space> process(EntityModel<Space> model) {
        return model;
    }
}