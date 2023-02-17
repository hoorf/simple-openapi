package org.github.hoorf.openapi.core.bean;

import lombok.Data;

import java.util.Map;

@Data
public class RequestContext {
    private String merchantNo;
    private String transCode;
    private Map<String, Object> biz;
}
