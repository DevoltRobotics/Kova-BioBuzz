package org.firstinspires.ftc.teamcode.command.shooter;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.AlecSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.AndreaSubsystem;

public class AndreaShootCmd extends CommandBase {

    AndreaSubsystem subsystem;
    double pollenTargetVelocity;
    double nectarTargetVelcoity;

    public AndreaShootCmd(AndreaSubsystem subsystem, double pollenTargetVelocity, double nectarTargetVelocity) {
        this.subsystem = subsystem;
        this.pollenTargetVelocity = pollenTargetVelocity;
        this.nectarTargetVelcoity = nectarTargetVelocity;

        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.setPollenTargetVelocity(pollenTargetVelocity);
        subsystem.setNectarTargetVelocity(nectarTargetVelcoity);
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.setPollenTargetVelocity(0);
        subsystem.setNectarTargetVelocity(0);
    }

}