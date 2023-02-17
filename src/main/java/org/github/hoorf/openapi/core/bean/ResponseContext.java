package org.github.hoorf.openapi.core.bean;

import lombok.Data;

@Data
public class ResponseContext {

    private Boolean success;
    private Boolean finish;
    private Boolean overtime;
    private String resultCode;
    private String resultMsg;

    private Object data;
}
