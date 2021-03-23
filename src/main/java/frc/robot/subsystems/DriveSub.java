/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.maps.RobotMap.DriveMotors;
import frc.robot.maps.RobotMap.Sensors;


public class DriveSub extends SubsystemBase {
  
  // Motors
  
 // private static final VictorSPX lefttMotor1 = new VictorSPX(DriveMotors.leftt1.ID()) ;
 // private static final VictorSPX lefttMotor2 = new VictorSPX(DriveMotors.leftt2.ID()) ;
 //private static final VictorSPX rightMotor1 = new VictorSPX(DriveMotors.right1.ID()) ;
 // private static final VictorSPX rightMotor2 = new VictorSPX(DriveMotors.right2.ID()) ;
 
  

  private static final PWMVictorSPX lefttM = new PWMVictorSPX(0);
  private static final PWMVictorSPX rightM = new PWMVictorSPX(1);

  // Motor methods
  private static void setMotors(double leftt, double right)
  {
    lefttM.set(leftt);
    rightM.set(right);
    
    //lefttMotor1.set(VictorSPXControlMode.PercentOutput, -leftt);
    //lefttMotor2.set(VictorSPXControlMode.PercentOutput, -leftt);
    //rightMotor1.set(VictorSPXControlMode.PercentOutput, right);
    //rightMotor2.set(VictorSPXControlMode.PercentOutput, right);
    
  }

  // Sensors
  private static final DutyCycleEncoder lefttEncoder = new DutyCycleEncoder(Sensors.lefttDriveEncoder.Dio1());
  private static final DutyCycleEncoder rightEncoder = new DutyCycleEncoder(Sensors.rightDriveEncoder.Dio1());
  private static final AHRS navX = new AHRS(SPI.Port.kMXP);
  private static double xpower;

  // Sensor Methods
  public static double lefttEncoder() {
    return lefttEncoder.get();
  }

  public static double rightEncoder() {
    return rightEncoder.get();
  }

  public static double lefttEncoderDistance() {
    return lefttEncoder.getDistance();
  }

  public static double rightEncoderDistance() {
    return rightEncoder.getDistance();
  }

  public static double getGyroAngle() {
    return navX.getAngle();
  }

  public static void resetGyro() {
    navX.reset();
  }

  // Constructor
  public DriveSub() {
    lefttEncoder.setDistancePerRotation(25.1);
    rightEncoder.setDistancePerRotation(25.1);
  }

  /**
   * @param xSpeed    The robot's speed along the X axis [-1.0..1.0]. Forward is
   *                  positive.
   * @param zRotation The robot's rotation rate around the Z axis [-1.0..1.0].
   *                  Clockwise is positive.
   */
  public static void arcadeDrive(double xpower, double zRotation) {
    DriveSub.xpower = xpower;
    zRotation = -zRotation;

    double lefttOutput = 0;
    double rightOutput = 0;

    double maxInput = Math.copySign(Math.max(Math.abs(xpower), Math.abs(zRotation)), xpower);

    if (xpower >= 0.0) {
      // Driving forward
      if (zRotation >= 0.0) {
        // Turning right
        lefttOutput = maxInput;
        rightOutput = xpower - zRotation;
      } else {
        // Turning left
        lefttOutput = xpower + zRotation;
        rightOutput = maxInput;
      }
    } else {
      // Driving backward
      if (zRotation >= 0.0) {
        // Turning left
        lefttOutput = xpower + zRotation;
        rightOutput = maxInput;
      } else {
        // Turning right
        lefttOutput = maxInput;
        rightOutput = xpower - zRotation;
      }
    }

    setMotors(lefttOutput, rightOutput);
  }

  public static void tankDrive(double leftt, double right) 
  {
    setMotors(leftt, right);
  }

  public static void stop()
  {
    setMotors(0, 0);
  }

  @Override
  public void periodic() { }
}
