package abcdelivery.domain;

import abcdelivery.StoreApplication;
import abcdelivery.domain.CookAccepted;
import abcdelivery.domain.CookFinished;
import abcdelivery.domain.CookRefused;
import abcdelivery.domain.CookStarted;
import abcdelivery.domain.Refunded;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String storeName;

    private Long menuId;

    private String menuName;

    private Integer qty;

    private Integer menuPrice;

    private String deliveryStatus;

    // add
    private Long userId;

    @PostPersist
    public void onPostPersist() {
        // CookFinished cookFinished = new CookFinished(this);
        // cookFinished.publishAfterCommit();

        // CookRefused cookRefused = new CookRefused(this);
        // cookRefused.publishAfterCommit();

        // CookAccepted cookAccepted = new CookAccepted(this);
        // cookAccepted.publishAfterCommit();

        // CookStarted cookStarted = new CookStarted(this);
        // cookStarted.publishAfterCommit();

        // Refunded refunded = new Refunded(this);
        // refunded.publishAfterCommit();
    }

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public static void notifyToShop(FoodDelivered foodDelivered) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(foodDelivered.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }

    public static void notifyToShop(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }

    public static void notifyToShop(FoodPicked foodPicked) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(foodPicked.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }

    public static void orderPay(OrderPlaced orderPlaced) {
        /** Example 1:  new item */
        Cooking cooking = new Cooking();
        cooking.setMenuName(orderPlaced.getMenuName());
        cooking.setMenuPrice(orderPlaced.getMenuPrice());
        cooking.setStoreName(orderPlaced.getStoreName());
        cooking.setUserId(orderPlaced.getUserId());
        cooking.setDeliveryStatus("Accepted. Searching food.");

        repository().save(cooking);

        CookAccepted cookAccepted = new CookAccepted(cooking);
        cookAccepted.publishAfterCommit();
      
        cooking.setDeliveryStatus("Cooking started.");
        CookStarted cookStarted = new CookStarted(cooking);
        cookStarted.publishAfterCommit();

        cooking.setDeliveryStatus("Cooking finished.");
        CookFinished cookFinished = new CookFinished(cooking);
        cookFinished.publishAfterCommit();

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            CookAccepted cookAccepted = new CookAccepted(cooking);
            cookAccepted.publishAfterCommit();

         });
        */

    }

    public static void orderCancel(OrderCancelled orderCancelled) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        Refunded refunded = new Refunded(cooking);
        refunded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            Refunded refunded = new Refunded(cooking);
            refunded.publishAfterCommit();

         });
        */

    }
}
