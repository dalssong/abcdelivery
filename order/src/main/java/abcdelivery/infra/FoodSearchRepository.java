package abcdelivery.infra;

import abcdelivery.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "foodSearches",
    path = "foodSearches"
)
public interface FoodSearchRepository
    extends PagingAndSortingRepository<FoodSearch, Long> {}
