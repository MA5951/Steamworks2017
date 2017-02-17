package org.usfirst.frc.team5951.robot.commands.crepe;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Crepe;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command that opens the crepe
 */
public class OpenCrepe extends InstantCommand {

    	Crepe crepe;
        public OpenCrepe() {
        	crepe = Robot.crepe;
        	requires(crepe);
        }

        // Called once when the command executes
        protected void initialize() {
        	crepe.openCrepe();
        }
}