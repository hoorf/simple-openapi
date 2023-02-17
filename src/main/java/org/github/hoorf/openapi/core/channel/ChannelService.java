package org.github.hoorf.openapi.core.channel;

import org.github.hoorf.openapi.core.trans.io.TransInput;
import org.github.hoorf.openapi.core.trans.io.TransOutput;

public interface ChannelService {

    String getCode();

    void run(TransInput input, TransOutput o) throws InterruptedException;
}
