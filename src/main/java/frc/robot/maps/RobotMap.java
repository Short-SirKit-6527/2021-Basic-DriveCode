/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.maps;

/**
 * Add your docs here.
 */
public class RobotMap
{
    public static final int mainJoy = 0;

    public enum DriveMotors
    {
          leftt1 (0)
        , leftt2 (1)
        , right1 (2)
        , right2 (3);

        int ID;
        
        DriveMotors(int ID) 
        {
            this.ID = ID;
        }
        
        public int ID()
        {
            return this.ID;
        }
    }
    
    public enum SubsystemMotors
    {
          harvester (-1)
        , feeder    (-1)
        , lift1     (-1)
        , lift2     (-1)
        , shooter   (-1)
        , climber   (-1);

        int ID;

        SubsystemMotors(int ID) 
        {
            this.ID = ID;
        }
        
        public int ID()
        {
            return this.ID;
        }
    }

    public enum Sensors
    {
          lefttDriveEncoder (0, 1)
        , rightDriveEncoder (2, 3)
        , shooterEncoder    (4, 5);

        int DiO1;
        int DiO2;

        Sensors(int DiO1, int DiO2)
        {
            this.DiO1 = DiO1;
            this.DiO2 = DiO2;
        }
        
        public int Dio1()
        {
            return this.DiO1;
        }

        public int Dio2()
        {
            return this.DiO2;
        }
    }

    public enum PWMDevices
    {
        sampleServo (-1);

        int PWM;

        PWMDevices(int PWM)
        {
            this.PWM = PWM;
        }

        public int PWM()
        {
            return PWM;
        }
    }

    public enum Pnematics
    {
          intakeUp   (0)
        , intakeDown (1);

        int ID;

        Pnematics(int ID)
        {
            this.ID = ID;
        }

        public int ID()
        {
            return ID;
        }
    }
}
