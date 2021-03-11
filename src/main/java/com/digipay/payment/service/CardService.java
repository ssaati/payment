package com.digipay.payment.service;

import com.digipay.payment.model.CardEntity;
import com.digipay.payment.model.CardRepository;
import com.digipay.payment.rest.TransferDTO;
import com.digipay.payment.security.SecurityUtils;
import com.digipay.payment.service.notification.NotificationSender;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    CardRepository cardRepository;
    PaymentFinder paymentFinder;
    NotificationSender notificationSender;

    public List<CardEntity> findAllByUserId(Long userId){
        return cardRepository.findAllByUserId(userId);
    }

    public CardEntity save(CardEntity cardEntity) {
        return cardRepository.save(cardEntity);
    }

    public void deleteById(Long id) throws CardNotFoundException {
        Optional<CardEntity> card = cardRepository.findById(id);
        if(card.isPresent() && card.get().getUserId().equals(SecurityUtils.getCurrentUser()))
            cardRepository.deleteById(id);
        else
            throw new CardNotFoundException();
    }

    public void transfer(TransferDTO transfer) {
        paymentFinder.transfer(transfer);
        notificationSender.sendNotification(SecurityUtils.getCurrentUserPhone(), "Payment done");
    }
}
