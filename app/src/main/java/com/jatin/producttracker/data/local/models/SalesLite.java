package com.jatin.producttracker.data.local.models;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import com.jatin.producttracker.data.local.utils.QueryArgsUtility;

/**
 * Parcelable model class for displaying the list of Products available in the database
 * along with their top Supplier and Sales information
 *
 * @author Jatin C Shihora
 * */
public class SalesLite implements Parcelable {

    /**
     * Implementation of {@link Parcelable.Creator} interface to generate instances of this Parcelable
     * class {@link SalesLite} from a link {@link android.os.Parcel}
     * */
    public static final Creator<SalesLite> CREATOR = new Creator<SalesLite>() {
        /**
         * Creates an instance this Parcelable Class {@link SalesLite} from a given Parcel
         * whose data had been previously written bt #writeToParcel() method
         *
         * @param in The Parcel to read the Object's data from.
         * @return Returns a new instance of this Parcelable class {@link SalesLite}
         * */
        @Override
        public SalesLite createFromParcel(Parcel in) {
            return null; //new SalesLite(in);
        }

        /**
         * Creates a new Array of this Parcelable class {@link SalesLite}
         *
         * @param size Size of the array
         * @return Returns an array of this Parcelable class {@link SalesLite}, with every entry initialized to null
         * */
        @Override
        public SalesLite[] newArray(int size) {
            return new SalesLite[0];
        }
    };

    //The primary Key/Id of the product
    public final int mProductId;
    //The primary Key/Id of top supplier
    private final int mSupplierId;
    //The Name of the product
    private final String mProductName;
    //The Unique SKU of the product
    private final String mProductSku;
    //The Category of the Product
    private final String mCategoryName;
    //The Content URI of the default Image of the product
    private final String mDefaultImageUri;
    //The Name of the Top Supplier for the Product
    private final String mTopSupplierName;
    //The Unique code of the top supplier for the product
    private final String mTopSupplierCode;
    //The selling price of the product by the top supplier
    private final float mSupplierUnitPrice;
    //The available Quantity to Sell at the Top supplier
    public final int mSupplierAvailableQuantity;
    //The total available to Sell Quantity of the Product
    private final int mTotalAvailableQuantity;


    /**
     * Private Constructor of {@link SalesLite}
     *
     * @param productId                 The Integer Primary Key/ID of the Product
     * @param supplierId                The Integer Primary Key/ID of the Top Supplier
     * @param productName               The Name of the Product
     * @param productSku                The Unique SKU of the Product
     * @param categoryName              The Category of the Product
     * @param defaultImageUri           The Content URI of the default Image of the Product
     * @param topSupplierName           The Name of the Top Supplier for the Product
     * @param topSupplierCode           The Unique Code of the Top Supplier for the Product
     * @param supplierUnitPrice         The Selling Price of the Product by the Top Supplier
     * @param supplierAvailableQuantity The Available Quantity to Sell at the Top Supplier
     * @param totalAvailableQuantity    The Total Available to Sell Quantity of the Product
     */
    private SalesLite(int productId, int supplierId, String productName, String productSku,
                      String categoryName, String defaultImageUri, String topSupplierName,
                      String topSupplierCode, float supplierUnitPrice,
                      int supplierAvailableQuantity, int totalAvailableQuantity) {
        mProductId = productId;
        mSupplierId = supplierId;
        mProductName = productName;
        mProductSku = productSku;
        mCategoryName = categoryName;
        mDefaultImageUri = defaultImageUri;
        mTopSupplierName = topSupplierName;
        mTopSupplierCode = topSupplierCode;
        mSupplierUnitPrice = supplierUnitPrice;
        mSupplierAvailableQuantity = supplierAvailableQuantity;
        mTotalAvailableQuantity = totalAvailableQuantity;
    }

    /**
     * Parcelable constructors that de-serializes the data from a Parcel {@code in} passed
     *
     * @param in The Instance of the Parcel class containing the serialized data
     * */
    protected SalesLite(Parcel in){
        mProductId = in.readInt();
        mSupplierId = in.readInt();
        mProductName = in.readString();
        mProductSku = in.readString();
        mCategoryName = in.readString();
        mDefaultImageUri = in.readString();
        mTopSupplierName = in.readString();
        mTopSupplierCode = in.readString();
        mSupplierUnitPrice = in.readFloat();
        mSupplierAvailableQuantity = in.readInt();
        mTotalAvailableQuantity = in.readInt();
    }

