package org.runejs.client.net.message.impl;

import org.runejs.client.net.message.InboundMessage;

/**
 * Network message received when a friend changes worlds, logs in or out.
 */
public class UpdateFriendWorldMessage implements InboundMessage {
    // TODO (Jameskmonger) consider making this a `string username`
    private long friendNameHash;
    private int worldId;

    public UpdateFriendWorldMessage(long friendNameHash, int worldId) {
        this.friendNameHash = friendNameHash;
        this.worldId = worldId;
    }

    public long getFriendNameHash() {
        return this.friendNameHash;
    }

    public int getWorldId() {
        return this.worldId;
    }
}
