package org.firstinspires.ftc.teamcode.components;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.commands.MecanumDrive;

import mcs.organization.commandBased.Classes.Component;


@Disabled
public class DriveBase extends Component {
    private DcMotor Arm;
    private MecanumDrive mecanum_drive = new MecanumDrive();

    @Override
    public void start() {

    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }

    public enum DriveType{
        MECANUM,
        TANK
    }
    public DriveType type;

    public void setDriveTrainType(DriveType type) {
        this.type = type;
    }

    public void setMecanumMotors(DcMotor leftFront, DcMotor rightFront, DcMotor leftBack, DcMotor rightBack){
        this.mecanum_drive.setMecanumMotors(leftFront,rightFront,leftBack,rightBack);
    }

    public void Moviment(Float Straight, Float Angle, Float Lateral){
        switch (this.type){
            case MECANUM:
                this.mecanum_drive.movimentRobotCentric(Straight,Angle,Lateral);
                break;
            case TANK:
                break;
        }
    }
    public void setMotorMode(DcMotor.RunMode motor_mode){
        switch (this.type){
            case MECANUM:
                this.mecanum_drive.setMode(motor_mode);
                break;
            case TANK:
                break;
        }
    }

}
