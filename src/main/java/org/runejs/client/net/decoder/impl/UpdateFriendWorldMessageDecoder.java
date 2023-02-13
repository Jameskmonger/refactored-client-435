package org.runejs.client.net.decoder.impl;

import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.decoder.MessageDecoder;
import org.runejs.client.net.message.impl.UpdateFriendWorldMessage;

public class UpdateFriendWorldMessageDecoder implements MessageDecoder<UpdateFriendWorldMessage> {
    @Override
    public UpdateFriendWorldMessage decode(PacketBuffer buffer) {
        long l = buffer.getLongBE();
        int i_1_ = buffer.getUnsignedShortBE();

        return new UpdateFriendWorldMessage(l, i_1_);
    }
}
