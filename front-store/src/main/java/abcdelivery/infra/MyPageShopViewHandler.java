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
public class MyPageShopViewHandler {

    @Autowired
    private MyPageShopRepository myPageShopRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookAccepted_then_CREATE_1(
        @Payload CookAccepted cookAccepted
    ) {
        try {
            if (!cookAccepted.validate()) return;

            // view 객체 생성
            MyPageShop myPageShop = new MyPageShop();
            // view 객체에 이벤트의 Value 를 set 함
            myPageShop.setStoreName(cookAccepted.getStoreName());
            myPageShop.setMenuName(cookAccepted.getMenuName());
            myPageShop.setMenuId(cookAccepted.getMenuId());
            // view 레파지 토리에 save
            myPageShopRepository.save(myPageShop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
