package org.firstinspires.ftc.teamcode.subsystems;

import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.panels.Panels;
import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;

@Configurable
public class AndreaSubsystem extends SubsystemBase {

    DcMotorEx shooterLeftMotor;
    DcMotorEx shooterRightMotor;

    public static double kV = 0.00023;
    public static PIDFCoefficients coefficients = new PIDFCoefficients(0.0015, 0, 0, 0);

    private PIDFController pidfController = new PIDFController(coefficients);

    private double targetVelocity;

    public AndreaSubsystem(DcMotor shooterLeft, DcMotor shooterRight) {
        this.shooterLeftMotor = (DcMotorEx) shooterLeft;
        this.shooterRightMotor = (DcMotorEx) shooterRight;
    }

    @Override
    public void periodic() {
        pidfController.setCoefficients(coefficients);
        pidfController.setSetPoint(targetVelocity);

        double output = pidfController.calculate(getCurrentVelocity()) + (kV * targetVelocity);

        shooterLeftMotor.setPower(output);
        shooterRightMotor.setPower(output);

        PanelsTelemetry.INSTANCE.getTelemetry().addData("Shooter/TargetVelocity", targetVelocity);
        PanelsTelemetry.INSTANCE.getTelemetry().addData("Shooter/CurrentVelocity", getCurrentVelocity());
    }

    public void setTargetVelocity(double targetVelocity) {
        this.targetVelocity = targetVelocity;
    }

    public double getCurrentVelocity() {
        return -(shooterRightMotor.getVelocity() / 28.0) * 60.0;
    }

}
