package schoolrental.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import schoolrental.config.kafka.KafkaProcessor;
import schoolrental.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    SpaceRepository spaceRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FacilityReserved'"
    )
    public void wheneverFacilityReserved_UpdateReserveStatus(
        @Payload FacilityReserved facilityReserved
    ) {
        FacilityReserved event = facilityReserved;
        System.out.println(
            "\n\n##### listener UpdateReserveStatus : " +
            facilityReserved +
            "\n\n"
        );

        // Sample Logic //
        Space.updateReserveStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor