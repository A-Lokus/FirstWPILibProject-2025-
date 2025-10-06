// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.hardware.CANcoder;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** A wheel subsystem that hopefully does something */
public class WheelSubsystem extends SubsystemBase {
  // Use Bill Pugh Singleton Pattern for efficient lazy initialization (thread-safe !)
      private static class WheelSubsystemHolder {
          private static final WheelSubsystem INSTANCE = new WheelSubsystem();
      }
  
  
      /** Always use this method to get the singleton instance of this subsystem. */
      public static WheelSubsystem getInstance() {
          return WheelSubsystemHolder.INSTANCE;
      }
      
      String CAN_BUS_NAME = "ctre";
      int DRIVE_ID1 = 6;
      int TURN_ID1 = 7; 
      int TURNENCODER_ID1 = 8;
      TalonFX drivingMotor = new TalonFX(DRIVE_ID1,CAN_BUS_NAME);
      TalonFX turningMotor = new TalonFX(TURN_ID1,CAN_BUS_NAME);
      CANcoder turningEncoder = new CANcoder(TURNENCODER_ID1,CAN_BUS_NAME);
      
      public WheelSubsystem() {
          super("WheelSubsystem");
      }
      
      public void setDriveSpeed(double speed){
          drivingMotor.set(speed);
      }
      public void setTurnSpeed(double speed){
        turningMotor.set(speed);
      }
      public double getTurningPosition(){
        return Units.radiansToDegrees(turningEncoder.getAbsolutePosition().getValueAsDouble());
      }
  
      @Override
      public void periodic() {}
  }
  
