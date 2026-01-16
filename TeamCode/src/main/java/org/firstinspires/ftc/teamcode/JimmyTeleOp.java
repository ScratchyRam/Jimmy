package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="JimmyTeleOp", group="Linear OpMode")
public class JimmyTeleOp extends LinearOpMode {
    private DcMotor intake;
    private DcMotor LFront;
    private DcMotor RFront;
    private DcMotor LBack;
    private DcMotor RBack;
    //Servos
    @Override
    public void runOpMode() throws InterruptedException {
        LFront  = hardwareMap.get(DcMotor.class, "FL");
        RFront = hardwareMap.get(DcMotor.class, "FR");
        LBack  = hardwareMap.get(DcMotor.class, "BL");
        RBack = hardwareMap.get(DcMotor.class, "BR");
        waitForStart();
        LFront.setDirection(DcMotor.Direction.FORWARD);
        LBack.setDirection(DcMotor.Direction.FORWARD);
        RFront.setDirection(DcMotor.Direction.REVERSE);
        RBack.setDirection(DcMotor.Direction.FORWARD);

        while (opModeIsActive())
        {
            ApplyInputToMotors(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, LFront, RFront, LBack, RBack);

            telemetry.update();
        }
    }
    //Applies input to the Drive Motors
    public static void ApplyInputToMotors(double Ly, double Lx, double Rx, DcMotor LFront, DcMotor RFront, DcMotor LBack, DcMotor RBack)
    {
        //Computing Powers
        double LeftFrontWheel = Ly + Lx - Rx;
        double RightFrontWheel = Ly - Lx + Rx;
        double LeftBackWheel = Ly - Lx - Rx;
        double RightBackWheel = Ly + Lx + Rx;

        //Applying Power the Drive Train
        LFront.setPower(LeftFrontWheel);
        RFront.setPower(RightFrontWheel);
        LBack.setPower(LeftBackWheel);
        RBack.setPower(RightBackWheel);
    }
}

