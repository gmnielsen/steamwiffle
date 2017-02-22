package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AgitateCommand extends Command {
	public double aPower;
    public AgitateCommand(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.air);
    	aPower = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.air.agitate(aPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.air.agitate(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
