package org.runejs.client.net.codec.runejs435.encoder.chat;

import org.runejs.client.ProducingGraphicsBuffer_Sub1;
import org.runejs.client.message.outbound.chat.SendChatMessageOutboundMessage;
import org.runejs.client.message.outbound.chat.SendPrivateMessageOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.VariableLengthPacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} that encodes {@link SendChatMessageOutboundMessage}s.
 * 
 * This is used to send private messages to the server.
 */
public class SendPrivateMessageMessageEncoder implements MessageEncoder<SendPrivateMessageOutboundMessage> {
    @Override
    public PacketBuffer encode(SendPrivateMessageOutboundMessage message) {
        VariableLengthPacketBuffer buffer = OutgoingPackets.openVariableSizePacket(207);

        buffer.putLongBE(message.recipient);

        // probably putString?
        ProducingGraphicsBuffer_Sub1.method1052(message.message, buffer);

        buffer.writePacketLength();

        return buffer;
    }
}
