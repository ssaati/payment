package com.digipay.payment.rest;

import lombok.Data;

@Data
public class TransferDTO {
    String source;
    String dest;
    String cvv2;
    String expDate;
    String pin;
    Integer amount;
}
