package xyz.xslendi.slenlib;

import android.util.ArrayMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Map;

import xyz.xslendi.slenlib.input.BUTTONS;
import xyz.xslendi.slenlib.input.Button;
import xyz.xslendi.slenlib.input.STICKS;
import xyz.xslendi.slenlib.input.Stick;

/**
 * A nicer gamepad class. It also provides more advanced features.
 */
public class Gamepad {

    private final com.qualcomm.robotcore.hardware.Gamepad gamepad;
    private final Telemetry telemetry;

    public ArrayMap<BUTTONS, Button> button = new ArrayMap<>();
    public ArrayMap<STICKS, Stick> stick = new ArrayMap<>();

    /**
     * The constructor for a more advanced gamepad. I recommend using this one instead since it also
     * has the ability to have toggle buttons on the gamepad.
     * @param gamepad The gamepad to use provided by FTC. If in an OpMode, use either `gamepad1` or
     *                `gamepad2`
     * @param telemetry The telemetry instance. If in an OpMode, use `telemetry`
     */
    public Gamepad(com.qualcomm.robotcore.hardware.Gamepad gamepad, Telemetry telemetry) {
        this.gamepad = gamepad;
        this.telemetry = telemetry;

        button.put(BUTTONS.A,      new Button());
        button.put(BUTTONS.B,      new Button());
        button.put(BUTTONS.X,      new Button());
        button.put(BUTTONS.Y,      new Button());
        button.put(BUTTONS.LEFT,   new Button());
        button.put(BUTTONS.RIGHT,  new Button());
        button.put(BUTTONS.UP,     new Button());
        button.put(BUTTONS.DOWN,   new Button());
        button.put(BUTTONS.START,  new Button());
        button.put(BUTTONS.LEFTB,  new Button());
        button.put(BUTTONS.RIGHTB, new Button());
        button.put(BUTTONS.LEFTT,  new Button());
        button.put(BUTTONS.RIGHTT, new Button());

        stick.put(STICKS.LEFT,  new Stick());
        stick.put(STICKS.RIGHT, new Stick());

        telemetry.log().add("INFO", "Successfully initialized gamepad");
    }

    /**
     * This function updates all controller buttons. You don't usually need to put it on another
     * thread since it might break some stuff.
     */
    public void update() {
        // WARNING: This function is extremely ugly. If you wanna improve this, good luck.
        for (Map.Entry<BUTTONS, Button> b : button.entrySet()) {
            Button button = b.getValue();
            if (button == null) {
                telemetry.log().add("WARNING", "could not add button " + b.getKey().name());
                continue;
            }

            switch (b.getKey()) {
                case A:
                    button.setPressed(gamepad.a);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case B:
                    button.setPressed(gamepad.b);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case X:
                    button.setPressed(gamepad.x);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case Y:
                    button.setPressed(gamepad.y);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case UP:
                    button.setPressed(gamepad.dpad_up);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case DOWN:
                    button.setPressed(gamepad.dpad_down);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case LEFT:
                    button.setPressed(gamepad.dpad_left);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case RIGHT:
                    button.setPressed(gamepad.dpad_right);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case START:
                    button.setPressed(gamepad.start);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case LEFTB:
                    button.setPressed(gamepad.left_bumper);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case RIGHTB:
                    button.setPressed(gamepad.right_bumper);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case LEFTT:
                    button.setPressed(gamepad.left_trigger > .5f);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                case RIGHTT:
                    button.setPressed(gamepad.right_trigger > .5f);

                    if (button.isPressed() && button.isPrevPressed()) {
                        button.setToggled(!button.isToggled());
                    }

                    button.setPrevPressed(button.isPressed());
                    break;
                default:
                    //throw new IllegalStateException("Unexpected value: " + b.getKey());
            }
        }

        for (Map.Entry<STICKS, Stick> s : stick.entrySet()) {
            Stick stick = s.getValue();

            if (stick == null) {
                telemetry.log().add("WARNING", "could not add stick " + s.getKey().name());
                continue;
            }

            switch (s.getKey()) {
                case LEFT:
                    stick.setX(gamepad.left_stick_x);
                    stick.setY(gamepad.left_stick_y);
                    break;
                case RIGHT:
                    stick.setX(gamepad.right_stick_x);
                    stick.setY(gamepad.right_stick_y);
                    break;
            }

        }
    }

}
