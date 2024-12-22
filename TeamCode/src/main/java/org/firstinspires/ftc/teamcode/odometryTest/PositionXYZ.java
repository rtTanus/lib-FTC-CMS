package org.firstinspires.ftc.teamcode.odometryTest;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class PositionXYZ  extends LinearOpMode {
    double CordenateX;
    double CordenateY;
    double Angle;


    public void runOpMode(){
        telemetry.addData("X",CordenateX);
        telemetry.addData("Y",CordenateY);
        telemetry.addData("ANGLE",Angle);
    }
    public void x(double pos){
        CordenateX += pos;
    }
    public void y(double pos){
        CordenateY += pos;
    }
    public void angle(double pos){
        Angle += pos;
    }

}
