package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Hardware;

//INTAKE
public class NiconiconiiSubsystem extends SubsystemBase {

    DcMotor intake;

    public NiconiconiiSubsystem(DcMotor intake) {
        this.intake = intake;
    }

    public void intakeIn() {
        intake.setPower(1);
    }

    public void intakeOut() {
        intake.setPower(-1);
    }

    public void intakeStop() {
        intake.setPower(0);
    }

}
