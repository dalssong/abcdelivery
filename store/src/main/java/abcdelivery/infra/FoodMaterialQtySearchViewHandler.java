package abcdelivery.infra;

import abcdelivery.config.kafka.KafkaProcessor;
import abcdelivery.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class FoodMaterialQtySearchViewHandler {

    @Autowired
    private FoodMaterialQtySearchRepository foodMaterialQtySearchRepository;
}
