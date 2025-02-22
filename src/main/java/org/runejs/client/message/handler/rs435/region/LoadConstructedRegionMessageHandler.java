package org.runejs.client.message.handler.rs435.region;

import org.runejs.client.Class13;
import org.runejs.client.Class44;
import org.runejs.client.LinkedList;
import org.runejs.client.RSString;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.region.LoadConstructedRegionInboundMessage;
import org.runejs.client.net.ISAAC;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.tile.GenericTile;

/**
 * Loads a construction map region (i.e composed from chunks)
 */
public class LoadConstructedRegionMessageHandler implements MessageHandler<LoadConstructedRegionInboundMessage> {
    @Override
    public void handle(LoadConstructedRegionInboundMessage message) {
        GroundItemTile.loadGeneratedMap = true;

        int chunkLocalY = message.chunkLocalY;
        int chunkX = message.chunkX;
        int chunkLocalX = message.chunkLocalX;
        int chunkY = message.chunkY;
        int level = message.level;
        int regionCount = message.regionCount;

        Class44.xteaKeys = message.xteaKeys;
        OverlayDefinition.constructMapTiles = message.mapTiles;

        LinkedList.terrainDataIds = new int[regionCount];
        RSString.terrainData = new byte[regionCount][];
        Class13.objectDataIds = new int[regionCount];
        GenericTile.objectData = new byte[regionCount][];
        ISAAC.mapCoordinates = new int[regionCount];
        regionCount = 0;
        for(int i_11_ = 0; i_11_ < 4; i_11_++) {
            for(int i_12_ = 0; i_12_ < 13; i_12_++) {
                for(int i_13_ = 0; i_13_ < 13; i_13_++) {
                    int i_14_ = OverlayDefinition.constructMapTiles[i_11_][i_12_][i_13_];
                    if(i_14_ != -1) {
                        int i_15_ = i_14_ >> 14 & 0x3ff;
                        int i_16_ = i_14_ >> 3 & 0x7ff;
                        int i_17_ = i_16_ / 8 + (i_15_ / 8 << 8);
                        for(int i_18_ = 0; regionCount > i_18_; i_18_++) {
                            if(ISAAC.mapCoordinates[i_18_] == i_17_) {
                                i_17_ = -1;
                                break;
                            }
                        }
                        if(i_17_ != -1) {
                            ISAAC.mapCoordinates[regionCount] = i_17_;
                            int i_19_ = i_17_ & 0xff;
                            int i_20_ = (0xffbe & i_17_) >> 8;
                            LinkedList.terrainDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getHash(Native.MAP_NAME_PREFIX_M +i_20_+ Native.MAP_NAME_UNDERSCORE +i_19_);
                            Class13.objectDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getHash(Native.MAP_NAME_PREFIX_L +i_20_+ Native.MAP_NAME_UNDERSCORE +i_19_);
                            regionCount++;
                        }
                    }
                }
            }
        }
        Actor.method789(chunkLocalX, chunkY, chunkX, chunkLocalY, level);
    }
}
