package com.base.warecenter.controller.forprivate;

import com.alibaba.fastjson.JSON;
import com.base.wareapi.VO.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private/ware/")
@Slf4j
public class WareController {

    @RequestMapping(value = "get",method = RequestMethod.POST)
    public String get(@RequestBody RequestVO requestVO){
        log.info("查询商品参数：{}", JSON.toJSONString(requestVO));
        return "查询商品信息";
    }
}
