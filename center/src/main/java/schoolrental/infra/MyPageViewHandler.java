package schoolrental.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import schoolrental.config.kafka.KafkaProcessor;
import schoolrental.domain.*;

@Service
public class MyPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFacilityReserved_then_CREATE_1(
        @Payload FacilityReserved facilityReserved
    ) {
        try {
            if (!facilityReserved.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setSchoolName(facilityReserved.getSchoolName());
            myPage.setPlaceName(facilityReserved.getPlaceName());
            myPage.setPrice(facilityReserved.getPrice());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFacilityReserved_then_UPDATE_1(
        @Payload FacilityReserved facilityReserved
    ) {
        try {
            if (!facilityReserved.validate()) return;
            // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(
                facilityReserved.getSpaceId()
            );

            if (myPageOptional.isPresent()) {
                MyPage myPage = myPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setIsReserve(facilityReserved.getIsReserve());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenManagerAssigned_then_UPDATE_2(
        @Payload ManagerAssigned managerAssigned
    ) {
        try {
            if (!managerAssigned.validate()) return;
            // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(
                managerAssigned.getId()
            );

            if (myPageOptional.isPresent()) {
                MyPage myPage = myPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setManagerId(managerAssigned.getManagerId());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
