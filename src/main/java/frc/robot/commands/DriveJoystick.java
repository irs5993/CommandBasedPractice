// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveJoystick extends CommandBase {
  private final DriveTrain m_driveTrain;
  private final Joystick m_stick;

  public DriveJoystick(DriveTrain driveTrain, Joystick stick) {
    m_driveTrain = driveTrain;
    m_stick = stick;
    addRequirements(m_driveTrain);
  }

  @Override
  public void execute() {
    double slider = m_stick.getRawAxis(0);
    double multiplier = map(slider, 0, 1, 0.3, 1);

    double speed = m_stick.getY();
    double rotation = m_stick.getZ();

    m_driveTrain.arcadeDrive(-speed, rotation);
  }

  public double map(double value, double old_min, double old_max, double new_min, double new_max) {
    return (((value - old_min) * (new_max - new_min)) / (old_max - old_min)) + new_min;
  }

  @Override
  public void end(boolean interrupted) {
    m_driveTrain.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
