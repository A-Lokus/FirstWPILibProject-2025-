package frc.robot.commands;

import frc.robot.subsystems.WheelSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class TurnToPositionCommand extends Command {

  private double degrees;
  private PIDController pid;

  public TurnToPositionCommand(double degrees) {
      setName("TurnToPositionCommand");
      this.pid = new PIDController(1, 0, 0);
      this.pid.setTolerance(Units.degreesToRadians(1));
      this.pid.enableContinuousInput(-Math.PI, Math.PI);
      this.degrees = degrees;
      addRequirements(WheelSubsystem.getInstance());
  }

 
  @Override
  public void initialize() {
    this.pid.reset();
  }


  @Override
  public void execute() {
    double currentAngle = Units.degreesToRadians(WheelSubsystem.getInstance().getTurningPosition());
    double goalAngle = Units.degreesToRadians(degrees);
    double speed = this.pid.calculate(currentAngle, goalAngle);
    
    WheelSubsystem.getInstance().setTurnSpeed(speed);
  }


  @Override
  public void end(boolean interrupted) {
    WheelSubsystem.getInstance().setTurnSpeed(0);
  }


  @Override
  public boolean isFinished() {
    return this.pid.atSetpoint();
  }
}