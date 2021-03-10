package com.digipay.payment.service.payment1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url="${payment1.host}")
public interface Payment1Client {
    @RequestMapping(method = RequestMethod.POST, value = "${payment1.uri}")
    public void transfer(@RequestBody Transfer1DTO transfer1DTO);
}
