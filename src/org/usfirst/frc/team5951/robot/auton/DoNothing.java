package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.ShiftToStrongGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DoNothing extends CommandGroup {

    public DoNothing() {
    	addSequential(new ShiftToStrongGear());
    }
    
}
