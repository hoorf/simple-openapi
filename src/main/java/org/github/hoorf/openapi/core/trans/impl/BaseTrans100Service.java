package org.github.hoorf.openapi.core.trans.impl;

import org.github.hoorf.openapi.core.trans.BaseTransService;
import org.github.hoorf.openapi.core.trans.TransCodeEnum;
import org.github.hoorf.openapi.core.trans.io.BasicTransOutput;
import org.github.hoorf.openapi.core.trans.io.BasicTwoTransInput;
import org.springframework.stereotype.Service;

@Service
public class BaseTrans100Service extends BaseTransService<BasicTwoTransInput, BasicTransOutput> {

    @Override
    public String getCode() {
        return TransCodeEnum.TRANS_100.getCode();
    }
}
