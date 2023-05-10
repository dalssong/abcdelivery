package abcdelivery.domain;

import abcdelivery.domain.*;
import abcdelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookAccepted extends AbstractEvent {

    private Long id;
    private String storeName;
    private Long menuId;
    private String menuName;
    private Integer qty;
    private Integer menuPrice;
    private String deliveryStatus;

    public CookAccepted(Cooking aggregate) {
        super(aggregate);
    }

    public CookAccepted() {
        super();
    }
}
