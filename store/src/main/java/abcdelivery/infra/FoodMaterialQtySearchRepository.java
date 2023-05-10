package abcdelivery.infra;

import abcdelivery.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "foodMaterialQtySearches",
    path = "foodMaterialQtySearches"
)
public interface FoodMaterialQtySearchRepository
    extends PagingAndSortingRepository<FoodMaterialQtySearch, Long> {}
