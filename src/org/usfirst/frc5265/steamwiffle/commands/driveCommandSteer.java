package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;
import org.usfirst.frc5265.steamwiffle.subsystems.*;
import org.usfirst.frc5265.steamwiffle.Xbox;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID.*;


/**
 * This is the default command for the subsystem 'chassis' and allows driving properly from the joystick
 */
public class driveCommandSteer extends Command {
 
	static double x;
	static double y;
	static double t;
	
    public driveCommandSteer() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	
    	double f = 1.0;
    	double voltage = DriverStation.getInstance().getBatteryVoltage();
    	// variables for the raw data from the joystick
    	double throttle, minMotion;
    	
    	// load the variables from the joystick
    	x = Robot.oi.getX(Hand.kLeft);
    	y = Robot.oi.getY(Hand.kLeft);
    	t = Robot.oi.getX(Hand.kRight);
    	//throttle = Robot.oi.getThrottle();
    	//	minMotion = SmartDashboard.getNumber("minimumMotionJoystick", 0.0);
    	minMotion = stagValues.minimumMotionJoystick;
    	double pwr = 2.0;
    	
    	// if we want to modify these variables, wgge modify them here
    	
    	//the tester
    	if(voltage < 7.5){
    		f = .75;
    		SmartDashboard.putDouble("f", f);
    	}
    	else{
    		f = 1.0;
    	}
    	// Incorporating throttle 
    	//throttle = ((-throttle + 1)/2);
    	//throttle = (throttle * f);
    	//SmartDashboard.putDouble("throttle", throttle);
        	// x modification
    	if (Math.abs(x) <= minMotion) { // x can be both positive and negative
    		x = 0;
    	}
    	else {
    		//x = Math.pow(x, pwr) * Math.abs(x)/x; // sqr of value gets better control at low speed
    		x = x; //* throttle;
    		}
		
    
    	// y modification
    	if (Math.abs(y) <= minMotion) { // y can be both positive and negative
    		y = 0;
    	}
    	else {
    		//y = Math.pow(y, pwr) * Math.abs(y)/y; // sqr of value gets better control at low speed
    		y = y; //* throttle;
    		}
		
    	// t modification
    	if (Math.abs(t) <= minMotion) { // t can be both positive and negative
    		t = 0;
    	}
    	else {
    		t = Math.pow(t, pwr) * Math.abs(t)/t; // sqr of value gets better control at low speed
    		t = t; //* throttle;
    	}
		
    	
		// EVALUATION TEST
		/*
		SmartDashboard.putNumber("DB/Slider 0", x);
		SmartDashboard.putNumber("DB/Slider 1", y);
		SmartDashboard.putNumber("DB/Slider 2", t);
		SmartDashboard.putNumber("DB/Slider 3", throttle);
    	*/
		
    	/* THIS CODE MARKED FOR DELETION BECAUSE SQR OF X,Y AND T VALUES GIVES SIMILAR CONTROL TO IGNORING
    	 * ANYTHING BELOW MINIMUM MOTION
    	
    	// x modification
    	if (Math.abs(x) <= minMotion) { // x can be both positive and negative
    		x = 0;
    	}
    	else {
    		// x = expMotion * (x - minMotion*Math.abs(x)/x); // abs(x)/x changes the sign of minMotion
    		x = Math.pow(x, 2) * Math.abs(x)/x; // sqr of value gets better control at low speed
    		x = x * throttle;
    	}
    	
    	// y modification
    	if (Math.abs(y) <= minMotion) { // y can be both positive and negative
    		y = 0;
    	}
    	else {
    		// y = expMotion * (y - minMotion*Math.abs(y)/y); // abs(y)/y changes the sign of minMotion
    		y = Math.pow(y, 2) * Math.abs(y)/y; // sqr of value gets better control at low speed
    		y = y* throttle;
    	}
    	
    	// t modification
    	if (Math.abs(t) <= minMotion) { // t can be both positive and negative
    		t = 0;
    	}
    	else {
    		// t = expMotion * (t - minMotion*Math.abs(t)/t); // abs(t)/t changes the sign of minMotion
    		t = Math.pow(t, 2) * Math.abs(t)/t; // sqr of value gets better control at low speed
    		t = t * throttle;
    	}
    	*/
    	
    	    	
    	// steer using those variables
    	Robot.chassis.driveChassisSteering(x, y, t);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
