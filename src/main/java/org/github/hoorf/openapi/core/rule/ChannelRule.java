package org.github.hoorf.openapi.core.rule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelRule {
    
    //租户
    private String merchantNo;
    
    //业务
    private String transCode;
    
    //渠道
    private String channelCode;
    
    //权重
    private Integer weight;
}
