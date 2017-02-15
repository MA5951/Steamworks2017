package org.usfirst.frc.team5951.robot.vision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionPipeline;

/**
 * General vision class for the robot. Uses OpenCV.
 * 
 * FIXME Tweek the values and logic for the vision. Test it out as well when able.
 * 
 * @author Yair Ziv
 * 
 */
public class VisionImplementation implements VisionPipeline {

	private Mat hslThresholdOP = new Mat();
	private Mat hslThresholdOPAfterBlur = new Mat();
	private Mat matToShow = new Mat();
	private ArrayList<MatOfPoint> findContourOP = new ArrayList<MatOfPoint>();
	private ArrayList<MatOfPoint> filterContourOP = new ArrayList<MatOfPoint>();
	private ArrayList<MatOfPoint> biggestContoursOP;

	int i = 0;

	private ArrayList<Rect> contoursAsRects;

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	private final double[] hslThresholdHue = { 63, 95 };
	private final double[] hslThresholdSat = { 142, 255 };
	private final double[] hslThresholdVal = { 55, 146 };

	public int centerX;
	public int centerY;

	@Override
	public void process(Mat image) {
		SmartDashboard.putNumber("Ran: ", i);
		Mat input = image;

		blurImage(input, input);
		normalizeImage(input, input);
		
		getHSVThresholdOutput(input, hslThresholdOP);
		Mat findContourInit = hslThresholdOPAfterBlur;

		findContours(findContourInit, true, findContourOP);
		ArrayList<MatOfPoint> filterContourInit = filterContourOP;

		biggestContoursOP = filterContours(filterContourInit, 2);
		
		contoursAsRects = contoursToRects(biggestContoursOP);

		addRectangleToPictureOnContours(image, contoursAsRects);

		SmartDashboard.putNumber("Ran: ", i);

	}

	/**
	 * Makes a threshold of the image
	 * 
	 * @param input
	 *            - Original image
	 * @param output
	 *            - Image the output will be set as
	 */
	public void getHSVThresholdOutput(Mat input, Mat output) {
		Imgproc.cvtColor(input, input, Imgproc.COLOR_BGR2HSV);
		Core.inRange(input, new Scalar(hslThresholdHue[0], hslThresholdSat[0], hslThresholdVal[0]), 
				new Scalar(hslThresholdHue[1], hslThresholdSat[1], hslThresholdVal[1]), output);
	}

	/**
	 * Finds the contours.
	 * 
	 * @param input
	 *            - original Mat.
	 * @param externalOnly
	 *            - external contours only or inside contours as well
	 * @param output
	 *            - Mat array to save the contours on.
	 */
	public void findContours(Mat input, boolean externalOnly, ArrayList<MatOfPoint> output) {
		Mat Hierarchy = new Mat();
		output.clear();
		int mode = externalOnly ? Imgproc.RETR_EXTERNAL : Imgproc.RETR_LIST;
		int method = Imgproc.CHAIN_APPROX_SIMPLE;
		Imgproc.findContours(input, output, Hierarchy, mode, method);
	}

	/**
	 * Filters the contours to find the largest
	 * 
	 * @param input
	 *            - original contour list
	 * @param numLargest
	 *            - How many largest contours do you want to save?
	 * @return - the biggest contour as a mat
	 */
	public ArrayList<MatOfPoint> filterContours(List<MatOfPoint> input, int numLargest) {
		ArrayList<MatOfPoint> largest = new ArrayList<>();
		ArrayList<MatOfPoint> sortedInput = sortByContourArea(input);
		for (int i = 0; i < numLargest; i++) {
			largest.set(i, sortedInput.get(i));
		}

		return largest;
	}

	/**
	 * Sorts a list of {@link MatOfPoint}s by their contour size.
	 * 
	 * @param input
	 *            - List of {@link MatOfPoint}s to be sorted
	 * @return A sorted list of contours by size.
	 */
	public ArrayList<MatOfPoint> sortByContourArea(List<MatOfPoint> input) {
		Collections.sort(input, Comparator.comparingDouble(Imgproc::contourArea));
		return (ArrayList<MatOfPoint>) input;
	}

	/**
	 * Converts the contours to {@link Rect}angle opencv objects
	 * 
	 * @param input
	 *            - Binary image of the contours
	 * @return - Contours as rectangles
	 */
	public ArrayList<Rect> contoursToRects(ArrayList<MatOfPoint> input) {
		ArrayList<Rect> contoursAsRects = new ArrayList<Rect>();
		for (int i = 0; i < input.size(); i++) {
			contoursAsRects.set(i, Imgproc.boundingRect(input.get(i)));
		}
		return contoursAsRects;
	}

	/**
	 * Median blurs the image to remove any noise.
	 * 
	 * @param input
	 *            - Original {@link Mat}
	 * @param output
	 *            - Output {@link Mat}
	 */
	public void blurImage(Mat input, Mat output) {
		Imgproc.medianBlur(input, output, 5);
	}
	
	
	/**
	 * Normalizes the picture, makers the picture more vibrant and uses the full spectrum of colors.
	 * @param input - 
	 * @param output
	 */
	private void normalizeImage(Mat input, Mat output) {
		Core.normalize(input, output, 0, 255, Core.NORM_MINMAX);
	}
	

	/**
	 * Returns the center x of the rectangular contour.
	 * 
	 * @param contour
	 *            - rectangular contour
	 * @return - centerX of the contour.
	 */
	public int findCenterX(Rect contour) {
		return contour.x + (contour.width / 2);
	}

	/**
	 * Returns the center y of the rectangular contour.
	 * 
	 * @param contour
	 *            - rectangular contour.
	 * @return - center Y of the contour.
	 */
	public int findCenterY(Rect contour) {
		return contour.y + (contour.height / 2);
	}

	/**
	 * Get the value of the centerX variable
	 * 
	 * @param numberFromTop
	 *            - <b>biggestContourOutput is sorted from biggest contour to
	 *            smallest</b> so this parameter basically asks what number from
	 *            biggest to lowest do you want?
	 * @return - value of the centerX variable
	 */
	public int getCenterX(int numberFromTop) {
		return this.findCenterX(this.contoursAsRects.get(numberFromTop - 1));
	}

	/**
	 * Get the value of the centerY variable.
	 * 
	 * @param numberFromTop
	 *            - <b>biggestContourOutput is sorted from biggest contour to
	 *            smallest</b> so this parameter basically asks what number from
	 *            biggest to lowest do you want?
	 * @return - Value of the centerY variable.
	 */
	public int getCenterY(int numberFromTop) {
		return this.findCenterY(this.contoursAsRects.get(numberFromTop - 1));
	}

	/**
	 * Draws a rectangle over all of the contours so that they will be visible.
	 * 
	 * @param originalPicture
	 *            - Original picture to draw on.
	 * @param rectangles
	 *            - Rectangle contours.
	 */
	public void addRectangleToPictureOnContours(Mat originalPicture, ArrayList<Rect> rectangles) {
		for (Rect rectangleToAdd : rectangles) {
			Imgproc.rectangle(originalPicture, new Point(rectangleToAdd.x, rectangleToAdd.y),
					new Point(rectangleToAdd.x + rectangleToAdd.width, rectangleToAdd.y + rectangleToAdd.height), new Scalar(255, 0, 0), 5);
		}
		this.matToShow = originalPicture;
	}

	/**
	 * This is a function that returns a mat after all of the processing.
	 * 
	 * @return
	 */
	public Mat getPicture() {
		return this.matToShow;
	}
	
	/**
	 * Returns the amount of contours found.
	 */
	public int getAmountContours(){
		return this.contoursAsRects.size();
	}
}
