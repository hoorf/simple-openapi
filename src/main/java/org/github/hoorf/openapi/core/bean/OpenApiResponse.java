package org.github.hoorf.openapi.core.bean;

import lombok.Data;

import java.util.Map;

@Data
public class OpenApiResponse {
    private String taskId;
    
    private String code;
    
    private String msg;
    
    private Map<String,Object> data;
}
