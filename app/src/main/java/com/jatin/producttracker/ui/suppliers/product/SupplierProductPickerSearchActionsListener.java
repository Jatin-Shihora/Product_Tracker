package com.jatin.producttracker.ui.suppliers.product;

/**
 * Interface to be implemented by {@link SupplierProductPickerActivity}
 * to receive callback events for User Search actions on the RecyclerView list of Products.
 *
 * @author Jatin C Shihora
 */
public interface SupplierProductPickerSearchActionsListener {
    /**
     * Callback Method of {@link SupplierProductPickerSearchActionsListener} invoked when
     * all the Products available, are already picked for the Supplier. Hence the implementation
     * should disable the Search.
     */
    void disableSearch();
}