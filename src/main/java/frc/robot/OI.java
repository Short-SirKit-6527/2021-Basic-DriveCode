/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.maps.ControllerMap;
import frc.robot.maps.RobotMap;

/**
 * Add your docs here.
 */
public class OI 
{
    private static final Joystick m_Joy1 = new Joystick(RobotMap.mainJoy);

    public static boolean aButton() { return m_Joy1.getRawButton(1); }
    public static boolean bButton() { return m_Joy1.getRawButton(2); }
    public static boolean xButton() { return m_Joy1.getRawButton(3); }
    public static boolean yButton() { return m_Joy1.getRawButton(4); }
    public static boolean lefttBumper() { return m_Joy1.getRawButton(5); }
    public static boolean rightBumper() { return m_Joy1.getRawButton(6); }
    public static boolean selectButton() { return m_Joy1.getRawButton(7); }
    public static boolean starttButton() { return m_Joy1.getRawButton(8); }
    public static boolean lefttStickButton() { return m_Joy1.getRawButton(9); }
    public static boolean rightStickButton() { return m_Joy1.getRawButton(10); }
    

    public static double driveYAxis() { return m_Joy1.getRawAxis(ControllerMap.Drivebase.yAxis.ID()); }
    public static double drivezAxis() { return -m_Joy1.getRawAxis(ControllerMap.Drivebase.zAxis.ID()); }
    public static double drivexAxis() { return m_Joy1.getRawAxis(ControllerMap.Drivebase.xAxis.ID()); }
    public static double driveLefttStick() { return m_Joy1.getRawAxis(ControllerMap.Drivebase.tankDriveLeftt.ID()); }
    public static double driveRightStick() { return m_Joy1.getRawAxis(ControllerMap.Drivebase.tankDriveRight.ID()); }


    public static double  intakePower() { return triggersAsJoy(ControllerMap.Intake.throttle1.ID(), ControllerMap.Intake.throttle2.ID(), m_Joy1); }
    public static boolean intakeDR()    { return m_Joy1.getRawButton(ControllerMap.Intake.updown.ID()); }

    /**
     * Returns a -1 to 1 range based of the position of the left and right triggers. 
     * 
     * @param controller
     * 
     * @return If the left trigger is down: left trigger value, if the right trigger is down: right trigger value, else 0.
     */
    private static double triggersAsJoy(int axisID1, int axisID2, Joystick joy) {
        double axis1 = joy.getRawAxis(axisID1);
        double axis2 = joy.getRawAxis(axisID2);
        double output = 0;
        if (axis1 == 0 && axis2 == 0) 
        {
        } else if (axis1 > 0) {
            output = -axis1;
        } else if (axis2 > 0) {
            output = axis2;
        }
        return output;
    }
}
