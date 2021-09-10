package com.jatin.producttracker.utils;

import android.content.Context;

import com.jatin.producttracker.data.local.StoreFileRepository;
import com.jatin.producttracker.data.local.StoreLocalRepository;
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

    /**
     * Method that provides/injects the {@link StoreLocalRepository} instance which
     * deals with the database.
     *
     * @param context A {@link Context} to derive the {@link android.content.ContentResolver} instance
     * @return Instance of {@link StoreLocalRepository}
     */
    private static StoreLocalRepository provideLocalRepository(Context context) {
        return StoreLocalRepository.getInstance(context.getContentResolver(), AppExecutors.getInstance());
    }

    /**
     * Method that provides/injects the {@link StoreFileRepository} instance which
     * deals with the Files.
     *
     * @param context A {@link Context} to derive the {@link android.content.ContentResolver} instance
     * @return Instance of {@link StoreFileRepository}
     */
    private static StoreFileRepository provideFileRepository(Context context) {
        return StoreFileRepository.getInstance(context.getContentResolver(), AppExecutors.getInstance());
    }

    /**
     * Method that provides/injects the {@link StoreRepository} instance which
     * interfaces with {@link StoreLocalRepository} and {@link StoreFileRepository}
     *
     * @param context A {@link Context} to derive the {@link android.content.ContentResolver} instance
     * @return Instance of {@link StoreRepository}
     */
    public static StoreRepository provideStoreRepository(Context context) {
        return StoreRepository.getInstance(provideLocalRepository(context), provideFileRepository(context));
    }

}