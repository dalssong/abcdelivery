package abcdelivery.domain;

import abcdelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cookings", path = "cookings")
public interface CookingRepository
    extends PagingAndSortingRepository<Cooking, Long> {}
