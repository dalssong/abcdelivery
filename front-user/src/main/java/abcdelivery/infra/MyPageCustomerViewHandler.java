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
public class MyPageCustomerViewHandler {

    @Autowired
    private MyPageCustomerRepository myPageCustomerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            MyPageCustomer myPageCustomer = new MyPageCustomer();
            // view 객체에 이벤트의 Value 를 set 함
            myPageCustomer.setUserId(orderPlaced.getUserId());
            myPageCustomer.setStoreName(orderPlaced.getStoreName());
            myPageCustomer.setMenuName(orderPlaced.getMenuName());
            myPageCustomer.setOrderStatus(orderPlaced.getOrderStatus());
            myPageCustomer.setMenuPrice(
                String.valueOf(orderPlaced.getMenuPrice())
            );
            // view 레파지 토리에 save
            myPageCustomerRepository.save(myPageCustomer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_UPDATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;
            // view 객체 조회
            Optional<MyPageCustomer> myPageCustomerOptional = myPageCustomerRepository.findById(
                orderPlaced.getId()
            );

            if (myPageCustomerOptional.isPresent()) {
                MyPageCustomer myPageCustomer = myPageCustomerOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPageCustomer.setOrderStatus(orderPlaced.getOrderStatus());
                // view 레파지 토리에 save
                myPageCustomerRepository.save(myPageCustomer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFoodDelivered_then_DELETE_1(
        @Payload FoodDelivered foodDelivered
    ) {
        try {
            if (!foodDelivered.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            myPageCustomerRepository.deleteByUserId(
                foodDelivered.getCustomerId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
