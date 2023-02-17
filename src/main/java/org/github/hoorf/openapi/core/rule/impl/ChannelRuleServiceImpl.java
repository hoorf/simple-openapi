package org.github.hoorf.openapi.core.rule.impl;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import org.github.hoorf.openapi.core.rule.ChannelRule;
import org.github.hoorf.openapi.core.rule.ChannelRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChannelRuleServiceImpl implements ChannelRuleService {

    private static Map<String, List<ChannelRule>> ruleMap;

    @PostConstruct
    public void init() {
        List<ChannelRule> channelRules = JSON.parseArray(FileUtil.readString("classpath:channelRule.json", Charset.defaultCharset()), ChannelRule.class);
        ruleMap = channelRules.stream().collect(Collectors.groupingBy(x -> x.getMerchantNo() + "-" + x.getTransCode()));
    }

    @Override
    public List<ChannelRule> getChannelRule(String merchantNo, String transCode) {
        return ruleMap.get(merchantNo + "-" + transCode);
    }
}
