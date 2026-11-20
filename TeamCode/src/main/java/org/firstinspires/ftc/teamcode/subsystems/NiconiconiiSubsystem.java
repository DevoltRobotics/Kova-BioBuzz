package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.SubsystemBase;


//INTAKE
public class NiconiconiiSubsystem extends SubsystemBase {

    DcMotor intake;
    Servo flor;

    public NiconiconiiSubsystem(HardwareMap hMap) {
        intake = hMap.get(DcMotor.class, "intake");
        flor = hMap.get(Servo.class, "flor");
    }

    public void intakeIn() {
        intake.setPower(1);
    }

    public void florIn() {
        intake.setPower(1);
        flor.setPosition(0);
    }//HAY QUE AJUSTAR LAS POSICIONES DE LA FLOOOORRRR

    public void florGetOut() {
        flor.setPosition(0.5);
    }


    public void intakeOut() {
        intake.setPower(-1);
    }

    public void intakeStop() {
        intake.setPower(0);
    }

}
