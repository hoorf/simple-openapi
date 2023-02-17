package org.github.hoorf.openapi.core.trans.io;

import lombok.Data;

@Data
public class BasicTwoTransInput extends TransInput {
    
    private String name;
    
    private String idCard;
}
