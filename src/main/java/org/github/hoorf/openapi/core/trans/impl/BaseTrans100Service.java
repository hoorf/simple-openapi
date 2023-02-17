package org.github.hoorf.openapi.core.trans.impl;

import org.github.hoorf.openapi.core.trans.BaseTransService;
import org.github.hoorf.openapi.core.trans.TransCodeEnum;
import org.springframework.stereotype.Service;

@Service
public class BaseTrans100Service<BasicTwoTransInput, BasicTransOutput> extends BaseTransService {

    @Override
    public String getCode() {
        return TransCodeEnum.TRANS_100.getCode();
    }
}
