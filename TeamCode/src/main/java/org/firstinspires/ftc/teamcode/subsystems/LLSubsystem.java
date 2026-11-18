package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;

public class LLSubsystem extends SubsystemBase {

    public Limelight3A limelight;

    public LLResult result;

    public LLSubsystem(HardwareMap hMap) {
        limelight = hMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(60);
        limelight.start();
        limelight.pipelineSwitch(0);
    }

    @Override
    public void periodic() {
        result = limelight.getLatestResult();
    }

    public Double getTA() {
        if (result != null && result.isValid() && !result.getFiducialResults().isEmpty()) {
            int id = result.getFiducialResults().get(0).getFiducialId();
        }
        return null;
    }

}




