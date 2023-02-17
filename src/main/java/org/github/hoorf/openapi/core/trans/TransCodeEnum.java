package org.github.hoorf.openapi.core.trans;

public enum TransCodeEnum {
    TRANS_100("100", "身份证二要素");

    TransCodeEnum(String transCode, String transName) {
        this.code = transCode;
        this.name = transName;
    }

    private String code;
    private String name;


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
