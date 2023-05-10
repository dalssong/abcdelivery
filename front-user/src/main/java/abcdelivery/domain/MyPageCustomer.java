package abcdelivery.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MyPageCustomer_table")
@Data
public class MyPageCustomer {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long userId;
    private String storeName;
    private String menuName;
    private String orderStatus;
    private String menuPrice;
}
