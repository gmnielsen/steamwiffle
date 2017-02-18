package org.usfirst.frc5265.steamwiffle.subsystems;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc5265.steamwiffle.RobotMap;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class camera extends Subsystem {
	public void cameraInit() {
	    
	    RobotMap.init();
	    new Thread(() -> {
	        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
	        camera.setResolution(640, 480);
	        
	        CvSink cvSink = CameraServer.getInstance().getVideo();
	        CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
	        
	        Mat source = new Mat();
	        Mat output = new Mat();
	        
	        while(!Thread.interrupted()) {
	            cvSink.grabFrame(source);
	            Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
	            outputStream.putFrame(output);
	        }
	    }).start();
	}
	
	
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	private VisionThread visionThread;
	private double centerX = 0.0;
	private RobotDrive drive;
	
	private final Object imgLock = new Object();
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