    /**
     * Static Factory constructors for {@link SalesLite} that builds the instance using
     * the data read from the {@link android.database.Cursor}
     *
     * @param cursor The {@link android.database.Cursor} to this data
     * @return Instance of {@link SalesLite}
     * */
    public static SalesLite from(Cursor cursor){
        return new SalesLite(
                cursor.getInt(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_ID_INDEX),
                cursor.getInt(QueryArgsUtility.SalesShortInfoQuery.COLUMN_SUPPLIER_ID_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_NAME_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_SKU_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_CATEGORY_NAME_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_IMAGE_URI_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_SUPPLIER_NAME_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_SUPPLIER_CODE_INDEX),
                cursor.getFloat(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_UNIT_PRICE_INDEX),
                cursor.getInt(QueryArgsUtility.SalesShortInfoQuery.COLUMN_SUPPLIER_AVAIL_QUANTITY_INDEX),
                cursor.getInt(QueryArgsUtility.SalesShortInfoQuery.COLUMN_TOTAL_AVAIL_QUANTITY_INDEX)
        );
    }

    /**
     * Flattens/Serializes the object of {@link SalesLite} into a Parcel
     *
     * @param dest  The parcel in which the object should be written
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}
     * */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mProductId);
        dest.writeInt(mSupplierId);
        dest.writeString(mProductName);
        dest.writeString(mProductSku);
        dest.writeString(mCategoryName);
        dest.writeString(mDefaultImageUri);
        dest.writeString(mTopSupplierCode);
        dest.writeString(mTopSupplierName);
        dest.writeFloat(mSupplierUnitPrice);
        dest.writeInt(mSupplierAvailableQuantity);
        dest.writeInt(mTotalAvailableQuantity);
    }

    /**
     * Describes the kinds of special objects contained in this Parcelable
     * instance's marshaled representation.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }


    public int getProductId() {
        return mProductId;
    }

    public int getSupplierId() {
        return mSupplierId;
    }

    public String getProductName() {
        return mProductName;
    }

    public String getProductSku() {
        return mProductSku;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public String getDefaultImageUri() {
        return mDefaultImageUri;
    }

    public String getTopSupplierName() {
        return mTopSupplierName;
    }

    public String getTopSupplierCode() {
        return mTopSupplierCode;
    }

    public float getSupplierUnitPrice() {
        return mSupplierUnitPrice;
    }

    public int getSupplierAvailableQuantity() {
        return mSupplierAvailableQuantity;
    }

    public int getTotalAvailableQuantity() {
        return mTotalAvailableQuantity;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param   o The reference object with which to compare
     * @return <b>TRUE</b> if this object is same as the {@code o}
     *           argument; <b>FALSE</b> otherwise
     * */
    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesLite salesLite = (SalesLite) o ;

        if (mProductId != salesLite.mProductId) return false;
        if (mSupplierId != salesLite.mSupplierId) return false;
        if (Float.compare(salesLite.mSupplierUnitPrice, mSupplierUnitPrice) != 0) return false;
        if (mSupplierAvailableQuantity != salesLite.mSupplierAvailableQuantity) return false;
        if (mTotalAvailableQuantity != salesLite.mTotalAvailableQuantity) return false;
        if (!mProductName.equals(salesLite.mProductName)) return false;
        if (!mProductSku.equals(salesLite.mProductSku)) return false;
        if (!mCategoryName.equals(salesLite.mCategoryName)) return false;
        if (mDefaultImageUri != null ? !mDefaultImageUri.equals(salesLite.mDefaultImageUri) : salesLite.mDefaultImageUri != null)
            return false;
        if (!mTopSupplierName.equals(salesLite.mTopSupplierName)) return false;
        return mTopSupplierCode.equals(salesLite.mTopSupplierCode);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this project
     * */
    @Override
    public int hashCode() {
        int result = mProductId;
        result = 31*result + mSupplierId;
        result = 31 * result + mProductName.hashCode();
        result = 31 * result + mProductSku.hashCode();
        result = 31 * result + mCategoryName.hashCode();
        result = 31 * result + (mDefaultImageUri != null ? mDefaultImageUri.hashCode() : 0);
        result = 31 * result + mTopSupplierName.hashCode();
        result = 31 * result + mTopSupplierCode.hashCode();
        result = 31 * result + (mSupplierUnitPrice != +0.0f ? Float.floatToIntBits(mSupplierUnitPrice) : 0);
        result = 31 * result + mSupplierAvailableQuantity;
        result = 31 * result + mTotalAvailableQuantity;
        return result;

    }
}