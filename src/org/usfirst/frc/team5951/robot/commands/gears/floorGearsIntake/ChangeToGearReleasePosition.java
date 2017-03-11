package org.usfirst.frc.team5951.robot.commands.gears.floorGearsIntake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.FloorGearsIntake;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ChangeToGearReleasePosition extends InstantCommand {

	private FloorGearsIntake floorGearsIntake;
	
    public ChangeToGearReleasePosition() {
    	this.floorGearsIntake = Robot.floorGearsIntake;
    }

    // Called once when the command executes
    protected void initialize() {
    	this.floorGearsIntake.getToGearReleasePosition();
    }

}
