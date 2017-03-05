package org.usfirst.frc5265.steamwiffle.subsystems;

import org.usfirst.frc5265.steamwiffle.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class witch extends Subsystem {
	
	private final SpeedController witch = RobotMap.witch;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void winch (double power) {
		witch.set(power);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

