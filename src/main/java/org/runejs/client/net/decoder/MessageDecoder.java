package org.runejs.client.net.decoder;

import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.message.InboundMessage;

public interface MessageDecoder<M extends InboundMessage> {
    M decode(PacketBuffer buffer);
}
