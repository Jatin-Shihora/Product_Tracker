package com.jatin.producttracker.ui.suppliers.config;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;

import com.jatin.producttracker.data.local.models.ProductLite;
import com.jatin.producttracker.ui.products.config.ProductConfigActivity;

import java.util.ArrayList;

/**
 * Defines Navigation Actions that can be invoked from {@link SupplierConfigActivity}
 *
 * @author Jatin C Shihora
 */
public interface SupplierConfigNavigator {

    /**
     * Method that updates the result {@code resultCode} to be sent back to the Calling Activity
     *
     * @param resultCode   The integer result code to be returned to the Calling Activity.
     * @param supplierId   Integer containing the Id of the Supplier involved.
     * @param supplierCode String containing the Supplier Code of the Supplier involved.
     */
    void doSetResult(final int resultCode, final int supplierId, @NonNull final String supplierCode);

    /**
     * Method that updates the Calling Activity that the operation was aborted.
     */
    void doCancel();

    /**
     * Method invoked when the user clicks on any Item View of the Products sold by the Supplier. This should
     * launch the {@link ProductConfigActivity}
     * for the Product to be edited.
     *
     * @param productId             The Primary Key of the Product to be edited.
     * @param activityOptionsCompat Instance of {@link ActivityOptionsCompat} that has the
     *                              details for Shared Element Transition
     */
    void launchEditProduct(int productId, ActivityOptionsCompat activityOptionsCompat);

    /**
     * Method invoked when the user clicks on the "Add Item" button, present under "Supplier Items"
     * to add/link items to the Supplier. This should launch the
     * {@link SupplierProductPickerActivity}
     * to pick the Products for the Supplier to sell.
     *
     * @param productLiteList ArrayList of Products {@link ProductLite} already picked for the Supplier to sell.
     */
    void launchPickProducts(ArrayList<ProductLite> productLiteList);

}