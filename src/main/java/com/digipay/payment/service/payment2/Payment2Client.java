package com.digipay.payment.service.payment2;

import com.digipay.payment.service.payment1.Transfer1DTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url="${payment2.host}")
public interface Payment2Client {
    @RequestMapping(method = RequestMethod.POST, value = "${payment2.uri}")
    public void transfer(@RequestBody Transfer2DTO transfer2DTO);
}
