// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

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
      
      int CAN_ID = 6;
      TalonFX krakenMotor = new TalonFX(CAN_ID);
      
      private WheelSubsystem() {
          super("WheelSubsystem");
      }
      
      public void setSpeed(double speed){
          krakenMotor.set(speed);
      }
  
      @Override
      public void periodic() {}
  }
  
