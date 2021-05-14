package xyz.xslendi.slenlib;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * This is the base of all OpModes. Use this instead of the one provided by qualcomm
 */
public class BaseOpMode extends OpMode {

    boolean enabled = false;

    public Gamepad gamepad_primary, gamepad_secondary;

    @Override
    public void init() {
        this.gamepad_primary = new Gamepad(gamepad1, telemetry);
        this.gamepad_secondary = new Gamepad(gamepad2, telemetry);
    }

    @Override
    public void loop() {
    }

    /**
     * This function is responsible for enabling or disabling the OpMode.
     * This does not however stop the initialization process. Only the loop.
     * @param enabled The new value
     */
    public void setEnabled(boolean enabled) {
        this.enabled = false;
    }
}
