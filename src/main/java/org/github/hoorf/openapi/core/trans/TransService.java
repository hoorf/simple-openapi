package org.github.hoorf.openapi.core.trans;

import org.github.hoorf.openapi.core.bean.OpenApiRequest;
import org.github.hoorf.openapi.core.bean.OpenApiResponse;
import org.github.hoorf.openapi.core.channel.ChannelService;
import org.github.hoorf.openapi.core.trans.io.TransInput;
import org.github.hoorf.openapi.core.trans.io.TransOutput;

public abstract class TransService<I extends TransInput, O extends TransOutput> {


    public TransService(OpenApiRequest request) {

    }


    public  ChannelService chooseChannelService(){
        
    }


    public OpenApiResponse invoke() {
        ChannelService channelService = chooseChannelService();
        if (null != channelService) {
            channelService.run()
        }
    }
}
