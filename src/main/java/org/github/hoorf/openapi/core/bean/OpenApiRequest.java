package org.github.hoorf.openapi.core.bean;

import lombok.Data;

import java.util.Map;

@Data
public class OpenApiRequest {
    private String merchantNo;
    private String transCode;
    private String sign;
    private Map<String, Object> biz;
}
