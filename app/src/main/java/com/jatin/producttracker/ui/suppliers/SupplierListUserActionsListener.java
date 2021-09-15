package com.jatin.producttracker.ui.suppliers;

import com.jatin.producttracker.data.local.models.SupplierLite;
import com.jatin.producttracker.ui.suppliers.config.SupplierConfigActivity;

/**
 * Interface to be implemented by {@link SupplierListFragment}
 * to receive callback events for User actions on RecyclerView list of Suppliers
 *
 * @author Jatin C Shihora
 */
public interface SupplierListUserActionsListener {

    /**
     * Callback Method of {@link SupplierListUserActionsListener} invoked when
     * the user clicks on "Edit" button or the Item View itself. This should
     * launch the {@link SupplierConfigActivity}
     * for the Supplier to be edited.
     *
     * @param itemPosition The adapter position of the Item View clicked
     * @param supplier     The {@link SupplierLite} associated with the Item View clicked.
     */
    void onEditSupplier(final int itemPosition, SupplierLite supplier);

    /**
     * Callback Method of {@link SupplierListUserActionsListener} invoked when
     * the user clicks on "Delete" button. This should delete the Supplier
     * identified by {@link SupplierLite mId}, from the database.
     *
     * @param itemPosition The adapter position of the Item View clicked
     * @param supplier     The {@link SupplierLite} associated with the Item View clicked.
     */
    void onDeleteSupplier(final int itemPosition, SupplierLite supplier);

    /**
     * Callback Method of {@link SupplierListUserActionsListener} invoked when
     * the user clicks on the default Phone shown. This should launch an Intent
     * to start the Phone Activity passing in the number {@link SupplierLite mDefaultPhone}.
     *
     * @param itemPosition The adapter position of the Item View clicked
     * @param supplier     The {@link SupplierLite} associated with the Item View clicked.
     */
    void onDefaultPhoneClicked(final int itemPosition, SupplierLite supplier);

    /**
     * Callback Method of {@link SupplierListUserActionsListener} invoked when
     * the user clicks on the default Email shown. This should launch an Intent
     * to start an Email Activity passing in the To address {@link SupplierLite mDefaultEmail}.
     *
     * @param itemPosition The adapter position of the Item View clicked
     * @param supplier     The {@link SupplierLite} associated with the Item View clicked.
     */
    void onDefaultEmailClicked(final int itemPosition, SupplierLite supplier);
}
