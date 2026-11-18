package org.firstinspires.ftc.teamcode.command.transfer;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.AlecSubsystem;

public class TransferShootCmd extends CommandBase {

    AlecSubsystem subsystem;


    public TransferShootCmd(AlecSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.transferShoot();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.transferOff();
    }

}
