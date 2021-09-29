// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase {
  private final PWMVictorSPX m_leftMotor;
  private final PWMVictorSPX m_rightMotor;
  private final DifferentialDrive m_robotDrive;

  public DriveTrain() {
    m_leftMotor = new PWMVictorSPX(Constants.Ports.Chasis.left);
    m_rightMotor = new PWMVictorSPX(Constants.Ports.Chasis.right); 
    m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  }

  @Override
  public void periodic() {
 
  }

  public void arcadeDrive(double speed, double rotation) {
    m_robotDrive.arcadeDrive(speed, rotation);
  }

  public void stop() {
    m_robotDrive.stopMotor();
  }
}
