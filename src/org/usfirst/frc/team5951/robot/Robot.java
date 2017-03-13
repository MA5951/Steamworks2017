
package org.usfirst.frc.team5951.robot;

import org.opencv.core.Mat;
import org.usfirst.frc.team5951.robot.auton.DoNothing;
import org.usfirst.frc.team5951.robot.auton.DropGearsLeftPassAutoLine;
import org.usfirst.frc.team5951.robot.auton.DropGearsLeftShoot;
import org.usfirst.frc.team5951.robot.auton.DropGearsMiddleBlue;
import org.usfirst.frc.team5951.robot.auton.DropGearsMiddleRed;
import org.usfirst.frc.team5951.robot.auton.DropGearsRightPassAutoPregional;
import org.usfirst.frc.team5951.robot.auton.DropGearsRightShoot;
import org.usfirst.frc.team5951.robot.auton.PassAutoLine;
import org.usfirst.frc.team5951.robot.subsystems.Ascender;
import org.usfirst.frc.team5951.robot.subsystems.ChassisArcade;
import org.usfirst.frc.team5951.robot.subsystems.FloorGearsIntake;
import org.usfirst.frc.team5951.robot.subsystems.HPGearsSubsystem;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
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

	public static final Ascender ascender = new Ascender();
	public static final HPGearsSubsystem hpGearsSubsystem = new HPGearsSubsystem();
	public static final ChassisArcade chassisArcade = new ChassisArcade();
	public static final FloorGearsIntake floorGearsIntake = new FloorGearsIntake();

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
		autoChooser.addObject("Left peg, shoot low goal (blue)", new DropGearsLeftShoot());
		autoChooser.addObject("Right peg, pass auto", new DropGearsRightPassAutoPregional());
		autoChooser.addDefault("Right peg, shoot low goal (red)", new DropGearsRightShoot());
		autoChooser.addObject("Pass auto line", new PassAutoLine());
		autoChooser.addObject("Do nothing", new DoNothing());

		SmartDashboard.putData("Autonomous chooser: ", autoChooser);

		//Camera thread to toggle between 2 or more cameras.
		Thread t = new Thread(() -> {

			//Allow camera1 to get video
			boolean allowCam1 = false;
			
			//To make sure that we switch 1 camera at a time.
			boolean isButtonPressedLastIteration = false;

			//First USB camera
			UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
			camera1.setResolution(320, 240);
			camera1.setFPS(30);
			
			//Second USB camera
			UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
			camera2.setResolution(320, 240);
			camera2.setFPS(30);

			//Sinks for the cameras
			CvSink cvSink1 = CameraServer.getInstance().getVideo(camera1);
			CvSink cvSink2 = CameraServer.getInstance().getVideo(camera2);
			
			//Output stream
			CvSource outputStream = CameraServer.getInstance().putVideo("Switcher", 320, 240);

			//Image to output
			Mat image = new Mat();

			while (!Thread.interrupted()) {

				if (OI.k_DRIVER_JOYSTICK.getRawButton(7) && !isButtonPressedLastIteration) {
					allowCam1 = !allowCam1;
				}

				if (allowCam1) {
					cvSink2.setEnabled(false);
					cvSink1.setEnabled(true);
					cvSink1.grabFrame(image);
				} else {
					cvSink1.setEnabled(false);
					cvSink2.setEnabled(true);
					cvSink2.grabFrame(image);
				}

				outputStream.putFrame(image);
				
				isButtonPressedLastIteration = OI.k_DRIVER_JOYSTICK.getRawButton(7);
			}
			
			try {
				Thread.sleep((long) 0.05);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		t.start();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
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
		chassisArcade.setChassisMultiplyer(1);
		if (autoCommand != null) {
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
		chassisArcade.setChassisMultiplyer(1);
		if (autoCommand != null) {
			autoCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		// Starts the lift command after end-game starts.
		/*
		 * if(Timer.getMatchTime() >= 105){ new Lift(); }
		 */
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
