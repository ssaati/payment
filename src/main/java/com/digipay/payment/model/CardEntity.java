package com.digipay.payment.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "card")
public class CardEntity {
    @Id
    Long id;

    Long userId;

    String holder;

    String iban;

    String cvv2;

    Integer expDate;

    String pin;

    Date modifyDate;
}
