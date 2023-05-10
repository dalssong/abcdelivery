package abcdelivery.infra;

import abcdelivery.config.kafka.KafkaProcessor;
import abcdelivery.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    CookingRepository cookingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodDelivered'"
    )
    public void wheneverFoodDelivered_NotifyToShop(
        @Payload FoodDelivered foodDelivered
    ) {
        FoodDelivered event = foodDelivered;
        System.out.println(
            "\n\n##### listener NotifyToShop : " + foodDelivered + "\n\n"
        );

        // Sample Logic //
        Cooking.notifyToShop(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_NotifyToShop(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener NotifyToShop : " + deliveryStarted + "\n\n"
        );

        // Sample Logic //
        Cooking.notifyToShop(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodPicked'"
    )
    public void wheneverFoodPicked_NotifyToShop(
        @Payload FoodPicked foodPicked
    ) {
        FoodPicked event = foodPicked;
        System.out.println(
            "\n\n##### listener NotifyToShop : " + foodPicked + "\n\n"
        );

        // Sample Logic //
        Cooking.notifyToShop(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_OrderPay(@Payload OrderPlaced orderPlaced) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener OrderPay : " + orderPlaced + "\n\n"
        );

        // Sample Logic //
        Cooking.orderPay(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancelled'"
    )
    public void wheneverOrderCancelled_OrderCancel(
        @Payload OrderCancelled orderCancelled
    ) {
        OrderCancelled event = orderCancelled;
        System.out.println(
            "\n\n##### listener OrderCancel : " + orderCancelled + "\n\n"
        );

        // Sample Logic //
        Cooking.orderCancel(event);
    }
}
