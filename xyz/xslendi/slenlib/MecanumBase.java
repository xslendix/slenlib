package xyz.xslendi.slenlib;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * This class is very useful for creating code for mecanum-wheeled robots
 * This is what you want to extend in your TeleOp
 */
public class MecanumBase extends BaseOpMode {

    public DcMotor motorFL, motorFR, motorBL, motorBR;

    /**
     * This function is responsible for applying different mecanum-specific settings and also
     * initializes motors and gamepads.
     * @param motorFL The front left motor
     * @param motorFR The front right motor
     * @param motorBL The back left motor
     * @param motorBR The back right motor
     */
    public void start(DcMotor motorFL, DcMotor motorFR, DcMotor motorBL, DcMotor motorBR) {
        this.telemetry.log().add("MECANUMBASE: INFO", "Initializing");

        this.motorFL = motorFL;
        this.motorFR = motorFR;
        this.motorBL = motorBL;
        this.motorBR = motorBR;

        telemetry.log().add("MECANUMBASE: INFO", "Setting up motors");

        motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorBR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFR.setDirection(DcMotorSimple.Direction.REVERSE);

        motorFL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorFR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        this.telemetry.log().add("MECANUMBASE: INFO", "Done initializing");
    }

    public void updateInput() {
        gamepad_primary.update();
        gamepad_secondary.update();
    }

    /**
     * This function is what actually moves the robot.
     */
    public void updateMotors() {
        float drive = 1f - gamepad_primary.stick.get("left").getY();
        float strafe = gamepad_primary.stick.get("left").getY();
        float rotate = gamepad_primary.stick.get("right").getX();

        motorBL.setPower(drive + strafe + rotate);
        motorBR.setPower(drive - strafe + rotate);
        motorFL.setPower(drive - strafe - rotate);
        motorFR.setPower(drive + strafe - rotate);
    }

    @Override
    public void init() {
        super.init();

        this.start(
                hardwareMap.dcMotor.get("motorFL"),
                hardwareMap.dcMotor.get("motorFR"),
                hardwareMap.dcMotor.get("motorBL"),
                hardwareMap.dcMotor.get("motorBR")
        );
    }

    @Override
    public void loop() {
        super.loop();

        updateInput();
        updateMotors();
    }
}
