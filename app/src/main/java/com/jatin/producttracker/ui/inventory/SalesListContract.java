package com.jatin.producttracker.ui.inventory;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.ActivityOptionsCompat;

import com.jatin.producttracker.data.local.models.SalesLite;
import com.jatin.producttracker.ui.PagerPresenter;
import com.jatin.producttracker.ui.PagerView;
import com.jatin.producttracker.ui.inventory.config.SalesConfigActivity;

import java.util.ArrayList;

/**
 * Contract Interface for the View {@link SalesListFragment} and its Presenter {@link SalesListPresenter}
 *
 * @author Jatin C Shihora
 * */
public interface SalesListContract {

    /**
     * The View Interface implemented by {@link SalesListFragment}
     * */
    interface View extends PagerView<Presenter>{

        /**
         * Method that displays Progress Indicator
         * */
        void showProgressIndicator();

        /**
         * Method that hides the Progress Indicator.
         * */
        void hideProgressIndicator();

        /**
         * Method invoked when an error is encountered during Sales Information retrieval or delete process
         *
         * @param messageId String Resource of the error Message to be displayed.
         * @param args      Variable number of arguments to replace the format specifiers in the String resource if any.
         * */
        void showError(@StringRes int messageId, @Nullable Object... args);

        /**
         * Method invoked when the Sales List Empty .This should show a TextView with a Text that suggests
         * Users to first configure Products and its Suppliers into the database
         * */
        void showEmptyView();

        /**
         * Method invoked when we have the Sales List. This should show the Sales List and hide
         * the Empty List TextView and Step Number Drawable
         * */
        void hideEmptyView();

        /**
         * Method that updates the RecyclerView's Adapter with new {@code salesList} data.
         *
         * @param salesList List of Products with Sales data defined by {@link SalesLite},
         *                  loaded from the database.
         * */
        void loadSalesList(ArrayList<SalesLite> salesList);

        /**
         * Method that displays a message on Success of Deleting an existing project.
         *
         * @param productSku String containing the SKU of the product that was deleted Successfully.
         * */
        void showDeleteSuccess(String productSku);

        /**
         * Method that displays a message on Success of updating the Inventory of the product.
         *
         * @param productSku String containing the SKU of the Product that was updated with Inventory successful.
         * */
        void showUpdateInventorySuccess(String productSku);

        /**
         * Method that displays a message on Success of Selling a quantity of the Product
         * from the Top Supplier.
         *
         * @param productSku   The Product SKU of the Product sold.
         * @param supplierCode The Supplier Code of the Top Supplier for the Product sold.
         */
        void showSellQuantitySuccess(String productSku, String supplierCode);

        /**
         * Method invoked when the user clicks on the Item View itself. This should launch the
         * {@link SalesConfigActivity} for editing the Sales data of the Product.
         *
         * @param productId     The Primary Key of the Product to be edited .
         * @param activityOptionsCompat Instance of {@link androidx.core.app.ActivityOptionsCompat} that has the details for Shared
         *                              Element Transition
         * */
        void launchEditProductSales(int productId, ActivityOptionsCompat activityOptionsCompat);

    }

    /***
     * The Presenter Interface implemented by {@link SalesListPresenter}.
     */
    interface Presenter extends PagerPresenter{
        /**
         * Method that triggers the CursorLoader to load the Products with Sales data from the database
         *
         * @param forceLoad Boolean value that controls the nature of the trigger
         *                  <br/><b>TRUE</b> to forcefully start a new load process
         *                  <br/><b>FALSE</b> to start a new/existing load process
         */
        void triggerProductSalesLoad(boolean forceLoad);

        /**
         * Method invoked when there is a change in the data pointed to by the Products URI
         * {@link com.jatin.producttracker.data.local.contracts.ProductContract.Product#CONTENT_URI}
         * */
        void onProductContentChange();

        /**
         * Method invoked when the view is about to get destroyed.
         * This method should release any critical resources held by the Presenter.
         * */
        void releaseResources();

        /**
         * Method invoked when the user clicks on the "Delete Product" button.
         * This should delete the Product identified by {@code productId} from the database
         * along with its relationship with other tables in database.
         *
         * @param productId  The product id/primary key of the product to be deleted .
         * @param productSku The product SKU of the Product to be deleted.
         * */
        void deleteProduct(int productId, String productSku);

        /**
         * Method invoked when the users clicks on the "sell 1" button.
         * This should decrease the Available Quantity from the Top Supplier
         * {@link SalesLite##mSupplierAvailableQuantity} by 1 , indicating one Quantity of
         * the Product was sold/shipped
         *
         * @param salesLite The {@link SalesLite} instance containing the Product Supplier information
         *                  with availability
         * */
        void sellOneQuantity(SalesLite salesLite);

        /**
         * Invoked from a previous call to {@link androidx.fragment.app.FragmentActivity#startActivityForResult(Intent, int)}.
         *
         * @param requestCode The integer request code originally supplied to startActivityForResult(),
         *                    allowing you to identify who this result came from
         * @param resultCode  The integer result code returned by the child activity
         *                    through its setResult()
         * @param data        An Intent, which can return result data to the caller
         *                    (various data can be attached to Intent "extras").
         * */
        void onActivityResult(int requestCode,int resultCode,Intent data);

        /**
         * Method Invoked when the user clicks on the Item View itself. This should launch the
         * {@link SalesConfigActivity} for editing the Sales data of the product.
         *
         * @param productId             The Primary Key of the Product to be edited.
         * @param activityOptionsCompat Instance of {@link ActivityOptionsCompat} that has the
         *                              details for Shared Element Transition .
         * */
        void editProductSales(int productId,ActivityOptionsCompat activityOptionsCompat);
    }
}
