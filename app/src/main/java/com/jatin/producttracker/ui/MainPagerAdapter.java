package com.jatin.producttracker.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.tabs.TabLayout;
import com.jatin.producttracker.R;
import com.jatin.producttracker.data.local.LoaderProvider;
import com.jatin.producttracker.ui.inventory.SalesListFragment;
import com.jatin.producttracker.ui.inventory.SalesListPresenter;
import com.jatin.producttracker.ui.products.ProductListFragment;
import com.jatin.producttracker.ui.products.ProductListPresenter;
import com.jatin.producttracker.ui.suppliers.SupplierListFragment;
import com.jatin.producttracker.ui.suppliers.SupplierListPresenter;
import com.jatin.producttracker.utils.InjectorUtility;

import java.util.Set;

/**
 * Provides the appropriate Fragment for the ViewPager shown in {@link MainActivity}
 *
 * @author Jatin C Shihora
 * */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    //Constants for the pages shown in the ViewPager
    private static final int PRODUCTS_PAGE_POSITION = 0;
    private static final int SUPPLIERS_PAGE_POSITION = 1;
    private static final int SALES_PAGE_POSITION = 2;

    //Constants for the number of Views available
    private static final int TOTAL_VIEW_COUNT = 3 ;

    //saves the reference to Application Context
    private Context mContext;

    //Sparse Array to keep track of teh registered fragment in teh memory
    private SparseArray<Fragment> mRegisteredFragments  = new SparseArray<>();

    //Stores the reference to teh FragmentManager used
    private FragmentManager mFragmentManager ;

    /**
     * Constructor of {@link MainPagerAdapter}
     * @param context is the Application context
     * @param fm      is the FragmentManager to be used for managing the Fragments
     */
    MainPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        mFragmentManager = fm;
        mContext = context;
    }

    /**
     * Return the fragment associated with specified positions.
     *
     * @param position is the position of tab /Fragment {@link androidx.viewpager.widget.ViewPager}
     */
    @Override
    public Fragment getItem(int position) {
        //selecting the fragment based on the positions
        switch (position){
            case PRODUCTS_PAGE_POSITION:  //For product list
                return provideProductListFragment();
            case SUPPLIERS_PAGE_POSITION: //For suppliers list
                return provideSupplierListFragment();
            case SALES_PAGE_POSITION:    //For sales list
                return provideSalesListFragment();
            default:
                return null;
        }
    }

    /**
     * Creates the {@link ProductListFragment }and its presenter {@link ProductListPresenter}
     *
     * @return Instance of {@link ProductListFragment}
     * */
    private Fragment provideProductListFragment(){
        //Creating the fragment
        ProductListFragment fragment = ProductListFragment.newInstance();
        //creating the Fragment's Presenter
        initPresenter(fragment);
        //Returning the ProductListFragment
        return fragment;
    }

    /**
     * Creates the {@link SupplierListFragment} and its Presenter {@link SupplierListPresenter}
     *
     * @return Instance of {@link SupplierListFragment}
     */
    private Fragment provideSupplierListFragment(){
        //Creating the Fragment
        SupplierListFragment fragment = SupplierListFragment.newInstance();
        //Creating the Fragment's Presenter
        initPresenter(fragment);
        //Returning the ProductListFragment
        return fragment;
    }

    /**
     * Creates the {@link SalesListFragment} and its Presenter {@link SalesListPresenter}
     *
     * @return Instance of {@link SalesListFragment}
     */
    private Fragment provideSalesListFragment(){
        //Creating the Fragment
        SalesListFragment fragment = SalesListFragment.newInstance();
        //Creating the Fragment's Presenter
        initPresenter(fragment);
        //Returning the SalesListFragment
        return fragment;
    }

    /**
     * Method that initializes the presenter for the {@code fragment} given
     *
     * @param fragment Any Fragment Instances of this {@link MainPagerAdapter}
     * */
    private void initPresenter(Fragment fragment){
        if (fragment instanceof ProductListFragment) {
            //Creating the ProductListFragment's Presenter
        } else if (fragment instanceof SupplierListFragment) {
            //Creating the SupplierListFragment's Presenter
        } else if (fragment instanceof SalesListFragment) {
            //Creating the SalesListFragment's Presenter
        }
    }

    /**
     * Return the number of view available
     */
    @Override
    public int getCount() {
        return TOTAL_VIEW_COUNT;
    }

    /**
     * Creates the Fragment for the given position. The adapter is responsible for adding the view
     * to the container given here , although it only must ensure this is done by the time it returns
     * from {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing int which the the Fragment will be shown
     * @param position  The page position to be instantiated
     * @return Returns an Object representing the new page. This does not need to be a View,
     *         but can be some other container of the page.
     * */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //Registers the Fragment when the item is instantiated (for the first time) using #getItem
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mRegisteredFragments.put(position,fragment);
        return fragment;
    }

    /**
     * Removes a Fragment for the given position.  The adapter is responsible
     * for removing the view from its container, although it only must ensure
     * this is done by the time it returns from {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing {@link androidx.viewpager.widget.ViewPager}
     *                  from which the Fragment will be removed.
     * @param position  The position of the Fragment to be removed.
     * @param object    The same object that was returned by
     *                  {@link #instantiateItem(View, int)}.
     */
    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        //Unregisters the fragment when the item is inactive
        mRegisteredFragments.delete(position);
        super.destroyItem(container, position, object);
    }

    /**
     * Returns the registered fragment at the positions
     *
     * @param position is the index of the Fragment shown in the ViewPager
     * @return Instance of the Active Fragment at the position if present; else Null
     */
    @Nullable
    Fragment getRegisteredFragment(int position){
        return mRegisteredFragments.get(position);
    }

    /**
     * Overriding to restore the state of Registered Fragments array
     *
     * @param state  is the Parcelable state
     * @param loader is the ClassLoader required for restoring the state
     */
    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
        super.restoreState(state,loader);
        if (state != null) {
            //When the state is present
            Bundle bundle = (Bundle) state;
            //Setting the ClassLoader passed, onto the Bundle
            bundle.setClassLoader(loader);

            //Retrieving the keys used in Bundle
            Set<String> keyStringSet = bundle.keySet();
            //Iterating over the Keys to find the Fragments
            for (String keyString : keyStringSet) {
                if (keyString.startsWith("f")) {
                    //Fragment keys starts with 'f' followed by its position index
                    int position = Integer.parseInt(keyString.substring(1));
                    //Getting the Fragment from the Bundle using the Key through the FragmentManager
                    Fragment fragment = mFragmentManager.getFragment(bundle, keyString);
                    if (fragment != null) {
                        //If Fragment is valid, then update the Sparse Array of Registered Fragments
                        mRegisteredFragments.put(position, fragment);
                        //Create the Fragment's Presenter
                        initPresenter(fragment);
                    }
                }
            }
        }
    }

    /**
     * Method that inflates the template layout ('R.layout.layout_main_tab') for the Tabs and prepares the layout
     * with the correct tab icon and text for the position requested
     */
    @NonNull
    View getTabView(ViewGroup container , int position){
        //Inflating the template Tab Layout ('R.layout.layout_main_tab') at position
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.layout_main_tab,container ,false);

        //Finding the Icon ImageViews to set its Icon
        ImageView imageViewTabIcon = rootView.findViewById(R.id.image_main_tab_icon);
        ImageView imageViewTabIconTemp = rootView.findViewById(R.id.image_main_tab_icon_temp);

        //Finding the TextView to set its title
        TextView textViewTabTitle = rootView.findViewById(R.id.text_main_tab_title);

        //Setting the Icon and the Text based on the current position
        switch (position){
            case PRODUCTS_PAGE_POSITION : //For product list
                imageViewTabIcon.setImageResource(R.drawable.state_main_tab_product_material);
                imageViewTabIconTemp.setImageResource(R.drawable.state_main_tab_product_material);
                textViewTabTitle.setText(mContext.getString(R.string.main_tab_title_products));
                break;
            case SUPPLIERS_PAGE_POSITION : //For suppliers list
                imageViewTabIcon.setImageResource(R.drawable.state_main_tab_supplier);
                imageViewTabIconTemp.setImageResource(R.drawable.state_main_tab_supplier);
                textViewTabTitle.setText(mContext.getString(R.string.main_tab_title_suppliers));
                break;
            case SALES_PAGE_POSITION : //For Sales List
                imageViewTabIcon.setImageResource(R.drawable.state_main_tab_cart);
                imageViewTabIconTemp.setImageResource(R.drawable.state_main_tab_cart);
                textViewTabTitle.setText(mContext.getString(R.string.main_tab_title_sales));
                break;
        }
        //Returning the prepared Tab Item Layout
        return rootView;
    }

    /**
     *Method that shows/hides the Title of the Tab based on the value of {@code visibility}
     *
     * @param tab        The {@link TabLayout} to be changed
     * @param visibility Boolean value that affects the visibility of the Title.
     *                   <b>TRUE</b> to show the Title with Icon ; <b>FALSE</b> to hide the Title.
     */
    void changeTabView(TabLayout.Tab tab ,boolean visibility) {
        //Retrieving the Custom View set for the Tab
        View rootView = tab.getCustomView();

        if (rootView != null) {
            //When we have the Custom View set for the Tab

            //Finding the Temp Icon ImageView
            ImageView imageViewTabIconTemp = rootView.findViewById(R.id.image_main_tab_icon_temp);

            //Finding the Group that has Icon with Title
            Group groupIconTitle = rootView.findViewById(R.id.group_main_tab_icon_title);

  /*          if (visibility) {
                //When TRUE, show the Group and hide the temporary icon
                groupIconTitle.setVisibilty(View.VISIBLE);
                imageViewTabIconTemp.setVisibilty(View.GONE);
            } else {
                //When FALSE, hide the Group and show the temporary Icon
                groupIconTitle.setVisibilty(View.INVISIBLE);
                imageViewTabIconTemp.setVisibilty(View.VISIBLE);
            }*/
        }
    }

}