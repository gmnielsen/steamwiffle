package org.usfirst.frc5265.steamwiffle.commands;

import java.util.concurrent.TimeoutException;

import org.usfirst.frc5265.steamwiffle.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class timeLift extends Command {
double pp;
    public timeLift(double power, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	pp = power;
    	setTimeout(time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.brushless.set(pp);
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
    	RobotMap.brushless.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
