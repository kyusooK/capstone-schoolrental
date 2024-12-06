package schoolrental.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import schoolrental.domain.*;

@Component
public class AnalysisHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Analysis>> {

    @Override
    public EntityModel<Analysis> process(EntityModel<Analysis> model) {
        return model;
    }
}
