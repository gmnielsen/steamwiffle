// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5265.steamwiffle;

//import org.opencv.*;
import org.usfirst.frc5265.steamwiffle.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

	// each button must be declared
    ;
    public Joystick steering;
    
    public JoystickButton brush;
    public JoystickButton armup;
    public JoystickButton armdown;
    public JoystickButton servoTest;
    public JoystickButton solTest;
    public JoystickButton liftup;
    public JoystickButton liftdown;

    
    public OI() {
        
    	// construct the joystick
    	steering = new Joystick(0);
       
        // construct each button and what happens when it is used
        //click01 = new JoystickButton(steering, 1);
        	//click01.whileHeld(new dothis01());
       
       	solTest = new JoystickButton(steering,4);
       		solTest.toggleWhenPressed(new SolTest());
       		
        //servoTest = new JoystickButton(steering,3);
        	//servoTest.whenPressed(new servoTest());
        //armup = new JoystickButton(steering,1);
        	//armup.whenPressed(new armUp());
        armdown = new JoystickButton(steering,2);
        	armdown.whenPressed(new armDown());
        liftup = new JoystickButton(steering, 5);
        	liftup.whileHeld(new LiftUp());
        liftdown = new JoystickButton(steering, 6);
        	liftdown.whileHeld(new LiftDown());
        			
       
        

       
        


    }
    
    // these methods return raw data from the joystick
    // we should probably comment out the radian vector methods, as we aren't using them
    public Joystick getsteering() {
        return steering;
    }
    public double getForward() {


        return steering.getRawAxis(1); //look up what the actual axis number is
       


    }
    public double getSideways() {
    return steering.getRawAxis(4); //look up what the actual axis number is
    }
   
    public double getTwistSteer() {
        return steering.getRawAxis(0); //look up what the actual axis number is
    }
    public double getPolarDegrees() {
    	return steering.getDirectionDegrees();
    }
    public double getPolarRadians() {
    	return steering.getDirectionRadians();
    }
    public double getPolarMagnitude() {
    	return steering.getMagnitude();	
    }
    public double getThrottle() {
    	return steering.getThrottle()-.99;
    }
    public double getPOV(){
    	return steering.getPOV();
    	
    }
}

