package org.runejs.client.message.handler.rs435.camera;

import org.runejs.client.Class37;
import org.runejs.client.Class59;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.camera.CutsceneCameraMoveToInboundMessage;
import org.runejs.client.scene.SceneCamera;
import org.runejs.client.scene.SceneCluster;

public class CutsceneCameraMoveToMessageHandler implements MessageHandler<CutsceneCameraMoveToInboundMessage> {
    @Override
    public void handle(CutsceneCameraMoveToInboundMessage message) {
        Player.cutsceneActive = true;
        // cutscene camera will be positioned on this tile in the region
        MovedStatics.cutsceneCameraTilePosX = message.targetX;
        SceneCluster.cutsceneCameraTilePosY = message.targetY;
        MovedStatics.cutsceneCameraPosHeight = message.height;
        MovedStatics.cutsceneCameraPositionBaseAdjust = message.speedBase;
        Class59.cutsceneCameraPositionScaleAdjust = message.speedScale;
        if(Class59.cutsceneCameraPositionScaleAdjust >= 100) {
            SceneCamera.cameraY = 64 + SceneCluster.cutsceneCameraTilePosY * 128;
            SceneCamera.cameraX = MovedStatics.cutsceneCameraTilePosX * 128 + 64;
            SceneCamera.cameraZ = Class37.getFloorDrawHeight(Player.worldLevel, SceneCamera.cameraX, SceneCamera.cameraY) - MovedStatics.cutsceneCameraPosHeight;
        }
    }
}
