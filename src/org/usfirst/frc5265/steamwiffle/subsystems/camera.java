package org.usfirst.frc5265.steamwiffle.subsystems;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class camera extends Subsystem {
	// camera00 will be facing in the direction of the gear and the shooting
	// camera01 will be facing in the direction of the intake
	UsbCamera camera00, camera01;
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	
	// this creates camera00 in a new thread
	// a new thread means that this works in parallel to the rest of the robot
	public void cameraInit() {
	    // camera00 and camera01
		new Thread(() -> {
	        camera00 = CameraServer.getInstance().startAutomaticCapture(0);
	        camera00.setResolution(IMG_WIDTH, IMG_HEIGHT);
	        camera01 = CameraServer.getInstance().startAutomaticCapture(1);
	        camera01.setResolution(IMG_WIDTH, IMG_HEIGHT);
	        
	        
	        CvSink cvSink00 = CameraServer.getInstance().getVideo(camera00);
	        CvSource outputStream00 = CameraServer.getInstance().putVideo("Gear", IMG_WIDTH, IMG_HEIGHT);
	        
	        CvSink cvSink01 = CameraServer.getInstance().getVideo(camera01);
	        CvSource outputStream01 = CameraServer.getInstance().putVideo("Intake", IMG_WIDTH, IMG_HEIGHT);
	        
	        Mat source00 = new Mat();
	        Mat output00 = new Mat();
	        Mat source01 = new Mat();
	        Mat output01 = new Mat();
	        
	        while(!Thread.interrupted()) {
	            cvSink00.grabFrame(source00);
	            cvSink01.grabFrame(source01);
	            
	            Imgproc.cvtColor(source00, output00, Imgproc.COLOR_BGR2GRAY);
	            Imgproc.cvtColor(source01, output01, Imgproc.COLOR_BGR2GRAY);
	            
	            outputStream00.putFrame(output00);
	            outputStream01.putFrame(output01);
	        }
	    }).start();
		
	}
	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	cameraInit();
    }
}
