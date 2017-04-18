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

import org.usfirst.frc5265.steamwiffle.OI.AxisType;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GamepadBase;
//import edu.wpi.first.wpilibj.GenericHID;


/**
 * A nearly drop in replacement for Joystick using an XBOX USB Controller
 * @author Gustave Michel
 */
public class Xbox  {
	
	public XboxController control;
	private int xport;
	private DriverStation m_ds;
	
	
	public Xbox() {
		control = new XboxController(0);
		}
	
	public void XboxController(int port) {
        
        xport = port;
        m_ds = DriverStation.getInstance();
    }
	
	public double getRawAxis(int axis) {
        return m_ds.getStickAxis(xport, axis);
    }
    
	
	 public double getAxis(AxisType axis) {
	        return getRawAxis(axis.value);
	    }
	
	public static class AxisType {
	        
	        /**
	         * The integer value representing this enumeration
	         */
	        public final int value;
	        private static final int kLeftX_val = 1;
	        private static final int kLeftY_val = 2;
	        private static final int kTrigger_val = 3;
	        private static final int kRightX_val = 4;
	        private static final int kRightY_val = 5;
	        private static final int kDLeftRight_val = 6;
	
	
	
	 private AxisType(int value) {
         this.value = value;
     }
     
     /**
      * Axis: Left X
      */
     public static final AxisType kLeftX = new AxisType(kLeftX_val);
     
     /**
      * Axis: Left Y
      */
     public static final AxisType kLeftY = new AxisType(kLeftY_val);
     
     /**
      * Axis: Triggers
      */
     public static final AxisType kTrigger = new AxisType(kTrigger_val);
     
     /**
      * Axis: Right X
      */
     public static final AxisType kRightX = new AxisType(kRightX_val);
     
     /**
      * Axis: Right Y
      */
     public static final AxisType kRightY = new AxisType(kRightY_val);
     
     /**
      * Axis: D-Pad Left-Right
      */
     public static final AxisType kDLeftRight = new AxisType(kDLeftRight_val);
 }
	
	public double getY(Hand hand) {
        if(hand.value == Hand.kRight.value) {
            return getAxis(AxisType.kRightY);
        } else if(hand.value == Hand.kLeft.value) {
            return getAxis(AxisType.kLeftY);
        } else {
            return 0;
        }
    }
	
	public final double getX(Hand hand) {
        if(hand.value == Hand.kRight.value) {
            return getAxis(AxisType.kRightX);
        } else if(hand.value == Hand.kLeft.value) {
            return getAxis(AxisType.kLeftX);
        } else {
            return 0;
        }
    }
	
}
	