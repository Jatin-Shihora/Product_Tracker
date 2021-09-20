package com.jatin.producttracker.ui.products.image;

import android.graphics.Bitmap;

import com.jatin.producttracker.data.local.models.ProductImage;

/**
 * Interface to be implemented by the {@link ProductImageActivityFragment}
 * to receive callback events for User actions on RecyclerView Grid of Product photos.
 *
 * @author Jatin C Shihora
 */
public interface PhotoGridUserActionsListener {
    /**
     * Callback Method of {@link PhotoGridUserActionsListener} invoked when
     * the user clicks on an item in the RecyclerView that displays a Grid of Photos,
     * to select from.
     *
     * @param itemPosition The adapter position of the Item clicked
     * @param productImage The {@link ProductImage} associated with the Item clicked
     * @param gridMode     The mode of the Action as defined by {@link ProductImageContract.PhotoGridSelectModeDef}
     */
    void onItemClicked(int itemPosition, ProductImage productImage, @ProductImageContract.PhotoGridSelectModeDef String gridMode);

    /**
     * Callback Method of {@link PhotoGridUserActionsListener} invoked when
     * the user does a Long click on an item in the RecyclerView that displays a Grid of Photos,
     * to delete from. This should also trigger the contextual action mode for delete action.
     *
     * @param itemPosition The adapter position of the Item Long clicked
     * @param productImage The {@link ProductImage} associated with the Item Long clicked
     * @param gridMode     The mode of the Action as defined by {@link ProductImageContract.PhotoGridSelectModeDef}
     */
    void onItemLongClicked(int itemPosition, ProductImage productImage, @ProductImageContract.PhotoGridSelectModeDef String gridMode);

    /**
     * Callback Method of {@link PhotoGridUserActionsListener} invoked when
     * the selected item's image is to be shown in the Main ImageView 'R.id.image_product_selected_item_photo'
     *
     * @param bitmap       The {@link Bitmap} of the Image to be shown.
     * @param productImage The {@link ProductImage} associated with the Item Image to be shown.
     */
    void showSelectedImage(Bitmap bitmap, ProductImage productImage);
}