package org.firstinspires.ftc.teamcode.command.transfer;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.AlecSubsystem;

public class TransferInCmd extends CommandBase {

    AlecSubsystem subsystem;


    public TransferInCmd(AlecSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.transferIn();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.transferOff();
    }

}
