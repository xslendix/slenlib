package xyz.xslendi.slenlib.input;

/**
 * A custom button class that also provides the ability to toggle buttons.
 */
public class Button {
    private boolean prevPressed = false;
    private boolean pressed = false;
    private boolean toggled = false;

    public boolean isPrevPressed() {
        return prevPressed;
    }

    public void setPrevPressed(boolean prevPressed) {
        this.prevPressed = prevPressed;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }
}
