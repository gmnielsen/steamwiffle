package org.usfirst.frc5265.steamwiffle.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class stagValues extends Subsystem {

    // All the variables we want to be able to modify
	// during a match will go here,
	// and then be put on the dashboard
	
	// DRIVING
	public static final double minimumMotionJoystick = 0.3; // zero for calibration
	
	//Left Alliance Autonomous
	public static final double laa01dx = 0.5, laa01dy = 0.0, laa01dt = 0.0, laa01dtime = 5.0;
	public static final double laa02dx = 0.0, laa02dy = 0.5, laa02dt = 0.0, laa02dtime = 5.0;
	
	// Right Alliance Autonomous 
	public static final double raa01dx = -0.5, raa01dy = 0.0, raa01dt = 0.0, raa01dtime = 5.0;
	public static final double raa02dx = 0.0, raa02dy = -0.5, raa02dt = 0.0, raa02dtime = 5.0;
	
	// Center Alliance Autonomous
	public static final double caa01dx = 1.0, caa01dy = 0.0, caa01dt = 0.0, caa01dtime = 5.0;
	public static final double caa02dx = 0.0, caa02dy = -0.5, caa02dt = 0.2, caa02dtime = 5.0;
	public static final double caa03dx = 0.5, caa03dy = 0.5, caa03dt = 0.0, caa03dtime = 5.0;
	
	// test buttons
	public static final double testax = 0.25, testay = 0.0, testat = 0.0, testatime = 0.25;
	public static final double testax2 = 0.5, testay2 = 0.0, testat2 = 0.0, testatime2 = 0.25;
	public static final double testax3 = 0.75, testay3 = 0.0, testat3 = 0.0, testatime3 = 0.25;
	public static final double testax4 = 1.0, testay4 = 0.0, testat4 = 0.0, testatime4 = 0.25;
	
	public static final double testax5 = 0.25, testay5 = 0.0, testat5 = 0.0, testatime5 = 0.5;
	public static final double testax6 = 0.5, testay6 = 0.0, testat6 = 0.0, testatime6 = 0.5;
	public static final double testax7 = 0.75, testay7 = 0.0, testat7 = 0.0, testatime7 = 0.5;
	public static final double testax8 = 1.0, testay8 = 0.0, testat8 = 0.0, testatime8 = 0.5;
    
	public void initDefaultCommand() {
        // This is where we put the above values to the SmartDashboard
    	// using SmartDashboard.put ...
    	
    	SmartDashboard.putNumber("minJoystickMotion", minimumMotionJoystick);

    }
}

