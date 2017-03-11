package org.usfirst.frc.team5951.robot.commands.gears.floorGearsIntake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.FloorGearsIntake;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ToggleFloorIntakePosition extends InstantCommand {

	FloorGearsIntake floorGearsIntake;
	
    public ToggleFloorIntakePosition() {
        this.floorGearsIntake = Robot.floorGearsIntake; 
    }

    // Called once when the command executes
    protected void initialize() {
    	if(this.floorGearsIntake.isUp){
    		this.floorGearsIntake.getToFloorIntakePosition();
    	} else {
    		this.floorGearsIntake.getToGearReleasePosition();
    	}
    }

}
