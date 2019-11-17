package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "OnBotAutonomous (Blocks to Java)", group = "")
public class OnBotAutonomous extends LinearOpMode {

  private Servo rightHook;
  private Servo leftHook;
  private DcMotor rightwheelmotor;
  private DcMotor leftwheelmotor;
  private TouchSensor backTouchSensor;
  private DistanceSensor frontLightSensor;
  private DistanceSensor leftLightSensor;
  private DistanceSensor backLightSensor;
  private DistanceSensor rightLightSensor;


  //
  private DcMotor leftwheelmotor;
  private DcMotor frmotor;
  private DcMotor rightwheelmotor;
  private DcMotor flmotor;

  // left wheels are always negative
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double frontLightSensor;
    double leftLightSensor;
    double rightLightSensor;
    double backLightSensor;

    //hooks here
    rightHook = hardwareMap.servo.get("rightHook");
    leftHook = hardwareMap.servo.get("leftHook");
    
    
    // wheels should be configured here
    leftwheelmotor = hardwareMap.dcMotor.get("leftwheelmotor");
    frmotor = hardwareMap.dcMotor.get("frmotor");
    rightwheelmotor = hardwareMap.dcMotor.get("rightwheelmotor");
    flmotor = hardwareMap.dcMotor.get("flmotor");

    // sensors here
    backTouchSensor = hardwareMap.touchSensor.get("backtouchsensor");

    frontLightSensor = hardwareMap.get(DistanceSensor.class, "frontlightsensor");
    leftLightSensor = hardwareMap.get(DistanceSensor.class, "leftlightsensor");
    backLightSensor = hardwareMap.get(DistanceSensor.class, "backlightsensor");
    rightLightSensor = hardwareMap.get(DistanceSensor.class, "rightlightsensor");

    
    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Initialize everything
      rightHook.setPosition(1);
      leftHook.setPosition(-1);
      sleep(2000);
      while (opModeIsActive()) {
        frontLightSensor = (frontLightSensor.getDistance(DistanceUnit.CM)) * 100;
        leftLightSensor = (leftLightSensor.getDistance(DistanceUnit.CM)) * 100;
        rightLightSensor = (rightLightSensor.getDistance(DistanceUnit.CM)) * 100;
        backLightSensor = (backLightSensor.getDistance(DistanceUnit.CM)) * 100;

        while(frontLightSensor >= 1200) {
          //move forward
          frmotor.setPower(1);
          rightwheelmotor.setPower(1);
          flmotor.setPower(-1);
          leftwheelmotor.setPower(-1);
          telemetry.addData("frontLightSensor", frontLightSensor);
          break;
        }

        // reset
        frmotor.setPower(0);
        rightwheelmotor.setPower(0);
        flmotor.setPower(0);
        leftwheelmotor.setPower(0);
        sleep(300);

        // lowers hook

        while(!backTouchSensor.isPressed()) {
          // move backward
          frmotor.setPower(-1);
          rightwheelmotor.setPower(-1);
          flmotor.setPower(1);
          leftwheelmotor.setPower(1);
          telemetry.addData("backLightSensor", backLightSensor);
          break;
        }
        // reset
        frmotor.setPower(0);
        rightwheelmotor.setPower(0);
        flmotor.setPower(0);
        leftwheelmotor.setPower(0);
        sleep(300);

        //move sidewards for maybe 2 seconds
        frmotor.setPower(1);
        rightwheelmotor.setPower(-1);
        flmotor.setPower(1);
        leftwheelmotor.setPower(-1);
        // reset
        frmotor.setPower(0);
        rightwheelmotor.setPower(0);
        flmotor.setPower(0);
        leftwheelmotor.setPower(0);
        sleep(300);
        // rotate
        leftwheelmotor.setPower(-1);
        frmotor.setPower(-1);
        rightwheelmotor.setPower(-1);
        flmotor.setPower(-1);
        // reset
        frmotor.setPower(0);
        rightwheelmotor.setPower(0);
        flmotor.setPower(0);
        leftwheelmotor.setPower(0);
        sleep(300);
        while(backLightSensor >= 1200) {
          // move backward
          frmotor.setPower(1);
          rightwheelmotor.setPower(1);
          flmotor.setPower(-1);
          leftwheelmotor.setPower(-1);
          telemetry.addData("backLightSensor", backLightSensor);
          break;
        }
        // reset
        frmotor.setPower(0);
        rightwheelmotor.setPower(0);
        flmotor.setPower(0);
        leftwheelmotor.setPower(0);
        sleep(300);
        break;

        telemetry.addData("frontLightSensor", frontLightSensor);
        telemetry.addData("backLightSensor", backLightSensor);
        telemetry.addData("rightLightSensor", rightLightSensor);
        telemetry.addData("leftLightSensor", leftLightSensor);
        telemetry.update();

        // Check if the sensor senses something in front of it
        // if (turning == false && Math.ceil(2 * frontSensor) >= 25) {
        //   // Going Forward
        //   rightwheelmotor.setPower(1);
        //   leftwheelmotor.setPower(-1);
        // } else {
        //   // Stops Motor
        //   rightwheelmotor.setPower(0);
        //   leftwheelmotor.setPower(0);
        //   // Sets turning to true
        //   turning = true;
        //   // Pauses the operation for 1s
        //   sleep(1000);
        //   // Lowers the hook
        //   rightHook.setPosition(-0.5);
        //   leftHook.setPosition(1);
        //   sleep(2000);
        //   backing = true;
        //   while (backing == true) {
        //     rightwheelmotor.setPower(-1);
        //     leftwheelmotor.setPower(1);
        //     if (testTouch.isPressed()) {
        //       backing = false;
        //     }
        //   }
        //   rightwheelmotor.setPower(0);
        //   leftwheelmotor.setPower(0);
        //   sleep(1000);
        //   // Turn Right
        //   turningLeft = true;
        //   while (turningLeft == true) {
        //     rightwheelmotor.setPower(-1);
        //     leftwheelmotor.setPower(-1);
        //     leftLightSensor = leftLightSensor.getDistance(DistanceUnit.CM);
        //     if (Math.ceil(2 * leftLightSensor) <= 30) {
        //       turningLeft = false;
        //     }
        //   }
        //   rightwheelmotor.setPower(0);
        //   leftwheelmotor.setPower(0);
        //   sleep(1000);
        //   rightHook.setPosition(0.5);
        //   leftHook.setPosition(-0.5);
        //   sleep(1000);
        //   while (break2 == false) {
        //     rightwheelmotor.setPower(-1);
        //     leftwheelmotor.setPower(1);
        //     backLightSensor = backLightSensor.getDistance(DistanceUnit.CM);
        //     if (Math.ceil(2 * backLightSensor) <= 25) {
        //       break2 = true;
        //     }
        //   }
        //   break;
        // }
      }
    }
  }
}