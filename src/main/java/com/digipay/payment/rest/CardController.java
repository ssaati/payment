package com.digipay.payment.rest;

import com.digipay.payment.model.CardEntity;
import com.digipay.payment.security.SecurityUtils;
import com.digipay.payment.service.CardNotFoundException;
import com.digipay.payment.service.CardService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CardController {
    CardService cardService;
    ModelMapper modelMapper;

    public CardController(CardService cardService, ModelMapper modelMapper) {
        this.cardService = cardService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/cards")
    public List<CardDTO> findAllByUserId(){
        List<CardEntity> allByUserId = cardService.findAllByUserId(SecurityUtils.getCurrentUser());
        List<CardDTO> results = new ArrayList<>();
        for(CardEntity cardEntity : allByUserId){
            results.add(modelMapper.map(cardEntity, CardDTO.class));
        }
        return results;
    }

    @PostMapping("/cards")
    public CardDTO newCard(@RequestBody CardDTO newCard) {
        CardEntity cardEntity = modelMapper.map(newCard, CardEntity.class);
        cardEntity.setUserId(SecurityUtils.getCurrentUser());
        CardEntity savedEntity = cardService.save(cardEntity);
        return modelMapper.map(savedEntity, CardDTO.class);
    }

    @DeleteMapping("/cards/{id}")
    public void deleteCard(@PathVariable Long id) {
        try {
            cardService.deleteById(id);
        } catch (CardNotFoundException e) {
            e.printStackTrace();
        }
    }
    @PostMapping("/cards/transfer")
    public void transfer(@RequestBody TransferDTO transfer) {
        cardService.transfer(transfer);
    }

}
