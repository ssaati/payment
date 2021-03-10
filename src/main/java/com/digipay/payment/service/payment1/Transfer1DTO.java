package com.digipay.payment.service.payment1;

import lombok.Data;

@Data
public class Transfer1DTO {
    String source;
    String dest;
    String cvv2;
    String expDate;
    String pin;
    Integer amount;
}
