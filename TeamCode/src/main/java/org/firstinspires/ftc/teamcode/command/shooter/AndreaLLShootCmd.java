package org.firstinspires.ftc.teamcode.command.shooter;

import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.util.InterpLUT;

import org.firstinspires.ftc.teamcode.subsystems.AlecSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.AndreaSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LLSubsystem;

public class AndreaLLShootCmd extends CommandBase {

    AndreaSubsystem subsystem;
    LLSubsystem llSubsystem;
    AlecSubsystem transSubsystem;

    static InterpLUT lut = new InterpLUT();

    static  {
        lut.add(0, 1600);
        lut.add(0.25, 1450);
        lut.add(0.42, 1400);
        lut.add(0.72, 1250);
        lut.add(3.2, 1050);
        lut.add(6, 1100);



        lut.createLUT();
    }; //AHORITA AJUSTAR ESTA TABLAAA (tA imput, shooterVel output)

    public AndreaLLShootCmd(AndreaSubsystem subsystem, LLSubsystem llSubsystem, AlecSubsystem transSubsystem) {
        this.subsystem = subsystem;
        this.llSubsystem = llSubsystem;
        this.transSubsystem = transSubsystem;


        addRequirements(subsystem);
    }

    @Override
    public void execute() {

        if (llSubsystem.getTA() != null) {
            subsystem.setPollenTargetVelocity(lut.get(llSubsystem.getTA()));
            subsystem.setNectarTargetVelocity(lut.get(llSubsystem.getTA()));
            transSubsystem.transferShoot();
        }

    }

    @Override
    public void end(boolean interrupted) {
        subsystem.setPollenTargetVelocity(0);
        subsystem.setNectarTargetVelocity(0);
    }

}