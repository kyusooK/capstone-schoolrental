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
    FacilityRepository facilityRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SpaceMaintained'"
    )
    public void wheneverSpaceMaintained_RegisterFacility(
        @Payload SpaceMaintained spaceMaintained
    ) {
        SpaceMaintained event = spaceMaintained;
        System.out.println(
            "\n\n##### listener RegisterFacility : " + spaceMaintained + "\n\n"
        );

        // Sample Logic //
        Facility.registerFacility(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
