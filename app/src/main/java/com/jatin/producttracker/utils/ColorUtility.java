package com.jatin.producttracker.utils;

import android.content.Context;
import android.content.res.TypedArray;

import androidx.annotation.ArrayRes;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;

/**
 * Utility Class that deals with reading and modifying Colors
 *
 * @author Jatin C Shihora
 * */
public class ColorUtility {
    /**
     * Private Constructor to avoid direct instantiation of {@link ColorUtility}
     * */
    private ColorUtility(){
        //Suppressing with an error to enforce noninstantiability
        throw new AssertionError("No "+this.getClass().getCanonicalName() + " instance for you!");
    }

    /**
     * Method that reads the Typed Array {@code colorArrayRes} and returns an Integer array of Colors read.
     *
     * @param context         The {@link android.content.Context} to use for reading the {@link android.content.res.TypedArray}
     *                        and retrieving the Colors from Color Resource {@link androidx.annotation.ColorRes}
     * @param colorArrayRes   The {@link android.content.res.TypedArray} resource of Colors to be read
     * @param defaultColorRes The Integer value of the Color Resource {@link androidx.annotation.ColorRes} to use as a default color
     *                        in case when attribute cannot be read from TypedArray or is not a defined resource
     * @return Integer array of the Colors read from the {@link android.content.res.TypedArray}
     * */
    public static int[] obtainColorsFromTypedArray(Context context, @ArrayRes int colorArrayRes, @ColorRes int defaultColorRes) {
        //Obtaining the Typed Array of Colors from the Resources
        TypedArray typedArrayColors = context.getResources().obtainTypedArray(colorArrayRes);
        //Get the number of Colors
        int noOfColors = typedArrayColors.length();
        //Creating an integer array for the size
        int[] colors = new int[noOfColors];
        //Retrieving the default color from the resources
        int defaultColorInt = ContextCompat.getColor(context, defaultColorRes);
        //Iterating over the TypedArray to get the colors
        for (int index = 0; index < noOfColors; index++) {
            colors[index] = typedArrayColors.getColor(index, defaultColorInt);
        }
        //Release the TypedArray resource
        typedArrayColors.recycle();
        //Returning the colors read from the TypedArray
        return colors;
    }
}
