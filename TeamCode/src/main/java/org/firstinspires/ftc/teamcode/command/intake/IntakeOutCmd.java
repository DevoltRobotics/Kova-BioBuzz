package org.firstinspires.ftc.teamcode.command.intake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.NiconiconiiSubsystem;

public class IntakeOutCmd extends CommandBase {

    NiconiconiiSubsystem subsystem;

    public IntakeOutCmd(NiconiconiiSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.intakeOut();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.intakeStop();
    }

}
