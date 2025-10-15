// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.WheelSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class DrivingCommand extends Command {

  private double speed;

  public DrivingCommand(double speed) {
      setName("DrivingCommand");
      // Use addRequirements() here to declare subsystem dependencies.
      this.speed = speed;
      addRequirements(WheelSubsystem.getInstance());
  }


  @Override
  public void initialize() {
    WheelSubsystem.getInstance().setDriveSpeed(speed);
  }


  @Override
  public void execute() {}


  @Override
  public void end(boolean interrupted) {
    WheelSubsystem.getInstance().setDriveSpeed(0);
  }


  @Override
  public boolean isFinished() {
      return false;
  }
}

