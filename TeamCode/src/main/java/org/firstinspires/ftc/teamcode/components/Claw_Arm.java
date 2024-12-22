package org.firstinspires.ftc.teamcode.components;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import mcs.organization.commandBased.Classes.Component;

@Disabled
public class Claw_Arm extends Component {
    private DcMotor Arm;
    public void setArm(DcMotor Arm) {
        this.Arm = Arm;
    }


    @Override
    public void start() {

    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
