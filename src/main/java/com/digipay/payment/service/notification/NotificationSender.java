package com.digipay.payment.service.notification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationSender {

    public static final String SMS_TOPIC = "SMS_TOPIC";
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendNotification(String phone, String text) {
        SmsDTO smsDTO = new SmsDTO();
        smsDTO.setReceiver(phone);
        smsDTO.setText(text);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String smsJson = objectMapper.writeValueAsString(smsDTO);
            kafkaTemplate.send(SMS_TOPIC, smsJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
