package mcs.organization.commandBased.Classes;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.RobotLog;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.internal.opmode.TelemetryInternal;
import org.firstinspires.ftc.robotcore.internal.system.Assert;

/**
 * Base class for user defined linear operation modes (linear OpModes).
 * <p>
 * This class derives from {@link OpMode}, but you are not able to
 * override the methods defined in OpMode.
 */
@SuppressWarnings("unused")
public abstract class Command extends OpMode {

    //------------------------------------------------------------------------------------------------
    // State
    //------------------------------------------------------------------------------------------------

    private volatile boolean  userMethodReturned = false;
    private volatile boolean  userMonitoredForStart = false;
    private final Object      runningNotifier = new Object();

    //------------------------------------------------------------------------------------------------
    // Construction
    //------------------------------------------------------------------------------------------------

    /**
     * Command constructor
     */
    public Command() {
    }

    //------------------------------------------------------------------------------------------------
    // Operations
    //------------------------------------------------------------------------------------------------

    abstract public void start();

    abstract public void run();

    abstract public void stop();



    /**
     * Puts the current thread to sleep for a bit as it has nothing better to do. This allows other
     * threads in the system to run.
     *
     * <p>One can use this method when you have nothing better to do in your code as you await state
     * managed by other threads to change. Calling idle() is entirely optional: it just helps make
     * the system a little more responsive and a little more efficient.</p>
     *
     */
    public final void idle() {
        // Otherwise, yield back our thread scheduling quantum and give other threads at
        // our priority level a chance to run
        Thread.yield();
    }
    @Override final public void loop() { }
    @Override final public void init() { }


    void newGamepadDataAvailable(Gamepad latestGamepad1Data, Gamepad latestGamepad2Data) {
        // For LinearOpMode, we want the new gamepad data to be available to the user ASAP
        // We copy the data instead of replacing the gamepad instances because the gamepad instances
        // may contain queued effect data.
        gamepad1.copy(latestGamepad1Data);
        gamepad2.copy(latestGamepad2Data);
    }
}
