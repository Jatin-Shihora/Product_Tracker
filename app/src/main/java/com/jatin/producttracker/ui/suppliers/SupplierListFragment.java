package com.jatin.producttracker.ui.suppliers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.jatin.producttracker.ui.products.ProductListFragment;

import java.security.acl.Group;

/**
 * {@link com.jatin.producttracker.ui.MainActivity}'s ViewPager Fragment that inflates the layout
 * 'R.layout.layout_main_content_page' to display the list of Suppliers configured in the database.
 * */
public class SupplierListFragment extends Fragment {

    //Constant used for logs
    private static final String LOG_TAG = ProductListFragment.class.getSimpleName();

    //References to the Views shown in this fragment
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerViewContentList;
    private Group mGroupEmptyList;

    /**
     * Mandatory Empty Constructor of {@link SupplierListFragment}
     * This is required by the {@link androidx.fragment.app.Fragment} to instantiate
     * the fragment (e.g when the screens are oriented).
     * */
    public SupplierListFragment(){
    }

    /**
     * Static Factory constructor that creates an instance of {@link ProductListFragment}
     *
     * @return Instance of {@link ProductListFragment}
     * */
    @NonNull
    public static SupplierListFragment newInstance(){
        return new SupplierListFragment();
    }
}