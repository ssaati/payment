package com.digipay.payment.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository  extends JpaRepository<CardEntity, Long> {

    List<CardEntity> findAllByUserId(Long userId);

    Optional<CardEntity> findByIban(String iban);

    void deleteById(Long id);
}
