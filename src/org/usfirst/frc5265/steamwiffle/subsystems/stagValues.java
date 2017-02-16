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
	public static final double minimumMotionJoystick = 0.3;
<<<<<<< HEAD
	
// camera stuff
	public int camSession;
	public int camFrontNumb;
	public int camBackNumb;
	public String camFront = "cam0";
	public String camBack = "cam1";
	public String camAlt = "cam2";
	
=======
>>>>>>> master
	
    public void initDefaultCommand() {
        // This is where we put the above values to the SmartDashboard
    	// using SmartDashboard.put ...
    	
    	SmartDashboard.putNumber("minJoystickMotion", minimumMotionJoystick);

    }
}

