package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.ManualDrive;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.pedro.Constants;

public class PedroSubsystem extends SubsystemBase {
    Follower follower;

    public PedroSubsystem(HardwareMap hardwareMap) {
        this.follower = Constants.create(hardwareMap);
    }

    @Override
    public void periodic() {
        follower.update();
    }

    public Command fieldCentricCmd(Gamepad gamepad) {
        return new FieldCentricCmd(gamepad);
    }

    private class FieldCentricCmd extends CommandBase {

        Gamepad gamepad;

        FieldCentricCmd(Gamepad gamepad) {
            this.gamepad = gamepad;
            addRequirements(PedroSubsystem.this);
        }

        @Override
        public void execute() {
            DrivePowers powers = ManualDrive.fieldCentric(
                    -gamepad.left_stick_y,
                    gamepad.left_stick_x,
                    gamepad.right_stick_x,
                    follower.pose().heading()
            );
            follower.manual(powers);
            // relocalise button
            if (gamepad.startWasPressed()) {
                Pose cornerPose = new Pose(10.5, 10.5, Math.toRadians(90));
                // On the fly Pose creation, we dont recommend this for Autonomous. Only accepts radians for heading
                follower.setPose(cornerPose); // overrides our pose
            }
        }
    }

}
