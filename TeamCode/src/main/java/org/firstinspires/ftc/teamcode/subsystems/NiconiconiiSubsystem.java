package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.SubsystemBase;


//INTAKE
public class NiconiconiiSubsystem extends SubsystemBase {

    DcMotor intake;

    public NiconiconiiSubsystem(HardwareMap hMap) {
        intake = hMap.get(DcMotor.class, "intake");    }

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
