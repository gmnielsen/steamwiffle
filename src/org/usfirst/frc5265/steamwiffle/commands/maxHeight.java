package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.RobotMap;
import org.usfirst.frc5265.steamwiffle.subsystems.stagValues;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class maxHeight extends Command {

    public maxHeight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
if (RobotMap.pot.get() > .24){
    		
    		RobotMap.planB.set(stagValues.armPower);
    	}else RobotMap.planB.set(-stagValues.armPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (RobotMap.pot.get() > .23 && RobotMap.pot.get() < .25);
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.planB.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
