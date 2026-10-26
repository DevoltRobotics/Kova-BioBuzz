package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.seattlesolvers.solverslib.command.SubsystemBase;

//TRANSFER
public class AlecSubsystem extends SubsystemBase {

    DcMotor transfer;


    public AlecSubsystem(DcMotor transfer) {

        this.transfer = transfer;

    }

    public void transferIn() {
        transfer.setPower(1);
    }

    public void transferOut() {
        transfer.setPower(-1);
    }

    public void transferOff() {
        transfer.setPower(0);
    }

}
