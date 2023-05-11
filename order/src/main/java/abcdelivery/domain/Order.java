package abcdelivery.domain;

import abcdelivery.OrderApplication;
import abcdelivery.domain.OrderCancelled;
import abcdelivery.domain.OrderPlaced;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String storeName;

    private String menuName;

    private String orderStatus;

    private Integer menuPrice;

    @PostPersist
    public void onPostPersist() {
        // OrderPlaced orderPlaced = new OrderPlaced(this);
        // orderPlaced.publishAfterCommit();

        // OrderCancelled orderCancelled = new OrderCancelled(this);
        // orderCancelled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void notifyToWatingUser(Refunded refunded) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(refunded.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void notifyToWatingUser(FoodDelivered foodDelivered) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process */
        
        repository().findById(foodDelivered.getOrderId()).ifPresent(order->{
            
            order.setOrderStatus("Delivery finished. Enjoy meal!"); // do something
            repository().save(order);


         });
        */

    }

    public static void notifyToWatingUser(CookRefused cookRefused) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookRefused.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void notifyToWatingUser(CookFinished cookFinished) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void updateStatus(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process */
        
        repository().findById(deliveryStarted.getOrderId()).ifPresent(order->{
            
            order.setOrderStatus("Delivery started. Please wait minitues!"); // do something
            repository().save(order);

            OrderPlaced orderPlaced = new OrderPlaced();
            orderPlaced.setId(order.getId());
            orderPlaced.setOrderStatus("Order accepted.");
            orderPlaced.publishAfterCommit();

         });

    }

    public static void updateStatus(CookStarted cookStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process */
        
        repository().findById(cookStarted.getOrderId()).ifPresent(order->{
            
            order.setOrderStatus("Cooking started."); // do something
            repository().save(order);


         });

    }

    public static void updateStatus(CookFinished cookFinished) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process */
        
        repository().findById(cookFinished.getOrderId()).ifPresent(order->{
            
            order.setOrderStatus("Cooking finished."); // do something
            repository().save(order);

         });

    }
}
