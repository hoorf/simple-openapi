package org.github.hoorf.openapi.core.trans;

import org.github.hoorf.openapi.core.bean.RequestContext;
import org.github.hoorf.openapi.core.bean.ResponseContext;
import org.github.hoorf.openapi.core.channel.ChannelService;
import org.github.hoorf.openapi.core.trans.io.TransInput;
import org.github.hoorf.openapi.core.trans.io.TransOutput;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseTransService<I extends TransInput, O extends TransOutput> implements TransService {

    private ChannelService channelService;

    @Override
    public void setChannelService(ChannelService channelService) {
        this.channelService = channelService;
    }

    @Override
    public ResponseContext start(RequestContext context) {

        ResponseContext responseContext = new ResponseContext();

        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Class input = (Class) parameterizedType.getActualTypeArguments()[0];
        Class output = (Class) parameterizedType.getActualTypeArguments()[1];
        I i = null;
        O o = null;
        try {
            i = (I) input.newInstance();
            o = (O) output.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(context.getBiz(), o);
        try {
            channelService.run(i, o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(o, responseContext);
        return responseContext;
    }
}
