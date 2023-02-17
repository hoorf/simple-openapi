package org.github.hoorf.openapi.core.trans;

import org.github.hoorf.openapi.core.bean.RequestContext;
import org.github.hoorf.openapi.core.bean.ResponseContext;
import org.github.hoorf.openapi.core.channel.ChannelService;

public interface TransService {
    
    String getCode();

    void setChannelService(ChannelService channelService);

    ResponseContext start(RequestContext context);
}
