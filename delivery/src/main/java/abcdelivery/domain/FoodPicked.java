package abcdelivery.domain;

import abcdelivery.domain.*;
import abcdelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FoodPicked extends AbstractEvent {

    private Long id;
    private Long riderId;
    private String riderName;
    private Long storeId;
    private String storeName;
    private Long menuId;
    private Integer qty;
    private Long customerId;
    private String deliveryStatus;

    public FoodPicked(Delivery aggregate) {
        super(aggregate);
    }

    public FoodPicked() {
        super();
    }
}
