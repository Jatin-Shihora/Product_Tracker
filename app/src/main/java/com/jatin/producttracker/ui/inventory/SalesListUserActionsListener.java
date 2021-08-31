package com.jatin.producttracker.ui.inventory;

import android.widget.ImageView;

import com.jatin.producttracker.data.local.models.SalesLite;

/**
 * Interface to be implemented by {@link SalesListFragment}
 * to receive callback events for User actions on RecyclerView list of Products for selling
 *
 * @author Jatin C Shihora
 * */
public interface SalesListUserActionsListener {
        /**
         * Callback Method of {@link SalesListUserActionsListener} invoked when the user clicks on the Item View itself
         * This should launch {@link com.jatin.producttracker.ui.inventory.config.SalesConfigActivity}
         * for editing the Sales data of the product identified by {@link com.jatin.producttracker.data.local.models.SalesLite#mProductId}.
         *
         * @param itemPosition          The adapter position of the Item View Clicked
         * @param salesLite             The {@link com.jatin.producttracker.data.local.models.SalesLite} associated with Item View clicked
         * @param imageViewProductPhoto The ImageView of the Adapter item that displays the image
         * */
        void onEditSales(final int itemPosition, SalesLite salesLite, ImageView imageViewProductPhoto);

        /**
         * Callback Method of {@link SalesListUserActionsListener} invoked when
         * the user clicks on the "Delete Product" button. This should delete the Product
         * identified by {@link SalesLite#mProductId} from the database along with its relationship
         * with other tables in database.
         *
         * @param itemPosition The adapter position of the Item View clicked.
         * @param salesLite    The {@link SalesLite} associated with the Item View clicked.
         */
        void onDeleteProduct(final int itemPosition, SalesLite salesLite);

        /**
         * Callback Method of {@link SalesListUserActionsListener} invoked when
         * the user clicks on the "Sell 1" button. This should decrease the Available Quantity
         * from the Top Supplier {@link SalesLite#mSupplierAvailableQuantity} by 1, indicating one Quantity
         * of the Product was sold/shipped.
         *
         * @param itemPosition The adapter position of the Item View clicked.
         * @param salesLite    The {@link SalesLite} associated with the Item View clicked.
         */
        void onSellOneQuantity(final int itemPosition, SalesLite salesLite);


}
