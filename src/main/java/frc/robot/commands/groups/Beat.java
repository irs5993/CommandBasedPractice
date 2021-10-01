// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveManual;
import frc.robot.commands.HitBoth;
import frc.robot.commands.HitLeft;
import frc.robot.commands.HitRight;

import frc.robot.subsystems.Drums;

public class Beat extends SequentialCommandGroup {
  private final Drums d;
  
  public Beat(Drums drums) {
    d = drums;
    addCommands(
        new HitBoth(d),
        new WaitCommand(1),
        new HitBoth(d),
        new WaitCommand(1),
         new HitLeft(d),
        new WaitCommand(1),
        new HitRight(d)
    );
  }
}
