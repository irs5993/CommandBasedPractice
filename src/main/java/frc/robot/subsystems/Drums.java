// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.PWMVictorSPX;

public class Drums extends SubsystemBase {

  private final PWMVictorSPX m_leftDrum;
  private final PWMVictorSPX m_rightDrum;

  public Drums() {
    m_leftDrum = new PWMVictorSPX(Constants.Ports.Drum.left);
    m_rightDrum = new PWMVictorSPX(Constants.Ports.Drum.right); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void hitLeft() {
    m_leftDrum.set(0.8);
  }

  public void hitRight() {
    m_rightDrum.set(0.8);
  }

  public void stopRight() {
    m_rightDrum.set(0);
  }

  public void stopLeft() {
    m_leftDrum.set(0);
  }
}
