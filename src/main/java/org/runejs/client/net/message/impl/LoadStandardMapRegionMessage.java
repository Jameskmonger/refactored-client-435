package org.runejs.client.net.message.impl;

import org.runejs.client.net.message.InboundMessage;

public class LoadStandardMapRegionMessage implements InboundMessage {
    private int chunkLocalX;
    private int chunkLocalY;
    private int chunkX;
    private int chunkY;
    private int level;

    private int[] encryptionKeys;

    public LoadStandardMapRegionMessage(int chunkLocalX, int chunkLocalY, int chunkX, int chunkY, int level, int[] encryptionKeys) {
        this.chunkLocalX = chunkLocalX;
        this.chunkLocalY = chunkLocalY;
        this.chunkX = chunkX;
        this.chunkY = chunkY;
        this.level = level;
        this.encryptionKeys = encryptionKeys;
    }

    public int getChunkLocalX() {
        return chunkLocalX;
    }

    public int getChunkLocalY() {
        return chunkLocalY;
    }

    public int getChunkX() {
        return chunkX;
    }

    public int getChunkY() {
        return chunkY;
    }

    public int getLevel() {
        return level;
    }

    public int[] getEncryptionKeys() {
        return encryptionKeys;
    }
}
