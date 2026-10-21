package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.pedropathing.follower.Follower;
import com.seattlesolvers.solverslib.command.CommandScheduler;

import org.firstinspires.ftc.teamcode.subsystems.NiconiconiiSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PedroSubsystem;

public class Hardware {


    //MOTORES PRINCIPALES
    public DcMotor transferMotor;
    public DcMotor intakeMotor;
    public DcMotor shooterMotor;
    public DcMotor shootwoMotor;

    //SERVOS

    // SUBSISTEMAS

    public PedroSubsystem pedroSub;
    public NiconiconiiSubsystem intakeSub;

    public void init(HardwareMap hardwareMap) {

        //MOTORES
        transferMotor = hardwareMap.get(DcMotor.class, "transfer");
        intakeMotor = hardwareMap.get(DcMotor.class, "intake");
        shooterMotor = hardwareMap.get(DcMotor.class, "shooter1");
        shootwoMotor = hardwareMap.get(DcMotor.class, "shooter2");

        shootwoMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        //SERVOS

        //SUBSYSTEMAS

        CommandScheduler.getInstance().registerSubsystem(
            pedroSub = new PedroSubsystem(hardwareMap),
            intakeSub = new NiconiconiiSubsystem(intakeMotor)
        );
    }

}
