package com.jatin.producttracker.ui.suppliers.product;

/**
 * Interface to be implemented by {@link SupplierProductPickerActivity} to receive
 * callback events for User select/pick actions on the RecyclerView List of Products.
 *
 * @author Jatin C Shihora
 */
public interface SupplierProductPickerMultiSelectListener {
    /**
     * Callback Method of {@link SupplierProductPickerMultiSelectListener} invoked to
     * display the number of Products {@code countOfProductsSelected} selected for the Supplier to sell.
     *
     * @param countOfProductsSelected The Number of Products selected/picked for the Supplier to sell.
     */
    void showSelectedCount(int countOfProductsSelected);
}