package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.ChassisArcade;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ToggleShifters extends InstantCommand {

	ChassisArcade chassisArcade;
	
    public ToggleShifters() {
        super();
        chassisArcade = Robot.chassisArcade;
    }

    // Called once when the command executes
    protected void initialize() {
    	this.chassisArcade.toggleShifters();
    }

}
