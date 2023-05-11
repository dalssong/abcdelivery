package abcdelivery.domain;

import abcdelivery.DeliveryApplication;
import abcdelivery.domain.DeliveryStarted;
import abcdelivery.domain.FoodDelivered;
import abcdelivery.domain.FoodPicked;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long riderId;

    private String riderName;

    private Long storeId;

    private String storeName;

    private Long menuId;

    private Integer qty;

    private Long customerId;

    private String deliveryStatus;

    @PostPersist
    public void onPostPersist() {
        // FoodPicked foodPicked = new FoodPicked(this);
        // foodPicked.publishAfterCommit();

        // FoodDelivered foodDelivered = new FoodDelivered(this);
        // foodDelivered.publishAfterCommit();

        // DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        // deliveryStarted.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void cookingFinished(CookFinished cookFinished) {
        /** Example 1:  new item */
        Delivery delivery = new Delivery();
        delivery.setMenuId(cookFinished.getMenuId());
        delivery.setCustomerId(cookFinished.getCustomerId());
        delivery.setDeliveryStatus("Delivery wating.");

        repository().save(delivery);

        FoodPicked foodPicked = new FoodPicked(delivery);
        foodPicked.publishAfterCommit();
      

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            FoodPicked foodPicked = new FoodPicked(delivery);
            foodPicked.publishAfterCommit();

         });
        */

    }
}
