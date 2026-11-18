package org.firstinspires.ftc.teamcode.subsystems;

import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.panels.Panels;
import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.util.InterpLUT;

import org.firstinspires.ftc.teamcode.subsystems.LLSubsystem;

@Configurable
public class AndreaSubsystem extends SubsystemBase {


    /*POR SI ACASO RECUERDA HACER TODO DOUBLE, (kV, PIDF, targetVelocity,
    {serviria mucho cambiar los motores a polen y nectar}, todos los metodos y asi)*/

    DcMotorEx shooterLeftMotor;
    DcMotorEx shooterRightMotor;
    private final LLSubsystem llSb;

    ElapsedTime detectionTimer = new ElapsedTime();

    public static double kV = 0.00023;
    public static PIDFCoefficients coefficients = new PIDFCoefficients(0.0015, 0, 0, 0);

    private PIDFController pidfController = new PIDFController(coefficients);

    private double targetVelocity;


    public AndreaSubsystem(HardwareMap hMap, LLSubsystem llSb) {
        shooterRightMotor = hMap.get(DcMotorEx.class, "shooter1");
        shooterLeftMotor = hMap.get(DcMotorEx.class, "shooter2");

        shooterRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shooterLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        shooterLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.llSb = llSb;
    }

    @Override
    public void periodic() {

        pidfController.setCoefficients(coefficients);
        pidfController.setSetPoint(targetVelocity);

        //double output = pidfController.calculate(getCurrentVelocity()) + (kV * targetVelocity);

        shooterLeftMotor.setPower(kV * targetVelocity);
        shooterRightMotor.setPower(kV * targetVelocity);

        PanelsTelemetry.INSTANCE.getTelemetry().addData("Left/TargetVelocity", targetVelocity);
        PanelsTelemetry.INSTANCE.getTelemetry().addData("Right/TargetVelocity", targetVelocity);


        PanelsTelemetry.INSTANCE.getTelemetry().addData("Left/CurrentVelocity", getCurrentVelocity());
        PanelsTelemetry.INSTANCE.getTelemetry().addData("Right/CurrentVelocity", getCurrentVelocity());


        PanelsTelemetry.INSTANCE.getTelemetry().addData("shooterRpower", shooterRightMotor.getPower());
        PanelsTelemetry.INSTANCE.getTelemetry().addData("shooterLpower", shooterLeftMotor.getPower());



    }

    public void setTargetVelocity(double targetVelocity) {
        this.targetVelocity = targetVelocity;
    }


    public double getCurrentVelocity() {
        return -shooterLeftMotor.getVelocity();
    }

}
