package com.jatin.producttracker.ui.inventory.config;


import android.widget.ImageView;

import static android.app.Activity.*;

/**
 * Activity that inflates the layout 'R.layout.activity_sales_config' which displays a content fragment
 * inflated by {@@link SalesConfigActivityFragment}
 * This allows to configure the inventory of the product and also procurement request across
 * the listed Suppliers of the the Product.
 *
 * @author Jatin C Shihora
 * */
public class SalesConfigActivity {
    //Request codes used by the activity that cells this activity for result
    public static final int REQUEST_EDIT_SALES = 60; //61 is reserved for the result of this request

    //Custom Result Codes for Edit operation (61)
    public static final int RESULT_EDIT_SALES = RESULT_FIRST_USER + REQUEST_EDIT_SALES;

    //Intent Extra constant for retrieving the Product ID from the Parent SalesListFragment
    public static final String EXTRA_PRODUCT_ID = SalesConfigActivity.class.getPackage() + "extra.PRODUCT_ID";

    //Intent Extra constant for passing the Result information of Product Id to the Calling Activity
    public static final String EXTRA_RESULT_PRODUCT_ID = SalesConfigActivity.class.getPackage() + "extra.PRODUCT_ID";
    //Intent Extra constant for passing the Result information of Product SKU to the Calling Activity
    public static final String EXTRA_RESULT_PRODUCT_SKU = SalesConfigActivity.class.getPackage() + "extra.PRODUCT_SKU";

    //The Presenter for this View's Content Fragment
//    private SalesConfigContract.Presenter mPresenter;

    //The ImageView to show the default photo of the Product
    private ImageView mImageViewItemPhoto;

    //Boolean to postpone/start the Shared Element enter transition
    private boolean mIsEnterTransitionPostponed;
}
