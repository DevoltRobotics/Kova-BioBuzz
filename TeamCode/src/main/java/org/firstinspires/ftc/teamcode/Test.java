package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.button.Trigger;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.command.intake.FlorGetOutCmd;
import org.firstinspires.ftc.teamcode.command.intake.FlorInCmd;
import org.firstinspires.ftc.teamcode.command.intake.IntakeInCmd;
import org.firstinspires.ftc.teamcode.command.intake.IntakeOutCmd;
import org.firstinspires.ftc.teamcode.command.shooter.AndreaLLShootCmd;
import org.firstinspires.ftc.teamcode.command.shooter.AndreaShootCmd;
import org.firstinspires.ftc.teamcode.command.transfer.TransferInCmd;
import org.firstinspires.ftc.teamcode.command.transfer.TransferOutCmd;
import org.firstinspires.ftc.teamcode.util.KovaOpMode;
import org.firstinspires.ftc.teamcode.util.OpModeCommand;

@TeleOp(name = "Test")
@Configurable
public class Test extends OpModeCommand {
    public GamepadEx ines;
    public GamepadEx dani;

    public static double pollenTargetVelocity = 2600;
    public static double nectarTargetVelocity = 2600;

    public Test(){

    }

    @Override
    public void initialize() {
        dani = new GamepadEx(gamepad2);
        ines = new GamepadEx(gamepad1);
        Trigger shooterShoot = new Trigger(() -> gamepad2.right_trigger > 0.3);
        Trigger shooterLLShoot = new Trigger(() -> gamepad2.left_trigger > 0.3);



        dani.getGamepadButton(GamepadKeys.Button.A)
                .whileHeld(new IntakeInCmd(intakeSubsystem))
                .whileHeld(new TransferInCmd(TransferSubsystem));

        dani.getGamepadButton(GamepadKeys.Button.B)
                .whileHeld(new TransferOutCmd(TransferSubsystem))
                .whileHeld(new IntakeOutCmd(intakeSubsystem));

        dani.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT)
                .whileHeld(new FlorInCmd(intakeSubsystem));
        dani.getGamepadButton(GamepadKeys.Button.DPAD_LEFT)
                .whileHeld(new FlorGetOutCmd(intakeSubsystem));


        shooterShoot.whileActiveContinuous(new AndreaShootCmd(shooterSubsystem, pollenTargetVelocity, nectarTargetVelocity));

        shooterLLShoot.whileActiveContinuous(new AndreaLLShootCmd(shooterSubsystem, llSubsystem, TransferSubsystem));
    }

    @Override
    public void start() {
        // Se puede dejar vacío o incluir acciones exclusivas del inicio de la partida


    }
}