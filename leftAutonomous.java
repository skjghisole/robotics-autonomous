package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "leftAutonomous (Blocks to Java)", group = "")
public class leftAutonomous extends LinearOpMode {

  private Servo servoTest;
  private Servo rightHook;
  private Servo leftHook;
  private DcMotor leftwheelmotor;
  private DcMotor frmotor;
  private DcMotor rightwheelmotor;
  private DcMotor flmotor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    servoTest = hardwareMap.servo.get("servoTest");
    rightHook = hardwareMap.servo.get("rightHook");
    leftHook = hardwareMap.servo.get("leftHook");
    leftwheelmotor = hardwareMap.dcMotor.get("leftwheelmotor");
    frmotor = hardwareMap.dcMotor.get("frmotor");
    rightwheelmotor = hardwareMap.dcMotor.get("rightwheelmotor");
    flmotor = hardwareMap.dcMotor.get("flmotor");

    // Put initialization blocks here.
    servoTest.setPosition(0.5);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        rightHook.setPosition(1);
        leftHook.setPosition(-1);
        sleep(1000);
        leftwheelmotor.setPower(1);
        frmotor.setPower(-1);
        rightwheelmotor.setPower(1);
        flmotor.setPower(-1);
        sleep(1000);
        leftwheelmotor.setPower(0);
        frmotor.setPower(0);
        rightwheelmotor.setPower(0);
        flmotor.setPower(0);
        sleep(200);
        leftwheelmotor.setPower(1);
        frmotor.setPower(-1);
        rightwheelmotor.setPower(-1);
        flmotor.setPower(1);
        sleep(1000);
        leftwheelmotor.setPower(0);
        frmotor.setPower(0);
        rightwheelmotor.setPower(0);
        flmotor.setPower(0);
        sleep(200);
        rightHook.setPosition(-0.5);
        leftHook.setPosition(1);
        sleep(1000);
        leftwheelmotor.setPower(-1);
        frmotor.setPower(1);
        rightwheelmotor.setPower(1);
        flmotor.setPower(-1);
        sleep(1000);
        leftwheelmotor.setPower(0);
        frmotor.setPower(0);
        rightwheelmotor.setPower(0);
        flmotor.setPower(0);
        sleep(200);
        rightHook.setPosition(1);
        leftHook.setPosition(-1);
        sleep(1000);
        leftwheelmotor.setPower(-1);
        frmotor.setPower(1);
        rightwheelmotor.setPower(-1);
        flmotor.setPower(1);
        sleep(1000);
        leftwheelmotor.setPower(0);
        frmotor.setPower(0);
        rightwheelmotor.setPower(0);
        flmotor.setPower(0);
        sleep(200);
        break;
      }
    }
  }
}