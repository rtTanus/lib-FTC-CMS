package org.firstinspires.ftc.teamcode.commands;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

import mcs.organization.commandBased.Classes.Command;

@Disabled
public class MecanumDrive extends Command {
    DcMotor leftFront, rightFront, leftBack, rightBack;
    float straight_control,lateral_control,angle_control;

    public void setMecanumMotors(DcMotor leftFront, DcMotor rightFront, DcMotor leftBack, DcMotor rightBack){
        this.leftFront = leftFront;
        this.rightFront = rightFront;
        this.leftBack = leftBack;
        this.rightBack = rightBack;
    }


    public void setMode(DcMotor.RunMode motorMode){
        this.leftFront.setMode(motorMode);
        this.rightFront.setMode(motorMode);
        this.leftBack.setMode(motorMode);
        this.rightBack.setMode(motorMode);
    }

    public void movimentRobotCentric(float straight_control, float lateral_control, float angle_control){

        this.straight_control = straight_control;
        this.lateral_control = lateral_control;
        this.angle_control = angle_control;

        double denominator = Math.max(Math.abs(this.straight_control) + Math.abs(this.lateral_control) + Math.abs(this.angle_control),1);
        this.leftFront.setPower((this.straight_control + this.lateral_control + this.angle_control)/denominator);
        this.rightFront.setPower((this.straight_control - this.lateral_control - this.angle_control)/denominator);
        this.leftBack.setPower((this.straight_control - this.lateral_control + this.angle_control)/denominator);
        this.rightBack.setPower((this.straight_control + this.lateral_control - this.angle_control)/denominator);
    }
    public void movimentFieldCentric(double straight, double lateral, double angle){
        // Fazer ainda
        double denominator = Math.max(Math.abs(straight) + Math.abs(lateral) + Math.abs(angle),1);
        this.leftFront.setPower((straight + lateral + angle)/denominator);
        this.rightFront.setPower((straight - lateral - angle)/denominator);
        this.leftBack.setPower((straight - lateral + angle)/denominator);
        this.rightBack.setPower((straight + lateral - angle)/denominator);
    }


    @Override
    public void start(){
    }

    @Override
    public void run(){

    }

    @Override
    public void stop() {
    }


}
