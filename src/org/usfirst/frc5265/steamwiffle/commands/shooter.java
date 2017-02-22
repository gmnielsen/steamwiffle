package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;
import org.usfirst.frc5265.steamwiffle.subsystems.stagValues;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class shooter extends Command {
	public double sPower;

    public shooter(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.fuel);
    	sPower = power;
    	//setTimeout(time);
    }
    	

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.fuel.shoot(sPower);
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.fuel.shoot(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
