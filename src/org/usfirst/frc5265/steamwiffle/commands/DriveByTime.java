package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByTime extends Command {
	public double xx, yy, tt, time;
	

    public DriveByTime(double x, double y, double t, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	setTimeout(time);
    	xx = x;
    	yy = y;
    	tt = t;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.driveChassisSteering(xx, yy, tt);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.chassis.driveChassisSteering(x, y, t);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.driveChassisSteering(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
