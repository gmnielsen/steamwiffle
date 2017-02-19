package org.usfirst.frc5265.steamwiffle.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc5265.steamwiffle.subsystems.*;
import org.usfirst.frc5265.steamwiffle.Robot;
import org.usfirst.frc5265.steamwiffle.RobotMap;

/**
 *
 */
public class Lights extends Command {
	//private static final SpeedController blinker = RobotMap.blinker;
	boolean blinkerState1 = false;
    
	public Lights() {
    	//requires(Robot.camera);
    	requires(Robot.lights);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    @SuppressWarnings("deprecation")
	protected void initialize() {
    	//Timer.delay(1);
    	blinkerState1 = SmartDashboard.getBoolean("blinkerState");
    	//SmartDashboard.putBoolean("blinkerState1", blinkerState1);
    	if (!blinkerState1) {
    		end();
    	}
    	
    	// test brushstate and either turn the brush motor on or off
    	
    	}
    
    	
/*    public static boolean blinkerToggle() {
       		boolean blinkerState = SmartDashboard.getBoolean("blinkerState",true);
           	blinkerState = !blinkerState;
           	SmartDashboard.putBoolean("blinkerState",blinkerState);	
           	return blinkerState;
    
	}
*/
    // Called repeatedly when this Command is scheduled to run
    @SuppressWarnings("deprecation")
	protected void execute() {
    	
    	
    	while (blinkerState1 == true) {
    	  Robot.lights.blinker.set(.5);
          Timer.delay(3);
          Robot.lights.blinker.set(0);
          Timer.delay(3);    	
          //blinkerState = SmartDashboard.getBoolean("blinkerState");
        //  SmartDashboard.putString("DB/String 0",String.valueOf(Robot.lights.blinker.get())); 
          blinkerState1 = SmartDashboard.getBoolean("blinkerState");
          Timer.delay(1);
     //     SmartDashboard.putBoolean("blinkerState1", blinkerState1);
    	}
    	Robot.lights.blinker.set(0);
    	end();
    	}
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
