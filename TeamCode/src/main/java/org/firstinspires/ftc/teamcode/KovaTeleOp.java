package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Hardware;
import org.firstinspires.ftc.teamcode.command.intake.IntakeInCmd;
import org.firstinspires.ftc.teamcode.command.intake.IntakeOutCmd;


//MAIN CODE

@TeleOp(name = "KovaTeleOp")
public class KovaTeleOp extends OpMode {
    private final Hardware robot = new Hardware();

    GamepadEx gamepadEx1;
    GamepadEx gamepadEx2;

    @Override
    public void init() {
        gamepadEx1 = new GamepadEx(gamepad1);
        gamepadEx2 = new GamepadEx(gamepad2);
    }

    @Override
    public void start() {
        gamepadEx2.getGamepadButton(GamepadKeys.Button.A)
                .whileHeld(new IntakeInCmd(robot.intakeSub));

        gamepadEx2.getGamepadButton(GamepadKeys.Button.B)
                .whileHeld(new IntakeOutCmd(robot.intakeSub));

        // FIELD CENTRIC DRIVE
        robot.pedroSub.setDefaultCommand(robot.pedroSub.fieldCentricCmd(gamepad1));
    }

    @Override
    public void loop() {
        CommandScheduler.getInstance().run();

        gamepadEx1.readButtons();
        gamepadEx2.readButtons();
    }
}

