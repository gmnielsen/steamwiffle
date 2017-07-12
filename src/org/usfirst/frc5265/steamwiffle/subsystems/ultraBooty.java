package org.usfirst.frc5265.steamwiffle.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.*;
import org.usfirst.frc5265.steamwiffle.commands.BootySteering;

/**
 *
 */
public class ultraBooty extends Subsystem {
	public double range; 
	//Ultrasonic booty = new Ultrasonic (0,0);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	//booty.setAutomaticMode(true);
         //Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//range = SmartDashboard.getNumber("Distance", range);
    	
}
    
    /*
    @SuppressWarnings("deprecation")
    public void ultrabootySample() {
    	
    }
    //SmartDashboard.putNumber("Distance", range);
*/
}

