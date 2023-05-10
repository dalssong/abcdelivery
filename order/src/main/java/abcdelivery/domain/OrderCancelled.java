package abcdelivery.domain;

import abcdelivery.domain.*;
import abcdelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private Long userId;
    private String storeName;
    private String menuName;
    private String orderStatus;
    private Integer menuPrice;

    public OrderCancelled(Order aggregate) {
        super(aggregate);
    }

    public OrderCancelled() {
        super();
    }
}
