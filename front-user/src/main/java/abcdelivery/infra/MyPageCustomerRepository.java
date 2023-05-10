package abcdelivery.infra;

import abcdelivery.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "myPageCustomers",
    path = "myPageCustomers"
)
public interface MyPageCustomerRepository
    extends PagingAndSortingRepository<MyPageCustomer, Long> {
    void deleteByUserId(Long userId);
}
