package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class arm extends Command {
    public arm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(RobotMap.pot.get() >.1 ){
        	while(RobotMap.pot.get() >.1 ){
            	
            	
            	RobotMap.arm.set(.25);
        	}
    	}else{
        	
        	
        	while(RobotMap.pot.get() <.1 ){
        		
        			
        			RobotMap.arm.set(-.25);
        	}
    	}
        	
        }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }    	

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
		RobotMap.arm.set(0);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
