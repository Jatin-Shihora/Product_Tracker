package com.jatin.producttracker.ui;

/**
 * Base View Interface as in Model-View-Presenter
 *
 * @author Jatin C Shihora
 **/
public interface BaseView<T extends BasePresenter> {
    /**
     * Method that registers the Presenter {@code presenter} with the View implementing
     * {@link com.jatin.producttracker.ui.BaseView}
     *
     * @param presenter Presenter instance implementing the {@link com.jatin.producttracker.ui.BasePresenter}
     * */
    void setPresenter(T presenter);
}