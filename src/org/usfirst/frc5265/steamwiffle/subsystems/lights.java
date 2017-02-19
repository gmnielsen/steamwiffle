package org.usfirst.frc5265.steamwiffle.subsystems;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5265.steamwiffle.*;
import org.usfirst.frc5265.steamwiffle.commands.Lights;
import org.usfirst.frc5265.steamwiffle.commands.toggleTest;

/**
 *
 */
public class lights extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public final SpeedController blinker = RobotMap.blinker;
	boolean blinkerState, blinkerState1;
    public boolean blinkAbort = false;
    public boolean itcalled = false;
   
	
	public void BLINK() {
		  stop();
	SmartDashboard.getBoolean("blinkerState");  
	while (!blinkAbort) {
		SmartDashboard.putString("blinK", "blink");
  	  //if (blinkAbort) { 		  break;  	  }
  		  Robot.lights.blinker.set(.5);  
  		  Timer.delay(1);
          Robot.lights.blinker.set(.0);
          Timer.delay(1);    	
       
      blinkerState = SmartDashboard.getBoolean("blinkerState");
        SmartDashboard.putBoolean("brushState after loop", blinkAbort);
        stop();
        
	}
	SmartDashboard.putString("lights", "after return");
	Robot.lights.blinker.set(0);
	Robot.lights.blinkAbort = true;
	}
	
/*
 *
public class Lights extends Command {
	public Lights() {
    	requires(Robot.camera);
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	blinkerState = SmartDashboard.getBoolean("blinkerState", true);
    	blinkerToggle();
    	while (blinkerState) {
    	  blinker.set(.5);
          Timer.delay(3);
          blinker.set(0);
          Timer.delay(3);    	
          SmartDashboard.putString("DB/String 0",String.valueOf(blinker.get())); 
    	}
    	blinker.set(0);
    	
    	// test brushstate and either turn the brush motor on or off
    	
    	}
    
    	
    public static boolean blinkerToggle() {
       		boolean blinkerState = SmartDashboard.getBoolean("blinkerState",true);
           	blinkerState = !blinkerState;
           	SmartDashboard.putBoolean("blinkerState",blinkerState);	
           	return blinkerState;
    

          
    		
    		
    }
  
 

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
    }
}

*/

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
   /* public boolean blinkerToggle(){
        @SuppressWarnings("deprecation")
		boolean blinkerState = SmartDashboard.getBoolean("blinkerState");
     	blinkerState = !blinkerState;
     	SmartDashboard.putBoolean("blinkerState", blinkerState);
      	return blinkerState;
     */ 	
      

     	//return blinkerState;
    
     /* (blinkerState) {
      	  blinker.set(.5);
            Timer.delay(3);
            blinker.set(0);
            Timer.delay(3);    	
            SmartDashboard.putString("DB/String 0",String.valueOf(blinker.get())); 
      	}
      	blinker.set(0);
      	
    }
    */
    public static void stop (){
    	new Lights();
    	
    	
    }
}
