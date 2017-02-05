package org.usfirst.frc.team5951.robot.commands.crepe;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Crepe;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command that closes the crepe
 */
public class CloseCrepe extends InstantCommand {
	Crepe crepe;

	public CloseCrepe() {
		super();
		crepe = Robot.crepe;
		requires(crepe);

	}

	protected void initialize() {
		crepe.closeCrepe();
	}

}
