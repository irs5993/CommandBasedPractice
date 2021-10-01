// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveManual;
import frc.robot.subsystems.DriveTrain;
import frc.robot.helpers.ChasisControl;

public class Autonomous extends SequentialCommandGroup {
  private final DriveTrain m_driveTrain;
  
  public Autonomous(DriveTrain driveTrain) {
    m_driveTrain = driveTrain;
    addCommands(
      new DriveManual(m_driveTrain, new ChasisControl(0.6, 0, 0.9)),
      new DriveManual(m_driveTrain, new ChasisControl(-0.6, 0, 0.9)),
      new DriveManual(m_driveTrain, new ChasisControl(0.6, 0, 0.9)),
      new WaitCommand(1),
      new DriveManual(m_driveTrain, new ChasisControl(0, 0.7, 0.9)),
      new WaitCommand(1),
      new DriveManual(m_driveTrain, new ChasisControl(0, -0.7, 0.9))

    );
  }
}
