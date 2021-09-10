package com.jatin.producttracker.utils;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import androidx.fragment.app.FragmentActivity;

/**
 * Screen Orientation Utility class that deals with the screen orientation functions.
 *
 * @author Jatin C Shihora
 */
public final class OrientationUtility {

    /**
     * Private constructor to avoid instantiating {@link OrientationUtility}
     */
    private OrientationUtility() {
        //Suppressing with an error to enforce noninstantiability
        throw new AssertionError("No " + this.getClass().getCanonicalName() + " instances for you!");
    }

    /**
     * Method that retrieves the current screen orientation and tells whether the
     * orientation is in Portrait {@link Configuration#ORIENTATION_PORTRAIT} mode or not.
     *
     * @param context {@link Context} to read the orientation
     * @return Boolean that indicates the current screen orientation of the device.
     * <b>TRUE</b> if the device is in Portrait mode; <b>FALSE</b> otherwise.
     */
    public static boolean isDeviceInPortraitMode(Context context) {
        //Retrieving the current orientation
        int screenOrientation = context.getResources().getConfiguration().orientation;

        //Return the evaluation of screenOrientation
        return (screenOrientation == Configuration.ORIENTATION_PORTRAIT);
    }

    /**
     * Method that locks the current screen orientation of the device.
     *
     * @param activity The {@link FragmentActivity} instance requesting the lock.
     */
    public static void lockCurrentScreenOrientation(FragmentActivity activity) {
        //Retrieving the current orientation
        int screenOrientation = activity.getResources().getConfiguration().orientation;

        //Locking the screen orientation to current orientation
        if (screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
            //For Portrait Mode
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        } else if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            //For Landscape Mode
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }
    }

    /**
     * Method that unlocks the screen orientation lock applied.
     *
     * @param activity The {@link FragmentActivity} instance requesting the unlock.
     */
    public static void unlockScreenOrientation(FragmentActivity activity) {
        //Setting the screen orientation to sensor's orientation for unlocking
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
    }
}