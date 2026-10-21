package org.firstinspires.ftc.teamcode.command.intake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.NiconiconiiSubsystem;

public class IntakeInCmd extends CommandBase {

    NiconiconiiSubsystem subsystem;

    public IntakeInCmd(NiconiconiiSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.intakeIn();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.intakeStop();
    }

}
