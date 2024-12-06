package schoolrental.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import schoolrental.domain.*;

@Component
public class 분석HateoasProcessor
    implements RepresentationModelProcessor<EntityModel<분석>> {

    @Override
    public EntityModel<분석> process(EntityModel<분석> model) {
        return model;
    }
}
