// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drums;

public class HitRight extends CommandBase {
  private final Drums m_drums;
  private final Timer m_timer;

  public HitRight(Drums drums) {
    m_timer = new Timer();
    m_drums = drums;
    addRequirements(drums);
  }

  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  @Override
  public void execute() {
    m_drums.hitRight();
  }

  @Override
  public void end(boolean interrupted) {
    m_drums.stopRight();
    m_timer.stop();
  }

  @Override
  public boolean isFinished() {
    return m_timer.hasElapsed(0.05);
  }
}
