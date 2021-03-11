package com.digipay.payment.service.notification;

import lombok.Data;

@Data
public class SmsDTO {
    String receiver;
    String text;
}
