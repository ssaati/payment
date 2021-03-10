package com.digipay.payment.rest;

import lombok.Data;
import java.util.Date;

@Data
public class CardDTO {
    String id;
    String holder;
    String iban;
    String cvv2;
    Integer expDate;
    String pin;
    Date modifyDate;
}
