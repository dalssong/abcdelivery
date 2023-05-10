package abcdelivery.domain;

import abcdelivery.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long userId;
    private String storeName;
    private String menuName;
    private String orderStatus;
    private Integer menuPrice;
}
