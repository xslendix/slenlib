package xyz.xslendi.slenlib.SampleTeleOps;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import xyz.xslendi.slenlib.MecanumBase;

/*
  This is a very simple implementation of a mecanum-wheeled robot. This uses the MecanumBase class
  for an easier implementation which you can probably see below.
 */

@TeleOp(name = "Mecanum", group = "slenlib: Example TeleOp")
public class TestTeleOp extends MecanumBase {
    // These functions are not needed but you can still have them as an option.
    // They are here for demonstration purposes.

    @Override
    public void init() {
        super.init();
        // Initialize servos, more motors etc.
    }

    @Override
    public void loop() {
        super.loop();
        // This loops after the driver hits play
    }

    @Override
    public void start() {
        super.start();
        // This is executes after the driver hits play
    }

    @Override
    public void init_loop() {
        super.init_loop();
        // This loops after the driver hits init
    }

    @Override
    public void stop() {
        super.stop();
        // This executes when the driver hits stop
    }
}
