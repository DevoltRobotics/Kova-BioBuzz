package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;

//TRANSFER
public class AlecSubsystem extends SubsystemBase {

    DcMotor transfer;
    Servo parabolas;


    public AlecSubsystem(HardwareMap hMap) {
        transfer = hMap.get(DcMotor.class, "transfer");
        parabolas = hMap.get(Servo.class, "paraB");

        transfer.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void transferIn() {
        transfer.setPower(-1);
        parabolas.setPosition(0.5); //close
    }

    public void transferOut() {
        transfer.setPower(1);
        parabolas.setPosition(0.9); //open
    }

    public void transferShoot() {
        transfer.setPower(-0.4);
        parabolas.setPosition(0.9); //open
    }

    public void transferOff() {
        transfer.setPower(0);
    }

}
