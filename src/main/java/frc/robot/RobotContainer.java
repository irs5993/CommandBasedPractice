// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.DriveJoystick;
import frc.robot.commands.DriveManual;
import frc.robot.commands.HitBoth;
import frc.robot.commands.HitLeft;
import frc.robot.commands.HitRight;
import frc.robot.commands.groups.Autonomous;
import frc.robot.commands.groups.Beat;
import frc.robot.helpers.ChasisControl;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Drums;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;


public class RobotContainer {
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Drums m_drums = new Drums();

  private final Joystick m_stick = new Joystick(Constants.joystick);

  public RobotContainer() {
    configureButtonBindings();

    m_driveTrain.setDefaultCommand(new DriveJoystick(m_driveTrain, m_stick));
  }

  private void configureButtonBindings() {
     JoystickButton moveForwardButton = new JoystickButton(m_stick, Constants.Buttons.Chasis.forward);
     JoystickButton moveBackwardButton = new JoystickButton(m_stick, Constants.Buttons.Chasis.backward);
     JoystickButton rightDrumButton = new JoystickButton(m_stick, Constants.Buttons.Drum.right);
     JoystickButton leftDrumButton = new JoystickButton(m_stick, Constants.Buttons.Drum.left);


     moveForwardButton.whenPressed(new DriveManual(m_driveTrain, new ChasisControl(0.6, 0, 1.4)));
     moveBackwardButton.whenPressed(new DriveManual(m_driveTrain, new ChasisControl(-0.6, 0, 1.4)));
     rightDrumButton.whenPressed(new HitRight(m_drums));
     leftDrumButton.whenPressed(new HitLeft(m_drums));

  }

  // Available commands -> HitLeft(m_drums), HitRight(m_drums), HitBoth(m_drums)
  public Command getAutonomousCommand() {
    return new ParallelCommandGroup(
      new Beat(m_drums),
      new DriveManual(m_driveTrain, new ChasisControl(0.5, 0, 8))
   
    );
  }
}
