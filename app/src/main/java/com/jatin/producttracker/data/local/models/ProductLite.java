package com.jatin.producttracker.data.local.models;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.jatin.producttracker.data.local.utils.QueryArgsUtility;

/**
 * Parcelable model class that is a light weight version of {@link Product} model for displaying the
 * list of products available in the database
 * <p>
 * This model class is a read-only model that is built using the data read from {@link android.database.Cursor}
 * </p>
 *
 * @author Jatin C Shihora
 * */
public class ProductLite implements Parcelable {

    /**
     * Implementation of {@link android.os.Parcelable.Creator} interface to generate
     * instances of this parcelable class {@link ProductLite} form a {@link android.os.Parcel}
     * */
    public static final Creator<ProductLite> CREATOR = new Creator<ProductLite>() {
        /**
         * Creates an instance of this Parcelable class {@link ProductLite} from
         * a given Parcel whose data had been previously written by #writeToParcel() method
         *
         * @param in The Parcel to read the object's data from.
         * @return Returns a new instance of this Parcelable class {@link ProductLite}
         */
        @Override
        public ProductLite createFromParcel(Parcel in) {
            return new ProductLite(in);
        }

        /**
         * Creates a new array of this Parcelable class {@link ProductLite}
         *
         * @param size Size of the array
         * @return Returns an array of this Parcelable class {@link ProductLite}, with every
         * entry initialized to null
         */
        @Override
        public ProductLite[] newArray(int size) {
            return new ProductLite[size];
        }
    };

    //The Primary Key/ID of the Product
    public final int mId;
    //The Name of the Product
    private final String mName;
    //The Unique SKU of the Product
    private final String mSku;
    //The Category of the Product
    private final String mCategory;
    //The Content URI of the default Image of the Product
    private final String mDefaultImageUri;

    /**
     * Private Constructor of {@link ProductLite}
     *
     * @param id              The Integer Primary key/ID of the Product
     * @param name            The Name of the Product
     * @param sku             The Unique SKU of the Product
     * @param category        The Category of the Product
     * @param defaultImageUri The Content URI of the default Image of the Product
     * */
    private ProductLite(int id,String name, String sku,String category,String defaultImageUri){
        mId = id;
        mName = name;
        mSku = sku;
        mCategory = category;
        mDefaultImageUri = defaultImageUri;
    }

    /**
     * Parcelable constructor that de-serializes the data from a Parcel {@code in} passed
     *
     * @param in The Instance of the Parcel class containing the serialized data
     */
    protected ProductLite(Parcel in){
        mId = in.readInt();
        mName = in.readString();
        mSku = in.readString();
        mCategory = in.readString();
        mDefaultImageUri = in.readString();
    }

    /**
     * Static Factory constructor for {@link ProductLite} that builds the instance
     * using the data read from the {@link android.database.Cursor}
     *
     * @param cursor The {@link android.database.Cursor} to this data
     * @return Instance of {@link ProductLite}
     * */
    public static ProductLite from(Cursor cursor) {
        return new ProductLite(
                cursor.getInt(QueryArgsUtility.ItemsShortInfoQuery.COLUMN_ITEM_ID_INDEX),
                cursor.getString(QueryArgsUtility.ItemsShortInfoQuery.COLUMN_ITEM_NAME_INDEX),
                cursor.getString(QueryArgsUtility.ItemsShortInfoQuery.COLUMN_ITEM_SKU_INDEX),
                cursor.getString(QueryArgsUtility.ItemsShortInfoQuery.COLUMN_ITEM_CATEGORY_NAME_INDEX),
                cursor.getString(QueryArgsUtility.ItemsShortInfoQuery.COLUMN_ITEM_IMAGE_URI_INDEX)
        );
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(mSku);
        dest.writeString(mDefaultImageUri);
        dest.writeString(mCategory);
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0; //indicating with no mask
    }

    /**
     * Getter method for Primary Key/ID of the Product
     *
     * @return The Integer Primary Key/ID of the Product
     */
    public int getId() {
        return mId;
    }

    /**
     * Getter method for the Name of the Product
     *
     * @return The Name of the Product
     */
    public String getName() {
        return mName;
    }

    /**
     * Getter Method for the SKU of the Product
     *
     * @return The SKU of the Product
     */
    public String getSku() {
        return mSku;
    }

    /**
     * Getter Method for the Category of the Product
     *
     * @return The Category of the Product
     */
    public String getCategory() {
        return mCategory;
    }

    /**
     * Getter Method for the Content URI of the default Image of the Product
     *
     * @return The Content URI of the default Image of the Product
     */
    public String getDefaultImageUri() {
        return mDefaultImageUri;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return <b>TRUE</b> if this object is the same as the {@code o}
     * argument; <b>FALSE</b> otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductLite that = (ProductLite) o;

        if (mId != that.mId) return false;
        if (!mName.equals(that.mName)) return false;
        if (!mSku.equals(that.mSku)) return false;
        if (!mCategory.equals(that.mCategory)) return false;

        return mDefaultImageUri != null ? mDefaultImageUri.equals(that.mDefaultImageUri) : that.mDefaultImageUri == null;
    }

    /**
     * @return Returns a hash code value for the object
     * */
    @Override
    public int hashCode() {
        int result = mId;
        result = 31 * result + mName.hashCode();
        result = 31 * result + mSku.hashCode();
        result = 31 * result + mCategory.hashCode();
        result = 31 * result + (mDefaultImageUri != null ? mDefaultImageUri.hashCode() : 0);
        return result;
    }

    /**
     * Returns a string representation of the object
     *
     * @return String representation of the {@link ProductLite}
     * */
    @NonNull
    @Override
    public String toString() {
        return "ProductLite{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mSku='" + mSku + '\'' +
                ", mCategory='" + mCategory + '\'' +
                ", mDefaultImageUri='" + mDefaultImageUri + '\'' +
                '}';
    }
}