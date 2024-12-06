package schoolrental.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import schoolrental.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "facilityUtilizationRates",
    path = "facilityUtilizationRates"
)
public interface FacilityUtilizationRateRepository
    extends PagingAndSortingRepository<FacilityUtilizationRate, Long> {}
