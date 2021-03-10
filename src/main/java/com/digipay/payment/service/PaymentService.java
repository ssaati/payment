package com.digipay.payment.service;

import com.digipay.payment.rest.TransferDTO;

public interface PaymentService {
    public void transfer(TransferDTO transfer);
}
