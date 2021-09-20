package com.jatin.producttracker.data.local.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Parcelable Model class for storing and updating the Additional attribute of a Product.
 *
 * @author Jatin C Shihora
 */
public class ProductAttribute implements Parcelable, Cloneable{
    /**
     * Implementation of {@link android.os.Parcelable.Creator} interface
     * to generate instances of this Parcelable class {@link ProductAttribute} from a {@link Parcel}
     */
    public static final Creator<ProductAttribute> CREATOR = new Creator<ProductAttribute>() {
        /**
         * Creates an instance of this Parcelable class {@link ProductAttribute} from
         * a given Parcel whose data had been previously written by #writeToParcel() method
         *
         * @param in The Parcel to read the object's data from.
         * @return Returns a new instance of this Parcelable class {@link ProductAttribute}
         */
        @Override
        public ProductAttribute createFromParcel(Parcel in) {
            return new ProductAttribute(in);
        }

        /**
         * Creates a new array of this Parcelable class {@link ProductAttribute}
         *
         * @param size Size of the array
         * @return Returns an array of this Parcelable class {@link ProductAttribute}, with every
         * entry initialized to null
         */
        @Override
        public ProductAttribute[] newArray(int size) {
            return new ProductAttribute[size];
        }
    };
    //The Name of the Attribute
    private String mAttributeName;
    //The Value of the Attribute
    private String mAttributeValue;

    /**
     * Private Constructor of {@link ProductAttribute}
     *
     * @param attributeName  The Name of the Attribute
     * @param attributeValue The Value of the Attribute
     */
    private ProductAttribute(String attributeName, String attributeValue) {
        mAttributeName = attributeName;
        mAttributeValue = attributeValue;
    }

    /**
     * Parcelable constructor that de-serializes the data from a Parcel {@code in} passed
     *
     * @param in The Instance of the Parcel class containing the serialized data
     */
    protected ProductAttribute(Parcel in) {
        mAttributeName = in.readString();
        mAttributeValue = in.readString();
    }

    /**
     * Flattens/Serializes the object of {@link ProductAttribute} into a Parcel
     *
     * @param dest  The Parcel in which the object should be written
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mAttributeName);
        dest.writeString(mAttributeValue);
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
        return 0; //Indicating with no mask
    }

    /**
     * Getter Method for the Name of the Attribute.
     *
     * @return The Name of the Attribute
     */
    public String getAttributeName() {
        return mAttributeName;
    }

    /**
     * Setter Method to set the Name of the Attribute
     *
     * @param attributeName The Name of the Attribute
     */
    public void setAttributeName(String attributeName) {
        mAttributeName = attributeName;
    }

    /**
     * Getter Method for the Value of the Attribute
     *
     * @return The Value of the Attribute
     */
    public String getAttributeValue() {
        return mAttributeValue;
    }

    /**
     * Setter Method to set the Value of the Attribute
     *
     * @param attributeValue The Value of the Attribute
     */
    public void setAttributeValue(String attributeValue) {
        mAttributeValue = attributeValue;
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
        ProductAttribute that = (ProductAttribute) o;
        if (!mAttributeName.equals(that.mAttributeName)) return false;
        return mAttributeValue.equals(that.mAttributeValue);
    }
    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        int result = mAttributeName.hashCode();
        result = 31 * result + mAttributeValue.hashCode();
        return result;
    }

    /**
     * Static Builder class that constructs {@link ProductAttribute}
     */
    public static class Builder {

        private String mAttributeName;
        private String mAttributeValue;

        /**
         * Setter for the Name of the Attribute
         *
         * @param attributeName The Name of the Attribute
         * @return Instance of {@link Builder} for chaining method calls.
         */
        public Builder setAttributeName(String attributeName) {
            mAttributeName = attributeName;
            return this;
        }

        /**
         * Setter for the Value of the Attribute
         *
         * @param attributeValue The Value of the Attribute
         * @return Instance of {@link Builder} for chaining method calls.
         */
        public Builder setAttributeValue(String attributeValue) {
            mAttributeValue = attributeValue;
            return this;
        }

        /**
         * Terminal Method that constructs the {@link ProductAttribute}
         *
         * @return Instance of {@link ProductAttribute} built
         */
        public ProductAttribute createProductAttribute() {
            return new ProductAttribute(mAttributeName, mAttributeValue);
        }
    }

}
