
package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.auton.DoNothing;
import org.usfirst.frc.team5951.robot.auton.DropGearsLeftPassAutoLine;
import org.usfirst.frc.team5951.robot.auton.DropGearsLeftShoot;
import org.usfirst.frc.team5951.robot.auton.DropGearsMiddleBlue;
import org.usfirst.frc.team5951.robot.auton.DropGearsMiddleRed;
import org.usfirst.frc.team5951.robot.auton.DropGearsRightPassAutoLine;
import org.usfirst.frc.team5951.robot.auton.DropGearsRightShoot;
import org.usfirst.frc.team5951.robot.auton.PassAutoLine;
import org.usfirst.frc.team5951.robot.commands.crepe.CloseCrepe;
import org.usfirst.frc.team5951.robot.subsystems.Ascender;
import org.usfirst.frc.team5951.robot.subsystems.ChassisArcade;
import org.usfirst.frc.team5951.robot.subsystems.Crepe;
import org.usfirst.frc.team5951.robot.subsystems.IntakeAndShooter;

import edu.wpi.first.wpilibj.IterativeRobot;
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
	
	public CommandGroup autoCommand;
	
	public static OI oi;
	
	public SendableChooser<CommandGroup> autoChooser;
	
	public boolean hadAuto = false;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		chassisArcade.calibrateGyro();
		
		autoChooser = new SendableChooser<>();
		autoChooser.addDefault("Middle peg, blue alliance", new DropGearsMiddleBlue());
		autoChooser.addObject("Middle peg, red alliance", new DropGearsMiddleRed());
		autoChooser.addObject("Left peg, pass auto", new DropGearsLeftPassAutoLine());
		autoChooser.addObject("Left peg, shoot low goal", new DropGearsLeftShoot());
		autoChooser.addObject("Right peg, pass auto", new DropGearsRightPassAutoLine());
		autoChooser.addDefault("Right peg, shoot low goal", new DropGearsRightShoot());
		autoChooser.addObject("Pass auto line", new PassAutoLine());
		autoChooser.addObject("Do nothing", new DoNothing());
		
		SmartDashboard.putData("Autonomous chooser: ", autoChooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
//		new ShiftToFastGear();
		new CloseCrepe();
		Scheduler.getInstance().removeAll();
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
		if(autoCommand != null){
			autoCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if(autoCommand != null){
			autoCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		//Starts the lift command after end-game starts.
		/*if(Timer.getMatchTime() >= 105){
			new Lift();
		}*/
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
