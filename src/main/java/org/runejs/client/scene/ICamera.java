package org.runejs.client.scene;

public interface ICamera<TPosition> {
    void setPosition(TPosition position);
    TPosition getPosition();
}
