package com.digipay.payment.service.payment1;

import com.digipay.payment.rest.TransferDTO;
import com.digipay.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentService1 implements PaymentService {
    Payment1Client payment1Client;
    @Override
    public void transfer(TransferDTO transfer) {
        log.debug("transfer using payment1");
        payment1Client.transfer(getTransfer(transfer));

    }
    private Transfer1DTO getTransfer(TransferDTO transfer) {
        Transfer1DTO transfer1DTO = new Transfer1DTO();
        transfer1DTO.setSource(transfer.getSource());
        transfer1DTO.setDest(transfer.getDest());
        transfer1DTO.setPin(transfer.getPin());
        transfer1DTO.setCvv2(transfer.getCvv2());
        transfer1DTO.setExpDate(transfer.getExpDate());
        transfer1DTO.setAmount(transfer.getAmount());
        return transfer1DTO;
    }

}
