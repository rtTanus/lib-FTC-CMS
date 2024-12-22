package org.firstinspires.ftc.teamcode.odometryTest;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="TesteOdometria", group="LinearOpMode")
public class TesteLeitura extends LinearOpMode{

    /********Constantes Principais*******/
    double TicksPerRev = 8192;
    double WheelsRadius = 2;

    double LateralDistance = 6;
    double MidPoint= 11;

    double cm_per_tick = WheelsRadius * 2.0 * Math.PI / TicksPerRev;

    int oldRightPosition;
    int oldLeftPosition;
    int oldAuxPosition;

    int currentRightPosition;
    int currentLeftPosition;
    int currentAuxPosition;

    public PositionXYZ pos = new PositionXYZ();

    private DcMotor leftEncoder, rightEncoder, frontEncoder;
    public void runOpMode() {


        leftEncoder = hardwareMap.get(DcMotor.class, "leftEncoder");
        rightEncoder = hardwareMap.get(DcMotor.class, "rightEncoder");
        frontEncoder = hardwareMap.get(DcMotor.class, "frontEncoder");

    }
    public void localizer() {
        oldRightPosition = currentRightPosition;
        oldLeftPosition = currentLeftPosition;
        oldAuxPosition = currentAuxPosition;

        currentRightPosition = -rightEncoder.getCurrentPosition();
        currentLeftPosition = leftEncoder.getCurrentPosition();
        currentAuxPosition = frontEncoder.getCurrentPosition();

        int dn1 = currentLeftPosition  - oldLeftPosition;
        int dn2 = currentRightPosition - oldRightPosition;
        int dn3 = currentAuxPosition - oldAuxPosition;

        // the robot has moved and turned a tiny bit between two measurements:
        double dtheta = cm_per_tick * ((dn2-dn1) / (LateralDistance));
        double dx = cm_per_tick * ((dn1+dn2) / 2.0);
        double dy = cm_per_tick * (dn3 - ((dn2-dn1) * MidPoint/ LateralDistance));


    }

}