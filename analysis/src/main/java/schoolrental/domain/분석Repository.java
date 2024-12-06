package schoolrental.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import schoolrental.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "분석", path = "분석")
public interface 분석Repository
    extends PagingAndSortingRepository<분석, String> {}
