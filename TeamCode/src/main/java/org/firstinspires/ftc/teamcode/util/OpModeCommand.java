package org.firstinspires.ftc.teamcode.util;

import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.command.Subsystem;

import org.firstinspires.ftc.teamcode.subsystems.AlecSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.AndreaSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LLSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.NiconiconiiSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PedroSubsystem;

import java.util.List;

public abstract class OpModeCommand extends OpMode {

    public NiconiconiiSubsystem intakeSubsystem;
    public AndreaSubsystem shooterSubsystem;
    public AlecSubsystem TransferSubsystem;
    public LLSubsystem llSubsystem;

   // public PedroSubsystem pedroSubsystem;

   // public final Alliance alliance;




    private List<Subsystem> subsystems;

  /*  public OpModeCommand(Alliance alliance) {
        this.alliance = alliance;
    }*/

    //corre el scheduler
    public void run() {
    }

    //programa comandos al scheduler
    public void schedule(Command... commands) {
        CommandScheduler.getInstance().schedule(commands);
    }

    @Override
    public void init() {
        CommandScheduler.getInstance().reset();

        subsystems = List.of(
                llSubsystem = new LLSubsystem(hardwareMap),
             //   pedroSubsystem = new PedroSubsystem(hardwareMap),
                intakeSubsystem = new NiconiconiiSubsystem(hardwareMap),
                shooterSubsystem = new AndreaSubsystem(hardwareMap,llSubsystem),
                TransferSubsystem = new AlecSubsystem(hardwareMap)
        );

        for(Subsystem subsystem : subsystems) {
            CommandScheduler.getInstance().registerSubsystem(subsystem);
        }

        CommandScheduler.getInstance().setBulkReading(hardwareMap, LynxModule.BulkCachingMode.MANUAL);

        initialize();
    }

    @Override
    public final void loop() {
        CommandScheduler.getInstance().run();
        PanelsTelemetry.INSTANCE.getTelemetry().update();
        run();



       /* TelemetryPacket packet = new TelemetryPacket();

        for(Subsystem subsystem : subsystems) {
            if(subsystem instanceof LoggedSubsystem) {
                ((LoggedSubsystem)subsystem).log(packet);
            }
        }*/

        //FtcDashboard.getInstance().sendTelemetryPacket(packet);

    }

    public abstract void initialize();




}
