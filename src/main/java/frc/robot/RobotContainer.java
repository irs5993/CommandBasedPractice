// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.DriveJoystick;
import frc.robot.commands.DriveManual;
import frc.robot.commands.groups.Autonomous;
import frc.robot.helpers.ChasisControl;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;


public class RobotContainer {
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Joystick m_stick = new Joystick(Constants.joystick);

  public RobotContainer() {
    configureButtonBindings();

    m_driveTrain.setDefaultCommand(new DriveJoystick(m_driveTrain, m_stick));
  }

  private void configureButtonBindings() {
     JoystickButton moveForwardButton = new JoystickButton(m_stick, Constants.Buttons.Chasis.forward);
     JoystickButton moveBackwardButton = new JoystickButton(m_stick, Constants.Buttons.Chasis.backward);

     moveForwardButton.whenPressed(new DriveManual(m_driveTrain, new ChasisControl(0.5, 0, 0.8)));
     moveBackwardButton.whenPressed(new DriveManual(m_driveTrain, new ChasisControl(-0.5, 0, 0.8)));
  }

  public Command getAutonomousCommand() {
    return new Autonomous(m_driveTrain);
  }
}
