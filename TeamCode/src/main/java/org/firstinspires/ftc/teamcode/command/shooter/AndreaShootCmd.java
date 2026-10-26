package org.firstinspires.ftc.teamcode.command.shooter;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.AndreaSubsystem;

public class AndreaShootCmd extends CommandBase {

    AndreaSubsystem subsystem;
    double targetVelocity;

    public AndreaShootCmd(AndreaSubsystem subsystem, double targetVelocity) {
        this.subsystem = subsystem;
        this.targetVelocity = targetVelocity;

        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.setTargetVelocity(targetVelocity);
    }

}
