package org.runejs.client.message.handler.rs435.region;

import org.runejs.client.Class13;
import org.runejs.client.Class44;
import org.runejs.client.LinkedList;
import org.runejs.client.RSString;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.region.LoadStandardRegionInboundMessage;
import org.runejs.client.net.ISAAC;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.tile.GenericTile;

/**
 * Loads a standard map region (i.e from terrain files)
 */
public class LoadStandardRegionMessageHandler implements MessageHandler<LoadStandardRegionInboundMessage> {
    @Override
    public void handle(LoadStandardRegionInboundMessage message) {
        GroundItemTile.loadGeneratedMap = false;

        int chunkLocalY = message.chunkLocalY;
        int chunkX = message.chunkX;
        int chunkLocalX = message.chunkLocalX;
        int chunkY = message.chunkY;
        int level = message.level;
        int regionCount = message.regionCount;
        Class44.xteaKeys = message.xteaKeys;
        ISAAC.mapCoordinates = new int[regionCount];
        RSString.terrainData = new byte[regionCount][];
        boolean inTutorialIsland_maybe = false;
        GenericTile.objectData = new byte[regionCount][];
        if((chunkX / 8 == 48 || chunkX / 8 == 49) && chunkY / 8 == 48) {
            inTutorialIsland_maybe = true;
        }
        LinkedList.terrainDataIds = new int[regionCount];
        if(chunkX / 8 == 48 && chunkY / 8 == 148) {
            inTutorialIsland_maybe = true;
        }
        Class13.objectDataIds = new int[regionCount];
        regionCount = 0;
        for(int x = (-6 + chunkX) / 8; x <= (6 + chunkX) / 8; x++) {
            for(int y = (-6 + chunkY) / 8; (6 + chunkY) / 8 >= y; y++) {
                int coords = y + (x << 8);
                if(!inTutorialIsland_maybe || y != 49 && y != 149 && y != 147 && x != 50 && (x != 49 || y != 47)) {
                    ISAAC.mapCoordinates[regionCount] = coords;

                    String mapKey = x + Native.MAP_NAME_UNDERSCORE + y;
                    String mapKeyM = Native.MAP_NAME_PREFIX_M + mapKey;
                    String mapKeyL = Native.MAP_NAME_PREFIX_L + mapKey;

                    LinkedList.terrainDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getHash(mapKeyM);
                    Class13.objectDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getHash(mapKeyL);
                    regionCount++;
                }
            }
        }

        Actor.method789(chunkLocalX, chunkY, chunkX, chunkLocalY, level);
    }
}
