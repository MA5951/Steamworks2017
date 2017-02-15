
package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.auton.DoNothing;
import org.usfirst.frc.team5951.robot.auton.DropGearsLeft;
import org.usfirst.frc.team5951.robot.auton.DropGearsMiddleBlue;
import org.usfirst.frc.team5951.robot.auton.DropGearsMiddleRed;
import org.usfirst.frc.team5951.robot.auton.DropGearsRight;
import org.usfirst.frc.team5951.robot.auton.PassAutoLine;
import org.usfirst.frc.team5951.robot.commands.ascender.Lift;
import org.usfirst.frc.team5951.robot.subsystems.Ascender;
import org.usfirst.frc.team5951.robot.subsystems.ChassisArcade;
import org.usfirst.frc.team5951.robot.subsystems.Crepe;
import org.usfirst.frc.team5951.robot.subsystems.IntakeAndShooter;
import org.usfirst.frc.team5951.robot.vision.Camera;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final IntakeAndShooter intakeAndShooter = new IntakeAndShooter();
	public static final Ascender ascender = new Ascender();
	public static final Crepe crepe = new Crepe();
	public static final ChassisArcade chassisArcade = new ChassisArcade();

	public static final Compressor compressor = new Compressor(RobotMap.k_PCM);
	public static final Camera camera = new Camera();
	
	// Chooser
	public static final SendableChooser<CommandGroup> autoChooser = new SendableChooser<>();
	public static CommandGroup autoCommand;

	public static OI oi;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();

		autoChooser.addDefault("Middle peg, blue side", new DropGearsMiddleBlue());
		autoChooser.addObject("Middle peg, red side", new DropGearsMiddleRed());
		autoChooser.addObject("Left peg", new DropGearsLeft());
		autoChooser.addObject("Right peg", new DropGearsRight());
		autoChooser.addObject("Pass auto line only", new PassAutoLine());
		autoChooser.addObject("Do nothing", new DoNothing());

		SmartDashboard.putData("Auto to use: ", autoChooser);

		compressor.start();
		compressor.setClosedLoopControl(true);

		camera.run();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autoCommand = (CommandGroup) autoChooser.getSelected();
		autoCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

		if (Timer.getMatchTime() > 15)
			if (autoCommand != null) {
				autoCommand.cancel();
			}
	}

	@Override
	public void teleopInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		// Starts the lift command after end-game starts.
		if (Timer.getMatchTime() >= 105) {
			new Lift();
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
