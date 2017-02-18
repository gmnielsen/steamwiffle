package org.usfirst.frc5265.steamwiffle.subsystems;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc5265.steamwiffle.RobotMap;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class camera extends Subsystem {
	public void cameraInit() {
	    
	    //RobotMap.init();
	    new Thread(() -> {
	        UsbCamera camera0 = new UsbCamera("camera0", 0);
	        //UsbCamera camera1 = new UsbCamera("camera1", 0);
	        
	        MjpegServer mjpegCamera0 = new MjpegServer("serve_camera0", 1181);
	        //MjpegServer mjpegCamera1 = new MjpegServer("serve_camera1", 1181);
	        
	        mjpegCamera0.setSource(camera0);
	        CvSink cvSinkcamera0 = new CvSink("opencv_camera0");
	        cvSinkcamera0.setSource(camera0);
	        
	        //mjpegCamera1.setSource(camera1);
	        //CvSink cvSinkcamera1 = new CvSink("opencv_camera1");
	        //cvSinkcamera1.setSource(camera1);
	        
	        
	        
	        //UsbCamera camera0 = CameraServer.getInstance().startAutomaticCapture();
	        //UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture();

	        //camera0.setResolution(640, 480);
	        //camera1.setResolution(640, 480);
	        
	        //CvSink cvSink = CameraServer.getInstance().getVideo();
	        //cvSinkcamera0.setSource(camera0);
	        //CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
	        
	        CvSource outputStream0 = new CvSource("Blur0", PixelFormat.kMJPEG, 640, 480,30);
	        //CvSource outputStream1 = new CvSource("Blur1", PixelFormat.kMJPEG, 640, 480,30);
	        
	        MjpegServer mjpegServer2 = new MjpegServer("serve_Blur0", 1182);
	        mjpegServer2.setSource(outputStream0);
	        
	        
	        /*
	        Mat source = new Mat();
	        Mat output = new Mat();
	        
	        while(!Thread.interrupted()) {
	            cvSinkcamera0.grabFrame(source);
	            Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
	            outputStream0.putFrame(output);
	        }
	        */
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
    	cameraInit();
    }
}
