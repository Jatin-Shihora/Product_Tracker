package com.jatin.producttracker.ui.suppliers.config;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jatin.producttracker.R;

/**
 * Activity that inflates the layout 'R.layout.activity_supplier_config' which
 * displays a content fragment inflated by {}.
 * This allows to configure a New Supplier in the database and also edit an existing Supplier.
 *
 * @author Jatin C Shihora
 */
public class SupplierConfigActivity extends AppCompatActivity {

    //Request codes used by the activity that calls this activity for result
    public static final int REQUEST_ADD_SUPPLIER = 40; //41 is reserved for the result of this request
    public static final int REQUEST_EDIT_SUPPLIER = 42; //43, 44 are reserved for the results of this request

    //Custom Result Codes for Add operation
    public static final int RESULT_ADD_SUPPLIER = REQUEST_ADD_SUPPLIER + RESULT_FIRST_USER;
    //Custom Result Codes for Edit(43) and Delete(44) operations
    public static final int RESULT_EDIT_SUPPLIER = REQUEST_EDIT_SUPPLIER + RESULT_FIRST_USER;
    public static final int RESULT_DELETE_SUPPLIER = RESULT_EDIT_SUPPLIER + RESULT_FIRST_USER;

    //Intent Extra constant for retrieving the Supplier ID from the Parent SupplierListFragment
    public static final String EXTRA_SUPPLIER_ID = SupplierConfigActivity.class.getPackage() + "extra.SUPPLIER_ID";

    //Intent Extra constant for passing the Result information of Supplier ID to the Calling Activity
    public static final String EXTRA_RESULT_SUPPLIER_ID = SupplierConfigActivity.class.getPackage() + "extra.SUPPLIER_ID";
    //Intent Extra constant for passing the Result information of Supplier Code to the Calling Activity
    public static final String EXTRA_RESULT_SUPPLIER_CODE = SupplierConfigActivity.class.getPackage() + "extra.SUPPLIER_CODE";



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
        setContentView(R.layout.activity_supplier_config);


    }










}