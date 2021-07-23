package com.jatin.producttracker.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Utility class that deals with common Intents used in the app
 *
 * @author Jatin C Shihora*/
public class IntentUtility {

    /**
     * Private constructor to avoid instantiating {@link IntentUtility}
     */
    private IntentUtility() {
        //Suppressing with an error to enforce noninstantiability
        throw new AssertionError("No " + this.getClass().getCanonicalName() + " instances for you!");
    }

    /**Method that opens a WebPage for the URL passed
     *
     * @param context is the Context of the Calling Activity/Fragment
     * @param webUrl is the String containing the URL of the WEB page to be launched
     * */
    public static void openLink(Context context,String webUrl){
        //Parsing the Url
        Uri webPageUri=Uri.parse(webUrl);
        //Creating an ACTION_VIEW Intent with the Uri
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webPageUri);
        //Checking if there is an Activity that accepts the Intent
        if(webIntent.resolveActivity(context.getPackageManager()) != null){
            //Launching the corresponding Activity an passing it the Intent
            context.startActivity(webIntent);
        }
    }

}
