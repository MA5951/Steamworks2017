package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShortDrivingTest extends CommandGroup {

    public ShortDrivingTest() {
        addSequential(new DriveStraight(1));
        this.cancel();
    }
}
