package com.digipay.payment.service;

import com.digipay.payment.rest.TransferDTO;
import com.digipay.payment.service.PaymentService;
import com.digipay.payment.service.payment1.PaymentService1;
import com.digipay.payment.service.payment2.PaymentService2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PaymentFinder {
    PaymentService1 paymentService1;
    PaymentService2 paymentService2;
    public PaymentService chooseService(String card){
        if(card != null && card.startsWith("6037"))
            return  paymentService1;
        else
            return paymentService2;
    }

    @Transactional
    public void transfer(TransferDTO transfer) {
        chooseService(transfer.getSource()).transfer(transfer);
    }
}
