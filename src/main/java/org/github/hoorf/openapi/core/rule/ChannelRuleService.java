package org.github.hoorf.openapi.core.rule;

import java.util.List;

public interface ChannelRuleService {
    
    List<ChannelRule> getChannelRule(String merchantNo,String transCode);
}
