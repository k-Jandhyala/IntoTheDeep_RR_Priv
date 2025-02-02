package org.firstinspires.ftc.teamcode.Autonomous;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Time;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.ftc.Encoder;
import com.acmerobotics.roadrunner.ftc.OverflowEncoder;
import com.acmerobotics.roadrunner.ftc.RawEncoder;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Enums.Direction;



import org.firstinspires.ftc.teamcode.ComplexRobots.IntoTheDeepRobot;
import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "Time Based Observation Park")
public class ObservationPark extends LinearOpMode {
    IntoTheDeepRobot robot;
    TimeBasedAutoHelper autobot;
    public Encoder par0;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new IntoTheDeepRobot(hardwareMap, new Pose2d(new Vector2d(0,0),0));
        autobot = new TimeBasedAutoHelper();


        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        autobot.driveAllMotorsFor(Direction.FORWARD, 300, System.currentTimeMillis(), 0.5, robot);
        autobot.strafeMotorsFor(Direction.RIGHT, 1800, System.currentTimeMillis(), 0.5, robot);
        autobot.driveAllMotorsFor(Direction.BACKWARD, 100, System.currentTimeMillis(), 0.5, robot);
        robot.specimenClaw.setPosition(0.5);
    }
}
