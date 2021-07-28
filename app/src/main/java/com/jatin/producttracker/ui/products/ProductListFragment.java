package com.jatin.producttracker.ui.products;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.security.acl.Group;

/**
 * {@link com.jatin.producttracker.ui.MainActivity}'s ViewPager Fragment that inflates the layout
 * 'R.layout.layout_main__content_page' to display the list of Products configured in the database.
 * */
public class ProductListFragment extends Fragment {

    //Constant used for logs
    private static final String LOG_TAG = ProductListFragment.class.getSimpleName();

    //References to the Views shown in this fragment
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerViewContentList;
    private Group mGroupEmptyList;


    /**
     * Mandatory Empty Constructor of {@link ProductListFragment}
     * This is required by the {@link androidx.fragment.app.Fragment} to instantiate
     * the fragment (e.g when the screens are oriented).
     * */
    public ProductListFragment(){
    }

    /**
     * Static Factory constructor that creates an instance of {@link ProductListFragment}
     *
     * @return Instance of {@link ProductListFragment}
     * */
    @NonNull
    public static ProductListFragment newInstance(){
        return new ProductListFragment();
    }

}