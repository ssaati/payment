package com.digipay.payment.service.payment2;

import com.digipay.payment.rest.TransferDTO;
import com.digipay.payment.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentService2 implements PaymentService {
    Payment2Client payment2Client;
    @Override
    public void transfer(TransferDTO transfer) {
        payment2Client.transfer(getTransfer(transfer));
    }

    private Transfer2DTO getTransfer(TransferDTO transfer) {
        Transfer2DTO transfer2DTO = new Transfer2DTO();
        transfer2DTO.setSource(transfer.getSource());
        transfer2DTO.setTarget(transfer.getDest());
        transfer2DTO.setPin2(transfer.getPin());
        transfer2DTO.setCvv2(transfer.getCvv2());
        transfer2DTO.setExpire(transfer.getExpDate());
        transfer2DTO.setAmount(transfer.getAmount());
        return transfer2DTO;
    }
}
