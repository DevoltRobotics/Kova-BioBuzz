package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;


public class AndreaSubsystem extends SubsystemBase {

    DcMotorEx shooterLeftMotor;
    DcMotor shooterRightMotor;

    public static double kV = 0.005;

    private PIDFController pidfController = new PIDFController(new PIDFCoefficients(0, 0, 0, 0));

    private double targetVelocity;

    public AndreaSubsystem(DcMotor shooterLeft, DcMotor shooterRight) {
        this.shooterLeftMotor = (DcMotorEx) shooterLeft;
        this.shooterRightMotor = shooterRight;
    }

    @Override
    public void periodic() {
        pidfController.setSetPoint(targetVelocity);

        double output = pidfController.calculate(shooterLeftMotor.getVelocity()) + (kV * targetVelocity);

        shooterLeftMotor.setPower(output);
        shooterRightMotor.setPower(output);
    }

    public void setTargetVelocity(double targetVelocity) {
        this.targetVelocity = targetVelocity;
    }

}
