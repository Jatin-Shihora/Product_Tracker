package com.jatin.producttracker.data.local.contracts;

import android.net.Uri;

/**
 * Marker interface for the constants that identify the Content Provider
 *
 * @author Jatin C Shihora
 * */
public interface StoreContract {

    //The Authority constant of the Content Provider
    String CONTENT_AUTHORITY= "com.jatin.producttracker.provider";

    //The Base URI constant to contact the content provider
    Uri BASE_CONTENT_URI = Uri.parse("content://" +CONTENT_AUTHORITY);
}