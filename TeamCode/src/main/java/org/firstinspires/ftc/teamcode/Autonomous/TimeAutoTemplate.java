package org.firstinspires.ftc.teamcode.Autonomous;


import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Enums.Direction;

import org.firstinspires.ftc.teamcode.ComplexRobots.IntoTheDeepRobot;

/* TODO: For the Driver Station to recognize this file as an auto, uncomment the the annotation below. An argument can be supplied
         in the parentheses to give the OpMode a name that will be visible on the Driver Station. Ex: @Autonomous(name="Test Auto")
@Autonomous()
 */
public class TimeAutoTemplate extends LinearOpMode {
    IntoTheDeepRobot robot;//TODO: We are creating an instance of our Into the deep robot
    TimeBasedAutoHelper autobot;//TODO: We are creating an instance of our Auto helperMethod

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new IntoTheDeepRobot(hardwareMap, new Pose2d(new Vector2d(0,0),0));
        autobot = new TimeBasedAutoHelper();

        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        //TODO: Here are some examples of the ways we can use the time auto
        autobot.driveAllMotorsFor(Direction.FORWARD, 300, System.currentTimeMillis(), 0.5, robot);
        autobot.strafeMotorsFor(Direction.RIGHT, 1800, System.currentTimeMillis(), 0.5, robot);
        autobot.driveAllMotorsFor(Direction.BACKWARD, 100, System.currentTimeMillis(), 0.5, robot);
        robot.specimenClaw.setPosition(0.5);

        //TODO: One speicial method we have is ParallelAction(), which allows us to run 2 actions at the same time For example:
        autobot.ParallelAction(
                () -> autobot.strafeMotorsFor(Direction.RIGHT, 1800, System.currentTimeMillis(), 0.5, robot),
                () -> autobot.runSlidesTo(Direction.UP, 1800, 0.5, robot)
        );
        //TODO: As you can see here, we used a special way to call the parallel action
    }
}
