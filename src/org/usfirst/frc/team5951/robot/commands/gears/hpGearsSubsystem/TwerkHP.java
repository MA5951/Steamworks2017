package org.usfirst.frc.team5951.robot.commands.gears.hpGearsSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;
import util.WaitCommand;

/**
 *
 */
public class TwerkHP extends CommandGroup {

	public TwerkHP() {
		addSequential(new OpenGearsHP());
		addSequential(new WaitCommand(), 0.1);
		addSequential(new CloseGearsHP());
		addSequential(new WaitCommand(), 0.1);
		addSequential(new OpenGearsHP());
		addSequential(new WaitCommand(), 0.1);
		addSequential(new CloseGearsHP());
		addSequential(new WaitCommand(), 0.1);
		addSequential(new OpenGearsHP());
		addSequential(new WaitCommand(), 0.1);
		addSequential(new CloseGearsHP());
		addSequential(new WaitCommand(), 0.1);
		addSequential(new OpenGearsHP());
		addSequential(new WaitCommand(), 0.1);
		addSequential(new CloseGearsHP());
	}
}
