package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5265.steamwiffle.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc5265.steamwiffle.subsystems.*;
import org.usfirst.frc5265.steamwiffle.Robot;
import org.usfirst.frc5265.steamwiffle.RobotMap;
import org.usfirst.frc5265.steamwiffle.commands.Lights;
/**
 *
 */
public class blinkerButton extends Command {
	public static boolean blinkerState;
	public static boolean blinkerState1;
	public blinkerButton() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lights);
    }

    // Called just before this Command runs the first time
    @SuppressWarnings("deprecation")
	protected void initialize() {
    	SmartDashboard.getBoolean("blinkerState");
    	// test sd for tru
    	// if true, start loop, and abort false
    	// if false, don't call loop, abort is true
    	
    	if (blinkerState){
    		Robot.lights.blinkAbort = false;
    		Robot.lights.BLINK();
    		SmartDashboard.putBoolean("blinkerState", false);
    	}
    		else{ 
    			Robot.lights.blinkAbort = true;
    			SmartDashboard.putBoolean("blinkerState", true);
    		}
    		
    	
    	//Robot.lights.blinkerToggle();
    	//Robot.lights.blinkAbort = true;
    	
    	 //new Lights();
    	
    	
    	
     	//return blinkerState;
    }

    
 	/* public static boolean blinkerToggle() {
 		boolean blinkerState = SmartDashboard.getBoolean("blinkerState",true);
     	blinkerState = !blinkerState;
     	SmartDashboard.putBoolean("blinkerState",blinkerState);	
     	return blinkerState;
     	
 	 }
*/
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	      	
    	
    	
    	// Robot.lights.BLINK();
    /*	blinkerState1 = SmartDashboard.getBoolean("blinkerState");
    	 
    	SmartDashboard.putBoolean("blinkerstate2", blinkerState1);
    	while (blinkerState1 == true) {
      	  Robot.lights.blinker.set(.5);
            Timer.delay(3);
            Robot.lights.blinker.set(0);
            Timer.delay(3);    	
            //blinkerState = SmartDashboard.getBoolean("blinkerState");
          //  SmartDashboard.putString("DB/String 0",String.valueOf(Robot.lights.blinker.get())); 
            blinkerState = SmartDashboard.getBoolean("blinkerState");
            blinkerState1 = blinkerState;
            blinkerState1 = !blinkerState1;
            SmartDashboard.putBoolean("brushState1 after loop", blinkerState1);
            SmartDashboard.putBoolean("brushState after loop", blinkerState);
            
    	}
    	Robot.lights.blinker.set(0);
    	end();
    //	Robot.lights.blinkerToggle();
    	*/
    	
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
    	end();
    }
}