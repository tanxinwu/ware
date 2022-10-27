package com.base.wareapi.service;

import com.base.wareapi.VO.RequestVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "h3-ware")
public interface WareService {

    @RequestMapping(value = "/private/ware/get" ,method = RequestMethod.POST)
    String get(@RequestBody  RequestVO requestVO);
}
