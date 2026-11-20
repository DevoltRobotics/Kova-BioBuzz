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

    DcMotorEx shooterNectarMotor;
    DcMotorEx shooterPollenMotor;
    private final LLSubsystem llSb;

    ElapsedTime detectionTimer = new ElapsedTime();

    public static double nectarkV = 0.002;
    public static double pollenkV = 0.001;
    public static PIDFCoefficients pollenCoefficients = new PIDFCoefficients(0.0023, 0, 0, 0);
    public static PIDFCoefficients nectarCoefficients = new PIDFCoefficients(0.002, 0,0, 0);

    private PIDFController pollenpidfController = new PIDFController(pollenCoefficients);
    private PIDFController nectarpidfController = new PIDFController(nectarCoefficients);

    private double nectarTargetVelocity;
    private double pollenTargetVelocity;


    public AndreaSubsystem(HardwareMap hMap, LLSubsystem llSb) {
        shooterNectarMotor = hMap.get(DcMotorEx.class, "shooter1");
        shooterPollenMotor = hMap.get(DcMotorEx.class, "shooter2");

        shooterPollenMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shooterNectarMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        shooterNectarMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        shooterNectarMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterPollenMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.llSb = llSb;
    }

    @Override
    public void periodic() {

        nectarpidfController.setCoefficients(nectarCoefficients);
        nectarpidfController.setSetPoint(nectarTargetVelocity);

        pollenpidfController.setCoefficients(pollenCoefficients);
        pollenpidfController.setSetPoint(pollenTargetVelocity);


        double pollenOutput = pollenpidfController.calculate(getPollenCurrentVelocity()) + (pollenkV * pollenTargetVelocity);
        double nectarOutput = nectarpidfController.calculate(getNectarCurrentVelocity()) + (nectarkV * nectarTargetVelocity);


        shooterNectarMotor.setPower(nectarOutput);
        shooterPollenMotor.setPower(pollenOutput);

        PanelsTelemetry.INSTANCE.getTelemetry().addData("Nectar/TargetVelocity", nectarTargetVelocity);
        PanelsTelemetry.INSTANCE.getTelemetry().addData("Pollen/TargetVelocity", pollenTargetVelocity);


        PanelsTelemetry.INSTANCE.getTelemetry().addData("Nectar/CurrentVelocity", getNectarCurrentVelocity());
        PanelsTelemetry.INSTANCE.getTelemetry().addData("Pollen/CurrentVelocity", getPollenCurrentVelocity());


        PanelsTelemetry.INSTANCE.getTelemetry().addData("shooterRpower", shooterPollenMotor.getPower());
        PanelsTelemetry.INSTANCE.getTelemetry().addData("shooterLpower", shooterNectarMotor.getPower());



    }

    public void setNectarTargetVelocity(double nectarTargetVelocity) {
        this.nectarTargetVelocity = nectarTargetVelocity;
    }

    public void setPollenTargetVelocity(double pollenTargetVelocity) {
        this.pollenTargetVelocity = pollenTargetVelocity;
    }

    public double getNectarCurrentVelocity() {
        return shooterNectarMotor.getVelocity();
    }

    public double getPollenCurrentVelocity() {
        return shooterPollenMotor.getVelocity();
    }

}