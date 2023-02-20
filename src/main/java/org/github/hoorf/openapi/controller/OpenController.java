package org.github.hoorf.openapi.controller;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import org.github.hoorf.openapi.core.bean.OpenApiRequest;
import org.github.hoorf.openapi.core.bean.OpenApiResponse;
import org.github.hoorf.openapi.core.bean.RequestContext;
import org.github.hoorf.openapi.core.bean.ResponseContext;
import org.github.hoorf.openapi.core.channel.ChannelService;
import org.github.hoorf.openapi.core.rule.ChannelRule;
import org.github.hoorf.openapi.core.rule.ChannelRuleService;
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
import java.util.stream.Collectors;

@RestController
public class OpenController {

    @Autowired
    private ChannelRuleService channelRuleService;
    @Autowired
    List<TransService> transServices;
    @Autowired
    List<ChannelService> channelServices;

    private static Map<String, TransService> transServiceMap;

    private static Map<String, ChannelService> channelServiceMap;


    @PostConstruct
    public void init() {
        transServiceMap = transServices.stream().collect(Collectors.toMap(TransService::getCode, Function.identity()));
        channelServiceMap = channelServices.stream().collect(Collectors.toMap(ChannelService::getCode, Function.identity()));
    }


    @PostMapping("/openapi/execute.do")
    public OpenApiResponse execute(@RequestBody OpenApiRequest request) {
        OpenApiResponse response = new OpenApiResponse();
        RequestContext context = buildContext(request);
        List<ChannelRule> channelRule = channelRuleService.getChannelRule(context.getMerchantNo(), context.getTransCode());
        if (CollUtil.isNotEmpty(channelRule)) {
            for (ChannelRule rule : channelRule) {
                TransService transService = transServiceMap.get(rule.getTransCode());
                ChannelService channelService = channelServiceMap.get(rule.getChannelCode());
                transService.setChannelService(channelService);
                ResponseContext responseContext = transService.start(context);
                if (responseContext.getFinish()) {
                    return buildResponse(responseContext, response);
                }
            }
        }
        return response;
    }

    private OpenApiResponse buildResponse(ResponseContext responseContext, OpenApiResponse response) {
        response.setCode(responseContext.getResultCode());
        response.setMsg(responseContext.getResultMsg());
        response.setData(JSON.parseObject(JSON.toJSONString(responseContext.getData()), Map.class));
        return response;
    }

    private RequestContext buildContext(OpenApiRequest request) {
        RequestContext context = new RequestContext();
        if (null != request.getBiz()) {
            context.setBiz(new HashMap<>(request.getBiz()));
        }
        context.setMerchantNo(request.getMerchantNo());
        context.setTransCode(request.getTransCode());
        return context;
    }
}
