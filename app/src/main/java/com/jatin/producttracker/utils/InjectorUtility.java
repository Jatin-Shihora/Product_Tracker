package com.jatin.producttracker.utils;

import android.content.Context;

import com.jatin.producttracker.data.local.StoreRepository;

/**
 * Utility class that injects required dependencies into the Model-View-Presenter framework.
 *
 * @author Jatin C Shihora
 */
public final class InjectorUtility {

    /**
     * Private Constructor to avoid instantiating {@link InjectorUtility}
     */
    private InjectorUtility() {
        //Suppressing with an error to enforce noninstantiability
        throw new AssertionError("No " + this.getClass().getCanonicalName() + " instances for you!");
    }

}