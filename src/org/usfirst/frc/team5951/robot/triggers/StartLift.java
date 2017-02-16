package org.usfirst.frc.team5951.robot.triggers;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class StartLift extends Trigger {

    public boolean get() {
        return Timer.getFPGATimestamp() > 105;
    }
}
