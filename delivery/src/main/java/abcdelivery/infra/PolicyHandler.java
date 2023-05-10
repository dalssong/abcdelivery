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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_CookingFinished(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener CookingFinished : " + cookFinished + "\n\n"
        );

        // Sample Logic //
        Delivery.cookingFinished(event);
    }
}
