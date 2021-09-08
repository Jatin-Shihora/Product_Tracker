package com.jatin.producttracker.ui.products.config;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.AppBarLayout;
import com.jatin.producttracker.R;

/**
 * Activity that inflates the layout 'R.layout.activity_product_config' which
 * displays a content fragment inflated by {@@link ProductConfigActivityFragment}.
 * This allows to configure a New Product in the database and also edit an existing Product.
 *
 * @author Jatin C Shihora
 */
public class ProductConfigActivity extends AppCompatActivity {
    //Request codes used by the activity that calls this activity for result
    public static final int REQUEST_ADD_PRODUCT = 20; //21 is reserved for the result of this request
    public static final int REQUEST_EDIT_PRODUCT = 22; //23, 24 are reserved for the result of this request

    //Custom Result Codes for Add operation
    public static final int RESULT_ADD_PRODUCT = REQUEST_ADD_PRODUCT + RESULT_FIRST_USER;
    //Custom Result Codes for Edit(23) and Delete(24) operations
    public static final int RESULT_EDIT_PRODUCT = REQUEST_EDIT_PRODUCT + RESULT_FIRST_USER;
    public static final int RESULT_DELETE_PRODUCT = RESULT_EDIT_PRODUCT + RESULT_FIRST_USER;

    //Intent Extra constant for retrieving the Product ID from the Parent ProductListFragment
    public static final String EXTRA_PRODUCT_ID = ProductConfigActivity.class.getPackage() + "extra.PRODUCT_ID";

    //Intent Extra constant for passing the Result information of Product Id to the Calling Activity
    public static final String EXTRA_RESULT_PRODUCT_ID = ProductConfigActivity.class.getPackage() + "extra.PRODUCT_ID";
    //Intent Extra constant for passing the Result information of Product SKU to the Calling Activity
    public static final String EXTRA_RESULT_PRODUCT_SKU = ProductConfigActivity.class.getPackage() + "extra.PRODUCT_SKU";

    //The ImageView to show the default photo of the Product
    private ImageView mImageViewItemPhoto;

    //The App Bar to expand and collapse the Photo shown
    private AppBarLayout mAppBarLayout;

    //Boolean to postpone/start the Shared Element enter transition
    private boolean mIsEnterTransitionPostponed;

    /**
     * Called when the activity is starting.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inflating the activity's layout
        setContentView(R.layout.activity_product_config);

        //Find the AppBar
        mAppBarLayout = findViewById(R.id.app_bar_product_config);
        //Find the ImageView for the default photo of the product
        mImageViewItemPhoto = findViewById(R.id.image_product_config_item_photo);

    }


}
