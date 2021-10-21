package com.jatin.producttracker.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * Utility class that deals with common Intents used in the app
 *
 * @author Jatin C Shihora*/
public class IntentUtility {

    //URI Scheme Constants
    private static final String URI_STR_TELEPHONE_SCHEME = "tel:";
    private static final String URI_STR_EMAIL_SCHEME = "mailto:";

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

    /**
     * Method that creates an Intent to the Phone Dialer to initiate a Phone Call.
     *
     * @param activity    The {@link FragmentActivity} instance initiating this.
     * @param phoneNumber The Phone Number to dial
     */
    public static void dialPhoneNumber(FragmentActivity activity, String phoneNumber) {
        //Creating a Phone Dialer Intent
        Intent intent = new Intent(Intent.ACTION_DIAL);
        //Setting the Phone number Uri
        intent.setData(Uri.parse(URI_STR_TELEPHONE_SCHEME + phoneNumber));
        //Checking for an Activity that can handle this Intent
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            //Starting the activity that handles the given Intent
            activity.startActivity(intent);
        }
    }

    /**
     * Method that creates an Email Intent with no attachments to compose an Email.
     *
     * @param activity    The {@link FragmentActivity} instance initiating this.
     * @param toAddresses String array of "TO" Addresses
     * @param ccAddresses String array of "CC" Addresses
     * @param subject     String containing the Subject of the Email
     * @param body        String containing the Body of the Email
     */
    public static void composeEmail(FragmentActivity activity, String[] toAddresses,
                                    @Nullable String[] ccAddresses, @Nullable String subject,
                                    @Nullable String body) {
        //Creating an Email Intent with no attachments
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        //Only email apps should handle this
        intent.setData(Uri.parse(URI_STR_EMAIL_SCHEME));
        //Passing To Addresses
        intent.putExtra(Intent.EXTRA_EMAIL, toAddresses);
        //Passing CC Addresses
        intent.putExtra(Intent.EXTRA_CC, ccAddresses);
        //Passing Subject
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        //Checking if the Body of the Email is passed
        if (!TextUtils.isEmpty(body)) {
            //Passing Email content with Html Formatted text
            intent.putExtra(Intent.EXTRA_TEXT, TextAppearanceUtility.getHtmlFormattedText(body));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                intent.putExtra(Intent.EXTRA_HTML_TEXT, TextAppearanceUtility.getHtmlFormattedText(body));
            }
        }

        //Checking for an Activity that can handle this Intent
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            //Starting the activity that handles the given Intent
            activity.startActivity(intent);
        }
    }

}
