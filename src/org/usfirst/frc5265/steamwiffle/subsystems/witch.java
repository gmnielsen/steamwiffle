package org.usfirst.frc5265.steamwiffle.subsystems;

import org.usfirst.frc5265.steamwiffle.Robot;
import org.usfirst.frc5265.steamwiffle.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class witch extends Subsystem {
	public double throttle;
	private final SpeedController witch = RobotMap.witch;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void winch (double power) {
		
		//throttle = Robot.oi.getThrottle();
		// throttle = (1+throttle)/2;
		witch.set(power);
		SmartDashboard.putNumber("witch motor", power);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

