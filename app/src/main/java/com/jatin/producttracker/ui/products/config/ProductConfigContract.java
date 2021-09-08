package com.jatin.producttracker.ui.products.config;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.jatin.producttracker.data.local.models.ProductAttribute;
import com.jatin.producttracker.data.local.models.ProductImage;
import com.jatin.producttracker.ui.BasePresenter;
import com.jatin.producttracker.ui.BaseView;
import com.jatin.producttracker.ui.inventory.SalesListContract;
import com.jatin.producttracker.ui.products.ProductListContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Contract Interface for the View {@@link ProductConfigActivityFragment} and its Presenter {@@link ProductConfigPresenter}.
 *
 * @author Jatin C Shihora
 */
public interface ProductConfigContract {
    //Integer Constant used as the Product ID for New Product Configuration
    int NEW_PRODUCT_INT = -1;
    //Constant for custom Category "Other" option
    String CATEGORY_OTHER = "Other";

    /**
     * View Interface implemented by {@@link ProductConfigActivityFragment}
     */
    interface View extends BaseView<ProductListContract.Presenter> {
        /**
         * Method that updates the categories list to the spinner for configuration
         *
         * @param categories The list of categories available
         */
        void updateCategories(List<String> categories);

        /**
         * Method that displays the EditText Field associated with the 'Other' Category
         * selected by the user.
         */
        void showCategoryOtherEditTextField();

        /**
         * Method that hides the EditText Field of 'Other' Category when a predefined category
         * is selected by the user.
         */
        void hideCategoryOtherEditTextField();

        /**
         * Method that clears the EditText Field associated with the 'Other' Category
         */
        void clearCategoryOtherEditTextField();

        /**
         * Method invoked when required fields are missing data, on click of 'Save' Menu button.
         */
        void showEmptyFieldsValidationError();

        /**
         * Method invoked when either fields that make the {@link com.jatin.producttracker.data.local.models.ProductAttribute} is missing.
         */
        void showAttributesPartialValidationError();

        /**
         * Method invoked when the {@link @link com.jatin.producttracker.data.local.models.ProductAttribute} identified by the Attribute Name {@code attributeName}
         * is already defined.
         *
         * @param attributeName The Attribute Name of the {@link @link com.jatin.producttracker.data.local.models.ProductAttribute} that has been repeated.
         */
        void showAttributeNameConflictError(String attributeName);

        /**
         * Method that displays the Progress indicator
         *
         * @param statusTextId String resource for the status of the Progress to be shown.
         */
        void showProgressIndicator(@StringRes int statusTextId);

        /**
         * Method that hides the Progress indicator
         */
        void hideProgressIndicator();

        /**
         * Method invoked when an error is encountered during Product information
         * retrieval or save process.
         *
         * @param messageId String Resource of the error Message to be displayed
         * @param args      Variable number of arguments to replace the format specifiers
         *                  in the String resource if any
         */
        void showError(@StringRes int messageId, @Nullable Object... args);

        /**
         * Method invoked when the Product SKU entered by the user is NOT Unique
         * causing the conflict.
         */
        void showProductSkuConflictError();

        /**
         * Method invoked when NO Product SKU was entered by the user.
         */
        void showProductSkuEmptyError();

        /**
         * Method that updates the Product Name {@code name} to the View
         *
         * @param name The Name of the Product
         */
        void updateProductNameField(String name);

        /**
         * Method that updates the Product SKU {@code sku} to the View
         *
         * @param sku The SKU of the Product
         */
        void updateProductSkuField(String sku);

        /**
         * Method that locks the Product SKU field to prevent updates on this field
         */
        void lockProductSkuField();

        /**
         * Method that updates the Product Description {@code description} to the View
         *
         * @param description The description of the Product
         */
        void updateProductDescriptionField(String description);

        /**
         * Method that updates the List of Product Attributes {@code productAttributes} to the View
         *
         * @param productAttributes The List of {@link @link com.jatin.producttracker.data.local.models.ProductAttribute} of a Product
         */
        void updateProductAttributes(ArrayList<ProductAttribute> productAttributes);

        /**
         * Method that updates the List of Product Images {@code productImages} to the View
         *
         * @param productImages The List of {@link ProductImage} of a Product.
         */
        void updateProductImages(ArrayList<ProductImage> productImages);

        /**
         * Method that updates the Product Category to the View.
         *
         * @param selectedCategory  The selected Category of the Product
         * @param categoryOtherText The Category OTHER EditText field value, in the case where the Product Category
         *                          was not available from the Predefined list of Categories.
         */
        void updateCategorySelection(String selectedCategory, @Nullable String categoryOtherText);

        /**
         * Method invoked to keep the state of "Existing Product details restored", in sync with the Presenter.
         *
         * @param isExistingProductRestored Boolean that indicates the state of Existing Product data restored.
         *                                  <b>TRUE</b> if it had been restored; <b>FALSE</b> otherwise.
         */
        void syncExistingProductState(boolean isExistingProductRestored);

        /**
         * Method invoked to keep the state of "Product SKU Validity", in sync with the Presenter.
         *
         * @param isProductSkuValid Boolean that indicates whether the Product SKU entered was valid or not.
         *                          <b>TRUE</b> if the Product SKU is valid; <b>FALSE</b> otherwise.
         */
        void syncProductSkuValidity(boolean isProductSkuValid);

        /**
         * Method invoked to keep the state of "Product Name entered", in sync with the Presenter.
         * This is used for monitoring unsaved progress.
         *
         * @param isProductNameEntered Boolean that indicates whether the Product Name has been entered by the User or not.
         *                             <b>TRUE</b> if the Product Name is entered; <b>FALSE</b> otherwise.
         */
        void syncProductNameEnteredState(boolean isProductNameEntered);

        /**
         * Method invoked by the Presenter to display the Discard dialog,
         * requesting the User whether to keep editing/discard the changes
         */
        void showDiscardDialog();

        /**
         * Method invoked when the user clicks on the Delete Menu Action to delete the Product.
         * This should launch a Dialog for the user to reconfirm the request before proceeding
         * with the Delete Action.
         */
        void showDeleteProductDialog();

        /**
         * Method invoked before save operation or screen orientation change to persist
         * any data held by the view that had focus and its listener registered.
         * This clears the focus held by the view to trigger the listener, causing to persist any unsaved data.
         */
        void triggerFocusLost();

        /**
         * Method invoked to display a message on successful update/erase of the {@link ProductImage}s list.
         * This method will be invoked when the ProductImages are changed for an Existing Product,
         * immediately after returning from
         * the {@@link ProductImageActivity}
         */
        void showUpdateImagesSuccess();
    }

    /**
     * Presenter Interface implemented by {@@link ProductConfigPresenter}
     * */
    interface Presenter extends BasePresenter{

    }




}
