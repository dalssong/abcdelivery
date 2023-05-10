package abcdelivery.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MyPageRider_table")
@Data
public class MyPageRider {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String riderName;
    private String storeName;
    private String menuName;
    private String qty;
    private String deliveryStatus;
}
