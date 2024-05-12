package com.sandeep.fooddeliveryupdateservice.services;

import com.sandeep.fooddeliveryupdateservice.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Producing the location update for the end user
    public void updateLocation(String location)
    {
        kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
        logger.info("Location updated successfully");
    }
}
