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
	

    public void initDefaultCommand() {
        // This is where we put the above values to the SmartDashboard
    	// using SmartDashboard.put ...
    	
    	SmartDashboard.putNumber("minJoystickMotion", minimumMotionJoystick);

    }
}

