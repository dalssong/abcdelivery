package abcdelivery.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MyPageShop_table")
@Data
public class MyPageShop {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String storeName;
    private Long menuId;
    private String menuName;
    private Integer menuPrice;
    private String deliveryStatus;
}
