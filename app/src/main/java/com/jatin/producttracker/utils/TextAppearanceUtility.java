package com.jatin.producttracker.utils;

import android.os.Build;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 * Utility class for Text Appearance related modifications done using classes like (@link spannable)
 *
 * @author Jatin C Shihora
 * */
public final class TextAppearanceUtility {

    /**
     * private constructor to avoid instantiating {@link TextAppearanceUtility}
     */
    private TextAppearanceUtility(){
        //Suppressing with an error to enforce noninstantiability
        throw new AssertionError("No "+this.getClass().getCanonicalName()+ " instance for you");
    }

    /**
     * Method that sets the Html Text Content on the TextView passed
     *
     * @param textView is the textView in which the Html content needs to be set
     * @param htmlTextToSet is the string containing the html markup that needs to be set in the TextView
     */
    public static void setHtmlText(TextView textView, String htmlTextToSet){
        //Initializing a SpannableStringBuilder to build the text
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            //For android N and above
            spannableStringBuilder.append(Html.fromHtml(htmlTextToSet,Html.FROM_HTML_MODE_COMPACT));
        }else {
            //For Older Versions
            spannableStringBuilder.append(Html.fromHtml(htmlTextToSet));
        }
        //Setting the spannable Text on TextView with the SPANNABLE Buffer type ,
        //For later modification on spanner if required
        textView.setText(spannableStringBuilder,TextView.BufferType.SPANNABLE);
    }

    /**
     *Method that prepares and return thee Html Formatted text String passed {@code textWithHtmlContent}
     *
     * @param textWithHtmlContent The Text that contains Html Markups which needs to be formatted for Html
     * @return String containing the Html formatted text of {@code textWithHtmlContent}
     */
    @NonNull
    public static String getHtmlFormattedText(String textWithHtmlContent){
        //Initializing a SpannableStringBuilder to build the text
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //For Android N and above
            spannableStringBuilder.append(Html.fromHtml(textWithHtmlContent, Html.FROM_HTML_MODE_COMPACT));
        } else {
            //For older versions
            spannableStringBuilder.append(Html.fromHtml(textWithHtmlContent));
        }
        //Returning the Formatted Html Text
        return spannableStringBuilder.toString();
    }
}
