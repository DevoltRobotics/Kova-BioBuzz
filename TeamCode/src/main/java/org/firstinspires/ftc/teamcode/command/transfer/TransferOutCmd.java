package org.firstinspires.ftc.teamcode.command.transfer;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.AlecSubsystem;

public class TransferOutCmd extends CommandBase {

    AlecSubsystem subsystem;


    public TransferOutCmd(AlecSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.transferOut();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.transferOff();
    }

}
