package org.github.hoorf.openapi.core.rule.impl;

import org.github.hoorf.openapi.core.rule.ChannelRule;
import org.github.hoorf.openapi.core.rule.ChannelRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChannelRuleServiceImpl implements ChannelRuleService {

    private static Map<String, List<ChannelRule>> ruleMap;

    @PostConstruct
    public void init() {
        ruleMap = new HashMap<>();
        ChannelRule channelRule = new ChannelRule();
    }

    @Override
    public List<ChannelRule> getChannelRule(String merchantNo, String transCode) {
        return null;
    }
}
