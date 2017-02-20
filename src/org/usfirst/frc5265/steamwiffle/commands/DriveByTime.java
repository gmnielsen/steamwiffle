package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveByTime extends Command {
	// these variables are used throughout this command
	public double xx,yy,tt;
	
    public DriveByTime(double x, double y, double t, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	// x, y, t, and time are only local to this method
    	setTimeout(time);
    	// put the values for x, y and t into their public counterparts
    	xx = x;
    	yy = y;
    	tt = t;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// move according to the given values
    	Robot.chassis.driveChassisSteering(xx, yy, tt);

    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	// stop moving
    	Robot.chassis.driveChassisSteering(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
