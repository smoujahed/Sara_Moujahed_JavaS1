package com.trilogyed.clientservice.util.feign;

import com.trilogyed.clientservice.model.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "banking-service")
public interface BankingFeignClient {
    @RequestMapping(value = "/account/addfunds", method = RequestMethod.POST)
    public Transaction creditAccount(@RequestBody Transaction transaction);

    @RequestMapping(value = "/account/{number}", method = RequestMethod.GET)
    public Transaction getAccountInfo(@PathVariable("number") String number);
}
