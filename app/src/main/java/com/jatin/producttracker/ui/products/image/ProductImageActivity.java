package com.jatin.producttracker.ui.products.image;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jatin.producttracker.R;
import com.jatin.producttracker.data.local.models.ProductImage;

import java.util.ArrayList;

/**
 * Activity that inflates the layout 'R.layout.activity_product_image' that
 * displays a content fragment inflated by {@@link ProductImageActivityFragment}.
 * This allows to capture/store the Images of the Product in the Android Device
 * and their corresponding File Content URIs in the database. Also, one needs to select the
 * default Image for the Product, to be displayed.
 *
 * @author Jatin C Shihora
 */
public class ProductImageActivity extends AppCompatActivity {
    //Request code used by the activity that calls this activity for result
    public static final int REQUEST_PRODUCT_IMAGE = 30;

    //Intent Extra constant for retrieving the Product Images from the Parent ProductConfigActivity
    public static final String EXTRA_PRODUCT_IMAGES = ProductImageActivity.class.getPackage() + "extra.PRODUCT_IMAGES";

    //The Presenter for this View's Content Fragment
//    private ProductImageContract.Presenter mPresenter;

    //The Fab button to add product images
    private FloatingActionButton mFabAddImages;

    //The ImageView for the selected photo
    private ImageView mImageViewSelectedPhoto;

    //The App Bar to expand and collapse the Photo shown
    private AppBarLayout mAppBarLayout;

    //Tracks current Contextual ActionMode
    private ActionMode mActionMode;

    //Boolean to postpone/start the Shared Element enter transition
    private boolean mIsEnterTransitionPostponed;

    //The Callback for Contextual ActionMode
    private final ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        //Saves whether the delete action was handled
        private boolean mDeleteEventHandled = false;

        /**
         * Called when action mode is first created. The menu supplied will be used to
         * generate action buttons for the action mode.
         *
         * @param mode ActionMode being created
         * @param menu Menu used to populate action buttons
         * @return true if the action mode should be created, false if entering this
         *              mode should be aborted.
         */
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            //Set the title for the ActionMode
            mode.setTitle(getString(R.string.product_image_contextual_action_delete_title));
            //Inflate the Contextual Action Menu 'R.menu.cab_menu_fragment_product_image'
            mode.getMenuInflater().inflate(R.menu.cab_menu_fragment_product_image, menu);
            //Hide the Fab button to avoid confusion
            mFabAddImages.hide();
            //Returning true to create the action mode
            return true;
        }

        /**
         * Called to refresh an action mode's action menu whenever it is invalidated.
         *
         * @param mode ActionMode being prepared
         * @param menu Menu used to populate action buttons
         * @return true if the menu or action mode was updated, false otherwise.
         */
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        /**
         * Called to report a user click on an action button.
         *
         * @param mode The current ActionMode
         * @param item The item that was clicked
         * @return true if this callback handled the event, false if the standard MenuItem
         *         invocation should continue.
         */
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            //Taking action based on the ID of the Menu item clicked
            switch (item.getItemId()) {
                case R.id.action_delete:
                    //Trigger the deletion of the items selected
//                    mPresenter.deleteSelection();
                    //Set the delete event boolean to True
                    mDeleteEventHandled = true;
                    //Close the contextual menu
                    mode.finish();
                    //Returning true as the event is handled
                    return mDeleteEventHandled;
                default:
                    //On all else, return false
                    return false;
            }
        }

        /**
         * Called when an action mode is about to be exited and destroyed.
         *
         * @param mode The current ActionMode being destroyed
         */
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            //Clear current ActionMode
            mActionMode = null;
            //Show the Fab button
            mFabAddImages.show();

            if (!mDeleteEventHandled) {
                //Reset and clear the selected state if the delete event was NOT handled
//                mPresenter.onDeleteModeExit();
            } else {
                //Reset the event when handled
                mDeleteEventHandled = false;
            }
        }
    };

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
        setContentView(R.layout.activity_product_image);
        supportPostponeEnterTransition();

        //Find the AppBar
        mAppBarLayout = findViewById(R.id.app_bar_product_image);
        //Find the ImageView for Selected Photo
        mImageViewSelectedPhoto = findViewById(R.id.image_product_selected_item_photo);

        //Get the Product Images passed in the Intent Extra
        ArrayList<ProductImage> productImages = getIntent().getParcelableArrayListExtra(EXTRA_PRODUCT_IMAGES);
        if (productImages == null) {
            //Ensuring the list is initialized when not
            productImages = new ArrayList<>();
        }
    }




}
