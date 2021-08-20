package com.jatin.producttracker.ui;

import androidx.annotation.Nullable;

/**
 * Custom View Interface that extends {@link BaseView} for use with the Fragments
 * shown in the ViewPager of the {@link MainActivity}.
 *
 * @author Jatin C Shihora
 * */
public interface PagerView<T extends PagerPresenter> extends BaseView<T> {
    /**
     * Method that returns the registered Presenter for this View.
     *
     * @return The registered Presenter for this View. Can be {@code null}
     */
    @Nullable
    T getPresenter();
}
