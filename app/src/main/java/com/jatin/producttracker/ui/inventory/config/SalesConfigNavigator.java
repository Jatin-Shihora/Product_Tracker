package com.jatin.producttracker.ui.inventory.config;

import androidx.annotation.NonNull;

import com.jatin.producttracker.data.local.models.ProductImage;
import com.jatin.producttracker.data.local.models.ProductSupplierSales;
import com.jatin.producttracker.ui.inventory.procure.SalesProcurementActivity;
import com.jatin.producttracker.ui.products.config.ProductConfigActivity;
import com.jatin.producttracker.ui.suppliers.config.SupplierConfigActivity;

/**
 * Defines Navigation Actions that can be invoked from {@link SalesConfigActivity}
 *
 * @author Jatin C Shihora
 */
public interface SalesConfigNavigator {

    /**
     * Method that updates the result {@code resultCode} to be sent back to the Calling Activity
     *
     * @param resultCode The integer result code to be returned to the Calling Activity.
     * @param productId  Integer containing the Id of the Product involved.
     * @param productSku String containing the SKU information of the Product involved.
     */
    void doSetResult(final int resultCode, final int productId, @NonNull final String productSku);

    /**
     * Method that updates the Calling Activity that the operation was aborted.
     */
    void doCancel();

    /**
     * Method invoked when the user clicks on Edit button of the Product Details. This should
     * launch the {@link ProductConfigActivity}
     * for the Product to be edited.
     *
     * @param productId The Primary Key of the Product to be edited.
     */
    void launchEditProduct(int productId);

    /**
     * Method invoked when the user clicks on the "Procure" button of the Item View of any Product's Suppliers.
     * This should launch the {@link SalesProcurementActivity}
     * for the User to place procurement for the Product.
     *
     * @param productSupplierSales  The {@link ProductSupplierSales} associated with the Item clicked.
     * @param productImageToBeShown The defaulted {@link ProductImage} of the Product.
     * @param productName           The Name of the Product.
     * @param productSku            The SKU of the Product.
     */
    void launchProcureProduct(ProductSupplierSales productSupplierSales, ProductImage productImageToBeShown, String productName, String productSku);

    /**
     * Method invoked when the user clicks on "Edit" button. This should
     * launch the {@link SupplierConfigActivity}
     * for the Supplier to be edited.
     *
     * @param supplierId The Primary key of the Supplier to be edited.
     */
    void launchEditSupplier(int supplierId);
}
