package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This is the default command for the subsystem 'chassis' and allows driving properly from the joystick
 */
public class driveCommandSteer extends Command {

	// variables for the raw data from the joystick
	public double x, y, t;
	
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
    	// load the variables from the joystick
    	x = Robot.oi.getXSteer();
    	y = Robot.oi.getYSteer();
    	t = Robot.oi.getTwistSteer();
    	
    	// if we want to modify these variables, we modify them here
    	
    	// removes small motions of the joystick by discounting any value below a minimum
    	// WE MAY WANT TO PUT THIS VARIABLE IN THE GLOBAL TABLE OF VALUES FOR EASY MODIFICATION
    	double minMotion = 0.2;
    	// expands remaining range of motion so that motors start at a value of 0 
    	// and not at the minimum of the joystick
    	double expMotion = 1 / (1 - minMotion);
    	
    	// x modification
    	if (Math.abs(x) <= minMotion) { // x can be both positive and negative
    		x = 0;
    	}
    	else {
    		x = expMotion * (x - minMotion*Math.abs(x)/x); // abs(x)/x changes the sign of minMotion
    	}
    	
    	// y modification
    	if (Math.abs(y) <= minMotion) { // y can be both positive and negative
    		y = 0;
    	}
    	else {
    		y = expMotion * (y - minMotion*Math.abs(y)/y); // abs(y)/y changes the sign of minMotion
    	}
    	
    	// t modification
    	if (Math.abs(t) <= minMotion) { // t can be both positive and negative
    		t = 0;
    	}
    	else {
    		t = expMotion * (t - minMotion*Math.abs(t)/t); // abs(t)/t changes the sign of minMotion
    	}
    	    	
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
    }
}
