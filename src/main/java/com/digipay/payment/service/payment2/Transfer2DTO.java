package com.digipay.payment.service.payment2;

import lombok.Data;

@Data
public class Transfer2DTO {
    String source;
    String target;
    String cvv2;
    String expire;
    String pin2;
    Integer amount;
}
