package org.usfirst.team5951.robot.commands.crepe;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Crepe;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**Command that toggles the crepe (if the crepe is open, it closes and if it's closed, it opens)
 *
 */
public class ToggleCrepe extends InstantCommand {

	Crepe crepe;
    public ToggleCrepe() {
    	super();
    	crepe = Robot.crepe;
    	requires(crepe);
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	crepe.toggleCrepe();
    }

}