// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chassis extends SubsystemBase {
  public TalonFX motorLF;
  public TalonFX motorLB;
  public TalonFX motorRF;
  public TalonFX motorRB;
  /** Creates a new Chassis. */
  public Chassis(){
    motorLF = new TalonFX(Constants.leftFrontMotorID);
    motorLB = new TalonFX(Constants.leftBackMotorID);
    motorRF = new TalonFX(Constants.rightFrontMotorID);
    motorRB = new TalonFX(Constants.rightBackMotorID);

    motorLF.set(TalonFXControlMode.Velocity, Constants.pulesToMeter*10);
  }

  public void setPower(double leftPower, double rightPower){
    motorLF.set(ControlMode.PercentOutput, leftPower);
    motorLB.follow(motorLB);
    motorRF.set(ControlMode.PercentOutput, rightPower);
    motorRB.follow(motorRF);
  }

  public void setVelocity(double leftVelocity, double rightVelocity){
    motorLF.set(ControlMode.Velocity, leftVelocity/10);
    motorLB.follow(motorLB);
    motorRF.set(ControlMode.Velocity, rightVelocity/10);
    motorRB.follow(motorRF);
  }

  public double velocity(){ return motorLF.getSelectedSensorVelocity()*10; }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
