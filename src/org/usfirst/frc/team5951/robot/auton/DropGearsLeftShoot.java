package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.ShiftToStrongGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DropGearsLeftShoot extends CommandGroup {

    public DropGearsLeftShoot() {
    	addSequential(new ShiftToStrongGear());
    }
}
