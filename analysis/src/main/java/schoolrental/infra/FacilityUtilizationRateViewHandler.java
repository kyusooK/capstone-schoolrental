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
public class FacilityUtilizationRateViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private FacilityUtilizationRateRepository facilityUtilizationRateRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDataReceived_then_CREATE_1(
        @Payload DataReceived dataReceived
    ) {
        try {
            if (!dataReceived.validate()) return;

            // view 객체 생성
            FacilityUtilizationRate facilityUtilizationRate = new FacilityUtilizationRate();
            // view 객체에 이벤트의 Value 를 set 함
            facilityUtilizationRate.setPlaceName(dataReceived.getPlaceName());
            facilityUtilizationRate.setUseCount(dataReceived.getUseCount());
            // view 레파지 토리에 save
            facilityUtilizationRateRepository.save(facilityUtilizationRate);
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
            Optional<FacilityUtilizationRate> facilityUtilizationRateOptional = facilityUtilizationRateRepository.findByPlaceName(
                facilityReserved.getPlaceName()
            );

            if (facilityUtilizationRateOptional.isPresent()) {
                FacilityUtilizationRate facilityUtilizationRate = facilityUtilizationRateOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                facilityUtilizationRate.setUseCount(useCount + 1);
                // view 레파지 토리에 save
                facilityUtilizationRateRepository.save(facilityUtilizationRate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
