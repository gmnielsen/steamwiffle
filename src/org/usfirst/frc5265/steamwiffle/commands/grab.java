package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.RobotMap;
import org.usfirst.frc5265.steamwiffle.subsystems.stagValues;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class grab extends Command {
boolean woo;
    public grab(boolean boo) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	woo = boo;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(RobotMap.pot.get() < stagValues.potCheck){
        	
        	if(woo){
        		RobotMap.airDoubleSolenoid1.set(DoubleSolenoid.Value.kForward);
        		stagValues.tog = false;
        		
        	}else{
        		RobotMap.airDoubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
        		stagValues.tog = true;
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
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
