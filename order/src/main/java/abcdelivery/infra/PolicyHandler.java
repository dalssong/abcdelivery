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
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Refunded'"
    )
    public void wheneverRefunded_NotifyToWatingUser(
        @Payload Refunded refunded
    ) {
        Refunded event = refunded;
        System.out.println(
            "\n\n##### listener NotifyToWatingUser : " + refunded + "\n\n"
        );

        // Sample Logic //
        Order.notifyToWatingUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodDelivered'"
    )
    public void wheneverFoodDelivered_NotifyToWatingUser(
        @Payload FoodDelivered foodDelivered
    ) {
        FoodDelivered event = foodDelivered;
        System.out.println(
            "\n\n##### listener NotifyToWatingUser : " + foodDelivered + "\n\n"
        );

        // Sample Logic //
        Order.notifyToWatingUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookRefused'"
    )
    public void wheneverCookRefused_NotifyToWatingUser(
        @Payload CookRefused cookRefused
    ) {
        CookRefused event = cookRefused;
        System.out.println(
            "\n\n##### listener NotifyToWatingUser : " + cookRefused + "\n\n"
        );

        // Sample Logic //
        Order.notifyToWatingUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_NotifyToWatingUser(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener NotifyToWatingUser : " + cookFinished + "\n\n"
        );

        // Sample Logic //
        Order.notifyToWatingUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_UpdateStatus(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliveryStarted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_UpdateStatus(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_UpdateStatus(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + cookFinished + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
