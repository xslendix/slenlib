package xyz.xslendi.slenlib.input;

/**
 * A very basic implementation of a gamepad stick class. This might get updated in the future.
 */
public class Stick {
    private float x = 0f;
    private float y = 0f;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
