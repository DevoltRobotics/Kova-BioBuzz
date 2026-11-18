package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

public abstract class KovaOpMode extends OpModeCommand {


    public GamepadEx ines;
    public GamepadEx dani;



    @Override
    public void initialize() {
        ines = new GamepadEx(gamepad1);
        dani = new GamepadEx(gamepad2);

        CommandScheduler.getInstance().reset();


    }

    @Override
    public void run() {


    }

}
