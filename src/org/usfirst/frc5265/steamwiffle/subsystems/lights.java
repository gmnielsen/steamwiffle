package org.usfirst.frc5265.steamwiffle.subsystems;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5265.steamwiffle.*;
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
   
	
	// test method for checking a switch
	@SuppressWarnings("deprecation")
	public boolean lightToggle() {
		boolean lightState = SmartDashboard.getBoolean("lightToggle");
		lightState = !lightState;
      	SmartDashboard.putBoolean("lightToggle",lightState);	
      	return lightState;
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	SmartDashboard.putBoolean("lightToggle", true);
    	
    }
   
    public static void stop (){
    	
    	
    }
}
