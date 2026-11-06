package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.panels.Panels;
import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.button.Trigger;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Hardware;
import org.firstinspires.ftc.teamcode.command.intake.IntakeInCmd;
import org.firstinspires.ftc.teamcode.command.intake.IntakeOutCmd;
import org.firstinspires.ftc.teamcode.command.shooter.AndreaShootCmd;
import org.firstinspires.ftc.teamcode.command.transfer.TransferInCmd;
import org.firstinspires.ftc.teamcode.command.transfer.TransferOutCmd;



@TeleOp (name = "Test")
@Configurable
public class Test extends OpMode {

    private final Hardware robot = new Hardware();
    GamepadEx ines;
    GamepadEx dani;

    public static double shooterVelocity = 4000;

    @Override
    public void init() {
        robot.init(hardwareMap);

        ines = new GamepadEx(gamepad1);
        dani = new GamepadEx(gamepad2);

    }

    @Override
    public void start() {
        dani.getGamepadButton(GamepadKeys.Button.A)
                .whileHeld(new IntakeInCmd(robot.intakeSub))
                .whileHeld(new TransferInCmd(robot.transferSub));

        dani.getGamepadButton(GamepadKeys.Button.B)
                .whileHeld(new TransferOutCmd(robot.transferSub))
                .whileHeld(new IntakeOutCmd(robot.intakeSub));

        Trigger shooterShoot = new Trigger(() -> gamepad2.right_trigger_pressed);
        shooterShoot.whileActiveContinuous(new AndreaShootCmd(robot.shooterSub, shooterVelocity));
    }

    @Override
    public void loop() {
        CommandScheduler.getInstance().run();

        ines.readButtons();
        dani.readButtons();

        PanelsTelemetry.INSTANCE.getTelemetry().update();
    }

}
