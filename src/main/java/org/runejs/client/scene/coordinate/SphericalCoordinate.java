package org.runejs.client.scene.coordinate;

public class SphericalCoordinate {
    public final int yaw;
    public final int pitch;
    public final int radius;

    public SphericalCoordinate(int yaw, int pitch, int radius) {
        this.yaw = yaw;
        this.pitch = pitch;
        this.radius = radius;
    }
}
