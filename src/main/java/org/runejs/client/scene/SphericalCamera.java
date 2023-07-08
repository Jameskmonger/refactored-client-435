package org.runejs.client.scene;

import org.runejs.client.scene.coordinate.SphericalCoordinate;

public class SphericalCamera implements ICamera<SphericalCoordinate> {

    private SphericalCoordinate position = new SphericalCoordinate(0, 0, 0);

    @Override
    public void setPosition(SphericalCoordinate sphericalCoordinate) {
        this.position = sphericalCoordinate;
    }

    @Override
    public SphericalCoordinate getPosition() {
        return this.position;
    }

    public int getYaw() {
        return position.yaw;
    }

    public void setYaw(int yaw) {
        position = new SphericalCoordinate(
            yaw,
            position.pitch,
            position.radius
        );
    }

    public int getPitch() {
        return position.pitch;
    }

    public void setPitch(int pitch) {
        position = new SphericalCoordinate(
            position.yaw,
            pitch,
            position.radius
        );
    }

    public int getZoom() {
        return position.radius;
    }

    public void setZoom(int zoom) {
        position = new SphericalCoordinate(
            position.yaw,
            position.pitch,
            zoom
        );
    }
}
