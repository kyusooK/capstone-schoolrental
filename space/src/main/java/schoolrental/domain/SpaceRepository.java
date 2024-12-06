package schoolrental.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import schoolrental.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "spaces", path = "spaces")
public interface SpaceRepository
    extends PagingAndSortingRepository<Space, Long> {}
