package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.Phoenix.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class spinniesOn extends Command {

    public spinniesOn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	org.usfirst.frc5265.steamwiffle.Robot.fuel.on(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
org.usfirst.frc5265.steamwiffle.Robot.fuel.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
