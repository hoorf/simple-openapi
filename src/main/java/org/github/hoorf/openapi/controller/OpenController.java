package org.github.hoorf.openapi.controller;

import org.github.hoorf.openapi.core.bean.OpenApiRequest;
import org.github.hoorf.openapi.core.bean.OpenApiResponse;
import org.github.hoorf.openapi.core.channel.ChannelService;
import org.github.hoorf.openapi.core.trans.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class OpenController {
    @Autowired
    private List<TransService> transServices;

    @Autowired
    private List<ChannelService> channelServices;

    private static Map<String, TransService> transServiceMap;
    
    private static Map<String, ChannelService> channelServiceMap;

    @PostConstruct
    public void init() {
        transServiceMap = transServices.stream().collect(Collectors.toMap(TransService::getCode,Function.identity()));
        channelServiceMap = channelServices.stream().collect(Collectors.toMap(ChannelService::getCode,Function.identity()));
    }
    

    @PostMapping("/openapi/execute.do")
    public OpenApiResponse execute(@RequestBody OpenApiRequest request) {
        
    }
}
