package org.usfirst.frc.team5951.robot.vision;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team5951.robot.OI;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Camera implements Runnable {

	// Used to switch between back and front camera
	private boolean allowCamFront;
	
	// Used to determine whether to process the image or show it as is. 
	private boolean isAuto;

	// USB Cameras
	private UsbCamera shooterSideCamera;
	private UsbCamera crepeSideCamera;

	// CVSinks and sources
	private CvSink cvSinkShooterSide;
	public CvSink cvSinkCrepeSide;
	private CvSource output;
	
	// Our vision code runner
	private VisionImplementation vi;

	Mat outputImage;

	public Camera() {
		// Inits
		allowCamFront = false;

		shooterSideCamera = CameraServer.getInstance().startAutomaticCapture(0);
		shooterSideCamera.setExposureManual(30);
		shooterSideCamera.setWhiteBalanceManual(30);
		shooterSideCamera.setBrightness(30);
		
		crepeSideCamera = CameraServer.getInstance().startAutomaticCapture(1);
		crepeSideCamera.setExposureManual(30);
		crepeSideCamera.setWhiteBalanceManual(30);
		crepeSideCamera.setBrightness(30);

		cvSinkShooterSide = CameraServer.getInstance().getVideo(shooterSideCamera);
		cvSinkCrepeSide = CameraServer.getInstance().getVideo(crepeSideCamera);

		output = CameraServer.getInstance().putVideo("Output: ", 320, 240);

		outputImage = new Mat();
		
		vi = new VisionImplementation();
	}
	
	/**
	 * Runs the camera at a unique thread
	 */
	@Override
	public void run() {
		if (OI.k_DRIVER_JOYSTICK.getRawButton(12)) {
			allowCamFront = !allowCamFront;
		}

		if (allowCamFront) {
			cvSinkShooterSide.setEnabled(true);
			cvSinkCrepeSide.setEnabled(false);
			cvSinkShooterSide.grabFrame(outputImage);
		}
		
		if(!allowCamFront){
			cvSinkShooterSide.setEnabled(false);
			cvSinkCrepeSide.setEnabled(true);
			cvSinkCrepeSide.grabFrame(outputImage);
		}
		
		if(isAuto){
			vi.process(outputImage);
			outputImage = vi.getPicture();
		}
		
		Imgproc.line(outputImage, new Point(160, 0), new Point(160, 240), new Scalar(0, 0, 255));
		
		output.putFrame(outputImage);
	}
	
	/**
	 * Sets isAuto to wanted value
	 * @param isAuto - Wanted value for isAuto
	 */
	public void setAuto(boolean isAuto){
		this.isAuto = isAuto;
	}

}
