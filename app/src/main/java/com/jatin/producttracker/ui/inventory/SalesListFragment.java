package com.jatin.producttracker.ui.inventory;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.security.acl.Group;

/**
 * {@link com.jatin.producttracker.ui.MainActivity}'s ViewPager Fragment that inflates the layout
 * 'R.layout.layout_main_content_page' to display the list of products with their Sales
 * information configured in the database.
 * */
public class SalesListFragment extends Fragment {

    //Constants used for logs
    private static final String LOG_TAG = SalesListFragment.class.getSimpleName();

    //References to the Views shoe=wn in this Fragment
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerViewContentList;
    private Group mGroupEmptyList;

    /**
     * Mandatory Empty Constructor of {@link SalesListFragment}
     * This is required by the {@link androidx.fragment.app.Fragment} to instantiate
     * the fragment (e.g when the screens are oriented).
     * */
    public SalesListFragment(){
    }

    /**
     * Static Factory constructor that creates an instance of {@link SalesListFragment}
     *
     * @return Instance of {@link SalesListFragment}
     * */
    @NonNull
    public static SalesListFragment newInstance(){
        return new SalesListFragment();
    }

}