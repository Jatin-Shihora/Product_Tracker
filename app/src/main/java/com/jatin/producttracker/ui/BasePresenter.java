package com.jatin.producttracker.ui;

/**
 * Base Presenter Interface as in Model View Presenter
 *
 * @author  Jatin C Shihora
 * */
public interface BasePresenter {
    /**
     * Method that initiates the work of Presenter which is invoked by the View that implements
     * the {@link com.jatin.producttracker.ui.BaseView}
     */
    void start();
}