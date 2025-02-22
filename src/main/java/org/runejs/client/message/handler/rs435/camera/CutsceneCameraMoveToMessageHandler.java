package org.runejs.client.message.handler.rs435.camera;

import org.runejs.client.Class12;
import org.runejs.client.Class37;
import org.runejs.client.Class59;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.camera.CutsceneCameraMoveToInboundMessage;
import org.runejs.client.scene.SceneCluster;

public class CutsceneCameraMoveToMessageHandler implements MessageHandler<CutsceneCameraMoveToInboundMessage> {
    @Override
    public void handle(CutsceneCameraMoveToInboundMessage message) {
        Player.cutsceneActive = true;
        MovedStatics.anInt545 = message.targetX;
        SceneCluster.anInt767 = message.targetY;
        MovedStatics.anInt194 = message.height;
        MovedStatics.cutsceneCameraPositionBaseAdjust = message.speedBase;
        Class59.cutsceneCameraPositionScaleAdjust = message.speedScale;
        if(Class59.cutsceneCameraPositionScaleAdjust >= 100) {
            MovedStatics.cameraY = 64 + SceneCluster.anInt767 * 128;
            Class12.cameraX = MovedStatics.anInt545 * 128 + 64;
            SceneCluster.cameraZ = Class37.getFloorDrawHeight(Player.worldLevel, Class12.cameraX, MovedStatics.cameraY) - MovedStatics.anInt194;
        }
    }
}
