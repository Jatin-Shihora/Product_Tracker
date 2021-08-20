package com.jatin.producttracker.utils;

import com.jatin.producttracker.BuildConfig;

/**
 * Class that maintains global app constants
 *
 * @author Jatin C Shihora
 * */
public final class AppConstants {
    /**
     * Private Constructors to avoid direct instantiation of {@link AppConstants}
     * */
    private AppConstants(){
        //Suppressing with an error to to enforce noninstantiability
        throw new AssertionError("No "+this.getClass().getCanonicalName()+" instances for you!");
    }

    //Constant for Application id
    public static final String APPLICATION_ID = BuildConfig.APPLICATION_ID;

    //Constants for logging Cursor Queries
//    public static final boolean LOG_CURSOR_QUERIES = BuildConfig.LOG_CURSOR_QUERIES;

    //Constants for logging Stetho
//    public static final boolean LOG_STETHO = BuildConfig.LOG_STETHO;

    //Constant used for the CursorLoader to load the list of Products from the database
    public static final int PRODUCTS_LOADER = 1;

    //Constant used for the CursorLoader to load the list of Suppliers from the database
    public static final int SUPPLIERS_LOADER = 2;

    //Constant used for the CursorLoader to load the list of Products for Selling from the database
    public static final int SALES_LOADER = 3;

}
