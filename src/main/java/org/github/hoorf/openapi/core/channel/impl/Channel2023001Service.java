package org.github.hoorf.openapi.core.channel.impl;

import lombok.extern.slf4j.Slf4j;
import org.github.hoorf.openapi.core.channel.ChannelService;
import org.github.hoorf.openapi.core.trans.TransCodeEnum;
import org.github.hoorf.openapi.core.trans.io.BasicTransOutput;
import org.github.hoorf.openapi.core.trans.io.BasicTwoTransInput;
import org.github.hoorf.openapi.core.trans.io.TransInput;
import org.github.hoorf.openapi.core.trans.io.TransOutput;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Channel2023001Service implements ChannelService {
    @Override
    public String getCode() {
        return "2023001";
    }

    @Override
    public void run(TransInput input, TransOutput o) throws InterruptedException {
        String transCode = input.getTransCode();
        if(TransCodeEnum.TRANS_100.getCode().equals(transCode)){
            BasicTwoTransInput basicTwoTransInput = (BasicTwoTransInput) input;
            log.info("输入 :{}",basicTwoTransInput);
            Thread.sleep(300);
            BasicTransOutput output = (BasicTransOutput) o;
            output.setResultCode("200");
            output.setResultMsg("验证一致");
        }
    }
}
