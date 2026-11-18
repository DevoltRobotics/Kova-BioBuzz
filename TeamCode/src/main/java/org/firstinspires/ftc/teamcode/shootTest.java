package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class shootTest extends OpMode {

    DcMotorEx shooter;
    DcMotorEx shooter2;


    @Override
    public void init() {
        shooter2 = hardwareMap.get(DcMotorEx.class, "shooter2");
        shooter = hardwareMap.get(DcMotorEx.class, "shooter1");
    }

    @Override
    public void loop() {

        if(gamepad1.x) {
            shooter2.setVelocity(1200);
            shooter.setVelocity(1200);
        }else {
            shooter.setVelocity(0);
            shooter2.setVelocity(0);
        }

    }
}
