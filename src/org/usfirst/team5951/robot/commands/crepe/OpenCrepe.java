package org.usfirst.team5951.robot.commands.crepe;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Crepe;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command that opens the crepe
 */
public class OpenCrepe extends InstantCommand {

    	Crepe crepe;
        public OpenCrepe() {
        	super();
        	crepe = Robot.crepe;
        	requires(crepe);
        	
            // Use requires() here to declare subsystem dependencies
            // eg. requires(chassis);
        }

        // Called once when the command executes
        protected void initialize() {
        	crepe.openCrepe();
        }
}