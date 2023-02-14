package org.runejs.client.net.decoder.impl;

import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.decoder.MessageDecoder;
import org.runejs.client.net.message.impl.LoadStandardMapRegionMessage;

public class LoadStandardMapRegionMessageDecoder implements MessageDecoder<LoadStandardMapRegionMessage> {
    @Override
    public LoadStandardMapRegionMessage decode(PacketBuffer buffer) {
        int chunkLocalY = buffer.getUnsignedShortBE();
        int chunkX = buffer.getUnsignedShortLE();
        int chunkLocalX = buffer.getUnsignedShortBE();
        int chunkY = buffer.getUnsignedShortLE();
        int level = buffer.getUnsignedByte();

        // TODO (jameskmonger) handle packet size
        int regionCount = (IncomingPackets.incomingPacketSize - buffer.currentPosition) / 16;
        int[] encryptionKeys = new int[regionCount];

        // TODO (jameskmonger) read encryption keys

        return new LoadStandardMapRegionMessage(chunkLocalX, chunkLocalY, chunkX, chunkY, level, encryptionKeys);
    }
}
