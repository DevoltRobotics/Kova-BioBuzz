package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp (name = "IntakeTest")
public class IntakeTest extends OpMode {
    DcMotor intakeM;
    DcMotor transferM;

    @Override
    public void init() {

        intakeM = hardwareMap.dcMotor.get("intake");
        transferM = hardwareMap.dcMotor.get("transfer");

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {

        if(gamepad1.a) {
            intakeM.setPower(1);
            transferM.setPower(1);
        }else {
            intakeM.setPower(0);
            transferM.setPower(0);
        }

        if(gamepad1.b) {
            intakeM.setPower(-1);
            transferM.setPower(-1);
        }else {
            intakeM.setPower(0);
            transferM.setPower(0);
        }

    }

}
