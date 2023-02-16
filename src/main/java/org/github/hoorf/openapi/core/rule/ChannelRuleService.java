package org.github.hoorf.openapi.core.rule;

import org.github.hoorf.openapi.core.rule.bean.ChannelRule;

import java.util.List;

public interface ChannelRuleService {
    
    List<ChannelRule> getChannelRule(String merchantNo,String transCode);
}
