package org.usfirst.frc.team5951.robot.commands.gears.floorGearsIntake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.FloorGearsIntake;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ChangeToFloorIntakePosition extends InstantCommand {
	
	private FloorGearsIntake floorGearsIntake;

    public ChangeToFloorIntakePosition() {
    	floorGearsIntake = Robot.floorGearsIntake;        
    }

    // Called once when the command executes
    protected void initialize() {
    	floorGearsIntake.getToFloorIntakePosition();
    }

}
