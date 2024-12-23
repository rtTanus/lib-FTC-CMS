package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.components.*;

public class MainTeleop extends OpMode {
    DriveBase drive = new DriveBase(DriveBase.DriveType.MECANUM);

    public void init(){
        drive.setMecanumMotors(
                hardwareMap.get(DcMotor.class, "MEF"),
                hardwareMap.get(DcMotor.class, "MDF"),
                hardwareMap.get(DcMotor.class, "MET"),
                hardwareMap.get(DcMotor.class, "MDT"));
        drive.setMotorMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        drive.setMotorMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
  }

  public void buttons(){
      drive.Moviment(gamepad1.right_trigger - gamepad1.left_trigger, gamepad1.left_stick_x, gamepad1.right_stick_x);

  }


  public void loop(){
        buttons();
        telemetry.update();
    }
}
