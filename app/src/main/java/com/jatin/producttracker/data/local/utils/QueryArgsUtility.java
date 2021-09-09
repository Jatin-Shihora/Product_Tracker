package com.jatin.producttracker.data.local.utils;

import android.content.ContentUris;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.jatin.producttracker.data.local.contracts.ProductContract;
import com.jatin.producttracker.data.local.contracts.ProductContract.ProductCategory;
import com.jatin.producttracker.data.local.contracts.SalesContract;
import com.jatin.producttracker.data.local.contracts.SalesContract.ProductSupplierInfo;
import com.jatin.producttracker.data.local.contracts.SupplierContract;

import java.util.HashMap;
import java.util.Map;

import static com.jatin.producttracker.data.local.contracts.ProductContract.*;
import static com.jatin.producttracker.data.local.contracts.SalesContract.*;
import static com.jatin.producttracker.data.local.contracts.SupplierContract.*;
import static com.jatin.producttracker.data.local.utils.SqliteUtility.AND;
import static com.jatin.producttracker.data.local.utils.SqliteUtility.EQUALS;
import static com.jatin.producttracker.data.local.utils.SqliteUtility.IS;
import static com.jatin.producttracker.data.local.utils.SqliteUtility.JOIN;
import static com.jatin.producttracker.data.local.utils.SqliteUtility.LEFT_JOIN;
import static com.jatin.producttracker.data.local.utils.SqliteUtility.NULL;
import static com.jatin.producttracker.data.local.utils.SqliteUtility.ON;
import static com.jatin.producttracker.data.local.utils.SqliteUtility.OR;
import static com.jatin.producttracker.data.local.utils.SqliteUtility.PLACEHOLDER;

/**
 * Utility class that provides Static inner classes with methods
 * for generating queries required in the App.
 *
 * @author Jatin C Shihora
 */
public class QueryArgsUtility {

    /**
     * Class that provides all the necessities
     * for building the query to retrieve the Categories list.
     * <p>
     * <pre>
     *     Select category_name from item_category
     * </pre>
     */
    public static final class CategoriesQuery {
        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_ITEM_CATEGORY_NAME_INDEX = 0;

        /**
         * Method that returns the Columns for use in the Select clause of the query
         *
         * @return An Array of Strings which are the Columns to use in the Select clause
         * of the query
         */
        public static String[] getProjection() {
            return new String[]{
                    ProductCategory.COLUMN_ITEM_CATEGORY_NAME
            };
        }
    }

    /**
     * Class that provides all the necessities
     * for building the query to retrieve the Id of a Category
     * identified by the 'category_name'.
     * <p>
     * <pre>
     *     SELECT _id, category_name
     *     FROM item_category
     *     WHERE category_name = ?;
     * </pre>
     */
    public static final class CategoryByNameQuery {
        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_ITEM_CATEGORY_ID_INDEX = 0;
        public static final int COLUMN_ITEM_CATEGORY_NAME_INDEX = 1;

        /**
         * Method that returns the Columns for use in the Select clause of the query
         *
         * @return An Array of Strings which are the Columns to use in the Select clause
         * of the query
         */
        public static String[] getProjection() {
            return new String[]{
                    ProductCategory._ID,
                    ProductCategory.COLUMN_ITEM_CATEGORY_NAME
            };
        }
    }

    /**
     * Class that provides all the necessities
     * for building the query to retrieve the Item's Attributes
     * <p>
     * <pre>
     *     SELECT item_attr.item_id, item_attr.attr_name, item_attr.attr_value
     *     FROM item JOIN item_attr
     *     ON item_attr.item_id = item._id
     *     WHERE item._id = ?;
     * </pre>
     */
    public static final class ItemAttributesQuery {

        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_ITEM_ID_INDEX = 0;
        public static final int COLUMN_ITEM_ATTR_NAME_INDEX = 1;
        public static final int COLUMN_ITEM_ATTR_VALUE_INDEX = 2;

        /**
         * Method that builds the relationship tables involved in the join.
         *
         * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance to set the Tables on
         */
        public static void setTables(SQLiteQueryBuilder queryBuilder) {
            String inTables = Product.TABLE_NAME + JOIN
                    + ProductAttribute.TABLE_NAME + ON
                    + Product.getQualifiedColumnName(Product._ID)
                    + EQUALS
                    + ProductAttribute.getQualifiedColumnName(ProductAttribute.COLUMN_ITEM_ID);
            queryBuilder.setTables(inTables);
        }

        /**
         * Method that builds a map of Projection columns used in the Select clause
         * with the appropriate column qualifiers or aliases such that there is no ambiguity in the
         * column names
         *
         * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance
         *                     to set the ProjectionMap on.
         */
        public static void setProjectionMap(SQLiteQueryBuilder queryBuilder) {
            Map<String, String> columnMap = new HashMap<>();
            columnMap.put(ProductAttribute.getQualifiedColumnName(ProductAttribute.COLUMN_ITEM_ID),
                    ProductAttribute.getQualifiedColumnName(ProductAttribute.COLUMN_ITEM_ID));
            columnMap.put(ProductAttribute.getQualifiedColumnName(ProductAttribute.COLUMN_ITEM_ATTR_NAME),
                    ProductAttribute.getQualifiedColumnName(ProductAttribute.COLUMN_ITEM_ATTR_NAME));
            columnMap.put(ProductAttribute.getQualifiedColumnName(ProductAttribute.COLUMN_ITEM_ATTR_VALUE),
                    ProductAttribute.getQualifiedColumnName(ProductAttribute.COLUMN_ITEM_ATTR_VALUE));
            queryBuilder.setProjectionMap(columnMap);
        }

        /**
         * Method that returns the Columns for use in the Select clause of the query
         *
         * @return An Array of Strings which are the Columns to use in the Select clause
         * of the query
         */
        public static String[] getProjection() {
            return new String[]{
                    ProductAttribute.getQualifiedColumnName(ProductAttribute.COLUMN_ITEM_ID),
                    ProductAttribute.getQualifiedColumnName(ProductAttribute.COLUMN_ITEM_ATTR_NAME),
                    ProductAttribute.getQualifiedColumnName(ProductAttribute.COLUMN_ITEM_ATTR_VALUE)
            };
        }

        /**
         * Method that returns the Where Clause of the query
         *
         * @return String containing the Where Clause required
         */
        public static String getSelection() {
            //Where clause is the 'Item' table's Key
            return Product.getQualifiedColumnName(Product._ID) + EQUALS + PLACEHOLDER;
        }

        /**
         * Method that returns the Where Clause arguments of the query
         *
         * @param uri is the URI for the query
         * @return An Array of Strings which are the Where Clause arguments of the query
         */
        public static String[] getSelectionArgs(@NonNull Uri uri) {
            return new String[]{
                    //Where clause value is the 'id' passed in the URI
                    String.valueOf(ContentUris.parseId(uri))
            };
        }

    }

    /**
     * Class that provides all the necessities
     * for building the query to retrieve the Item's Images
     * <p>
     * <pre>
     *     SELECT item_image.item_id, item_image.image_uri, item_image.is_default
     *     FROM item JOIN item_image
     *     ON item_image.item_id = item._id
     *     WHERE item._id = ?;
     * </pre>
     */
    public static final class ItemImagesQuery {

        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_ITEM_ID_INDEX = 0;
        public static final int COLUMN_ITEM_IMAGE_URI_INDEX = 1;
        public static final int COLUMN_ITEM_IMAGE_DEFAULT_INDEX = 2;

        /**
         * Method that builds the relationship tables involved in the join.
         *
         * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance to set the Tables on
         */
        public static void setTables(SQLiteQueryBuilder queryBuilder) {
            String inTables = Product.TABLE_NAME + JOIN
                    + ProductImage.TABLE_NAME + ON
                    + ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_ID)
                    + EQUALS
                    + Product.getQualifiedColumnName(Product._ID);
            queryBuilder.setTables(inTables);
        }

        /**
         * Method that builds a map of Projection columns used in the Select clause
         * with the appropriate column qualifiers or aliases such that there is no ambiguity in the
         * column names
         *
         * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance
         *                     to set the ProjectionMap on.
         */
        public static void setProjectionMap(SQLiteQueryBuilder queryBuilder) {
            Map<String, String> columnMap = new HashMap<>();
            columnMap.put(ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_ID),
                    ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_ID));
            columnMap.put(ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_IMAGE_URI),
                    ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_IMAGE_URI));
            columnMap.put(ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_IMAGE_DEFAULT),
                    ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_IMAGE_DEFAULT));
            queryBuilder.setProjectionMap(columnMap);
        }

        /**
         * Method that returns the Columns for use in the Select clause of the query
         *
         * @return An Array of Strings which are the Columns to use in the Select clause
         * of the query
         */
        public static String[] getProjection() {
            return new String[]{
                    ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_ID),
                    ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_IMAGE_URI),
                    ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_IMAGE_DEFAULT)
            };
        }

        /**
         * Method that returns the Where Clause of the query
         *
         * @return String containing the Where Clause required
         */
        public static String getSelection() {
            //Where clause is the 'Item' table's Key
            return Product.getQualifiedColumnName(Product._ID) + EQUALS + PLACEHOLDER;
        }

        /**
         * Method that returns the Where Clause arguments of the query
         *
         * @param uri is the URI for the query
         * @return An Array of Strings which are the Where Clause arguments of the query
         */
        public static String[] getSelectionArgs(@NonNull Uri uri) {
            return new String[]{
                    //Where clause value is the 'id' passed in the URI
                    String.valueOf(ContentUris.parseId(uri))
            };
        }
    }

        /**
         * Class that provides all the necessities
         * for building the query to retrieve an Item's info
         * <p>
         * <pre>
         *     SELECT item._id, item.item_name, item.item_sku, item.item_description,
         *     item_category.category_name
         *     FROM item JOIN item_category
         *     ON item.category_id = item_category._id
         *     WHERE item._id = ?;
         * </pre>
         */
        public static final class ItemByIdQuery {
            //Constants of Column Index as they would appear in the Select clause
            public static final int COLUMN_ITEM_ID_INDEX = 0;
            public static final int COLUMN_ITEM_NAME_INDEX = 1;
            public static final int COLUMN_ITEM_SKU_INDEX = 2;
            public static final int COLUMN_ITEM_DESCRIPTION_INDEX = 3;
            public static final int COLUMN_ITEM_CATEGORY_NAME_INDEX = 4;

            /**
             * Method that builds the relationship tables involved in the join.
             *
             * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance to set the Tables on
             */
            public static void setTables(SQLiteQueryBuilder queryBuilder) {
                String inTables = Product.TABLE_NAME + JOIN
                        + ProductCategory.TABLE_NAME + ON
                        + Product.getQualifiedColumnName(Product.COLUMN_ITEM_CATEGORY_ID)
                        + EQUALS
                        + ProductCategory.getQualifiedColumnName(ProductCategory._ID);
                queryBuilder.setTables(inTables);
            }

            /**
             * Method that builds a map of Projection columns used in the Select clause
             * with the appropriate column qualifiers or aliases such that there is no ambiguity in the
             * column names
             *
             * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance
             *                     to set the ProjectionMap on.
             */
            public static void setProjectionMap(SQLiteQueryBuilder queryBuilder) {
                Map<String, String> columnMap = new HashMap<>();
                columnMap.put(Product.getQualifiedColumnName(Product._ID),
                        Product.getQualifiedColumnName(Product._ID));
                columnMap.put(Product.getQualifiedColumnName(Product.COLUMN_ITEM_NAME),
                        Product.getQualifiedColumnName(Product.COLUMN_ITEM_NAME));
                columnMap.put(Product.getQualifiedColumnName(Product.COLUMN_ITEM_SKU),
                        Product.getQualifiedColumnName(Product.COLUMN_ITEM_SKU));
                columnMap.put(Product.getQualifiedColumnName(Product.COLUMN_ITEM_DESCRIPTION),
                        Product.getQualifiedColumnName(Product.COLUMN_ITEM_DESCRIPTION));
                columnMap.put(ProductCategory.getQualifiedColumnName(ProductCategory.COLUMN_ITEM_CATEGORY_NAME),
                        ProductCategory.getQualifiedColumnName(ProductCategory.COLUMN_ITEM_CATEGORY_NAME));
                queryBuilder.setProjectionMap(columnMap);
            }

            /**
             * Method that returns the Columns for use in the Select clause of the query
             *
             * @return An Array of Strings which are the Columns to use in the Select clause
             * of the query
             */
            public static String[] getProjection() {
                return new String[]{
                        Product.getQualifiedColumnName(Product._ID),
                        Product.getQualifiedColumnName(Product.COLUMN_ITEM_NAME),
                        Product.getQualifiedColumnName(Product.COLUMN_ITEM_SKU),
                        Product.getQualifiedColumnName(Product.COLUMN_ITEM_DESCRIPTION),
                        ProductCategory.getQualifiedColumnName(ProductCategory.COLUMN_ITEM_CATEGORY_NAME)
                };
            }

            /**
             * Method that returns the Where Clause of the query
             *
             * @return String containing the Where Clause required
             */
            public static String getSelection() {
                //Where clause is the 'Item' table's Key
                return Product.getQualifiedColumnName(Product._ID) + EQUALS + PLACEHOLDER;
            }

            /**
             * Method that returns the Where Clause arguments of the query
             *
             * @param uri is the URI for the query
             * @return An Array of Strings which are the Where Clause arguments of the query
             */
            public static String[] getSelectionArgs(@NonNull Uri uri) {
                return new String[]{
                        //Where clause value is the 'id' passed in the URI
                        String.valueOf(ContentUris.parseId(uri))
                };
            }
        }

    /**
     * Class that provides all the necessities
     * for building the query to retrieve all Items' data
     * required for displaying the list of products.
     * <p>
     * <pre>
     *     SELECT item._id, item.item_name, item.item_sku,
     *     item_category.category_name, item_image.image_uri
     *     FROM item JOIN item_category
     *     ON item.category_id = item_category._id
     *     LEFT JOIN item_image
     *     ON item_image.item_id = item._id
     *     WHERE item_image.is_default IS NULL OR item_image.is_default = 1;
     * </pre>
     */
    public static final class ItemsShortInfoQuery {
        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_ITEM_ID_INDEX = 0;
        public static final int COLUMN_ITEM_NAME_INDEX = 1;
        public static final int COLUMN_ITEM_SKU_INDEX = 2;
        public static final int COLUMN_ITEM_CATEGORY_NAME_INDEX = 3;
        public static final int COLUMN_ITEM_IMAGE_URI_INDEX = 4;

        /**
         * Method that builds the relationship tables involved in the join.
         *
         * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance to set the Tables on
         */
        public static void setTables(SQLiteQueryBuilder queryBuilder) {
            String inTables = Product.TABLE_NAME + JOIN
                    + ProductCategory.TABLE_NAME + ON
                    + Product.getQualifiedColumnName(Product.COLUMN_ITEM_CATEGORY_ID)
                    + EQUALS
                    + ProductCategory.getQualifiedColumnName(ProductCategory._ID)
                    + LEFT_JOIN
                    + ProductImage.TABLE_NAME + ON
                    + Product.getQualifiedColumnName(Product._ID)
                    + EQUALS
                    + ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_ID);
            queryBuilder.setTables(inTables);
        }

        /**
         * Method that builds a map of Projection columns used in the Select clause
         * with the appropriate column qualifiers or aliases such that there is no ambiguity in the
         * column names
         *
         * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance
         *                     to set the ProjectionMap on.
         */
        public static void setProjectionMap(SQLiteQueryBuilder queryBuilder) {
            Map<String, String> columnMap = new HashMap<>();
            columnMap.put(Product.getQualifiedColumnName(Product._ID),
                    Product.getQualifiedColumnName(Product._ID));
            columnMap.put(Product.getQualifiedColumnName(Product.COLUMN_ITEM_NAME),
                    Product.getQualifiedColumnName(Product.COLUMN_ITEM_NAME));
            columnMap.put(Product.getQualifiedColumnName(Product.COLUMN_ITEM_SKU),
                    Product.getQualifiedColumnName(Product.COLUMN_ITEM_SKU));
            columnMap.put(ProductCategory.getQualifiedColumnName(ProductCategory.COLUMN_ITEM_CATEGORY_NAME),
                    ProductCategory.getQualifiedColumnName(ProductCategory.COLUMN_ITEM_CATEGORY_NAME));
            columnMap.put(ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_IMAGE_URI),
                    ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_IMAGE_URI));
            queryBuilder.setProjectionMap(columnMap);
        }

        /**
         * Method that returns the Columns for use in the Select clause of the query
         *
         * @return An Array of Strings which are the Columns to use in the Select clause
         * of the query
         */
        public static String[] getProjection() {
            return new String[]{
                    Product.getQualifiedColumnName(Product._ID),
                    Product.getQualifiedColumnName(Product.COLUMN_ITEM_NAME),
                    Product.getQualifiedColumnName(Product.COLUMN_ITEM_SKU),
                    ProductCategory.getQualifiedColumnName(ProductCategory.COLUMN_ITEM_CATEGORY_NAME),
                    ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_IMAGE_URI)
            };
        }

        /**
         * Method that returns the Where Clause of the query
         *
         * @return String containing the Where Clause required
         */
        public static String getSelection() {
            //Where clause is the 'item_image' table's 'is_default' column
            //(item_image.is_default is null or item_image.is_default = 1)
            return ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_IMAGE_DEFAULT) + IS + NULL +
                    OR + ProductImage.getQualifiedColumnName(ProductImage.COLUMN_ITEM_IMAGE_DEFAULT) + EQUALS + PLACEHOLDER;
        }

        /**
         * Method that returns the Where Clause arguments of the query
         *
         * @return An Array of Strings which are the Where Clause arguments of the query
         */
        public static String[] getSelectionArgs() {
            return new String[]{
                    //Where clause value is '1' that denotes the default image of the item
                    String.valueOf(ProductImage.ITEM_IMAGE_DEFAULT)
            };
        }

    }


    /**
     * Class that provides all the necessities
     * for building the query to retrieve the Id and Name of the Item
     * identified by the 'item_sku'
     * <p>
     * <pre>
     *     SELECT _id, item_name, item_sku
     *     FROM item
     *     WHERE item_sku = ?;
     * </pre>
     */
    public static final class ItemBySkuQuery {
        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_ITEM_ID_INDEX = 0;
        public static final int COLUMN_ITEM_NAME_INDEX = 1;
        public static final int COLUMN_ITEM_SKU_INDEX = 2;

        /**
         * Method that returns the Columns for use in the Select clause of the query
         *
         * @return An Array of Strings which are the Columns to use in the Select clause
         * of the query
         */
        public static String[] getProjection() {
            return new String[]{
                    Product._ID,
                    Product.COLUMN_ITEM_NAME,
                    Product.COLUMN_ITEM_SKU
            };
        }

        /**
         * Method that returns the Where Clause of the query
         *
         * @return String containing the Where Clause required
         */
        public static String getSelection() {
            //Where clause is only the 'item' table's item_sku column
            return Product.COLUMN_ITEM_SKU + EQUALS + PLACEHOLDER;
        }

        /**
         * Method that returns the Where Clause arguments of the query
         *
         * @param uri is the URI for the query
         * @return An Array of Strings which are the Where Clause arguments of the query
         */
        public static String[] getSelectionArgs(@NonNull Uri uri) {
            return new String[]{
                    //Where clause value is the 'item_sku' passed in the URI
                    uri.getLastPathSegment()
            };
        }
    }

    /**
     * Class that provides all the necessities
     * for building the query to retrieve the Supplier Name and Code
     * identified by the '_id'
     * <p>
     * <pre>
     *     SELECT _id, supplier_name, supplier_code
     *     FROM supplier
     *     WHERE _id = ?
     * </pre>
     */
    public static final class SupplierByIdQuery {
        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_SUPPLIER_ID_INDEX = 0;
        public static final int COLUMN_SUPPLIER_NAME_INDEX = 1;
        public static final int COLUMN_SUPPLIER_CODE_INDEX = 2;

        /**
         * Method that returns the Columns for use in the Select clause of the query
         *
         * @return An Array of Strings which are the Columns to use in the Select clause
         * of the query
         */
        public static String[] getProjection() {
            return new String[]{
                    Supplier._ID,
                    Supplier.COLUMN_SUPPLIER_NAME,
                    Supplier.COLUMN_SUPPLIER_CODE
            };
        }

        /**
         * Method that returns the Where Clause of the query
         *
         * @return String containing the Where Clause required
         */
        public static String getSelection() {
            //Where clause is only the 'supplier' table's _id column
            return Supplier._ID + EQUALS + PLACEHOLDER;
        }

        /**
         * Method that returns the Where Clause arguments of the query
         *
         * @param uri is the URI for the query
         * @return An Array of Strings which are the Where Clause arguments of the query
         */
        public static String[] getSelectionArgs(@NonNull Uri uri) {
            return new String[]{
                    //Where clause value is the '_id' passed in the URI
                    String.valueOf(ContentUris.parseId(uri))
            };
        }
    }

    /**
     * Class that provides all the necessities
     * for building the query to retrieve a Supplier's contacts
     * <p>
     * <pre>
     *     SELECT supplier._id, supplier_contact.contact_type_id,
     *     supplier_contact.contact_value, supplier_contact.is_default
     *     FROM supplier JOIN supplier_contact
     *     ON supplier_contact.supplier_id = supplier._id
     *     WHERE supplier._id = ?;
     * </pre>
     */
    public static final class SupplierContactsQuery {
        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_SUPPLIER_ID_INDEX = 0;
        public static final int COLUMN_SUPPLIER_CONTACT_TYPE_ID_INDEX = 1;
        public static final int COLUMN_SUPPLIER_CONTACT_VALUE_INDEX = 2;
        public static final int COLUMN_SUPPLIER_CONTACT_DEFAULT_INDEX = 3;

        /**
         * Method that builds the relationship tables involved in the join.
         *
         * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance to set the Tables on
         */
        public static void setTables(SQLiteQueryBuilder queryBuilder) {
            String inTables = Supplier.TABLE_NAME + JOIN
                    + SupplierContact.TABLE_NAME + ON
                    + SupplierContact.getQualifiedColumnName(SupplierContact.COLUMN_SUPPLIER_ID)
                    + EQUALS
                    + Supplier.getQualifiedColumnName(Supplier._ID);
            queryBuilder.setTables(inTables);
        }

        /**
         * Method that builds a map of Projection columns used in the Select clause
         * with the appropriate column qualifiers or aliases such that there is no ambiguity in the
         * column names
         *
         * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance
         *                     to set the ProjectionMap on.
         */
        public static void setProjectionMap(SQLiteQueryBuilder queryBuilder) {
            Map<String, String> columnMap = new HashMap<>();
            columnMap.put(Supplier.getQualifiedColumnName(Supplier._ID),
                    Supplier.getQualifiedColumnName(Supplier._ID));
            columnMap.put(SupplierContact.getQualifiedColumnName(SupplierContact.COLUMN_SUPPLIER_CONTACT_TYPE_ID),
                    SupplierContact.getQualifiedColumnName(SupplierContact.COLUMN_SUPPLIER_CONTACT_TYPE_ID));
            columnMap.put(SupplierContact.getQualifiedColumnName(SupplierContact.COLUMN_SUPPLIER_CONTACT_VALUE),
                    SupplierContact.getQualifiedColumnName(SupplierContact.COLUMN_SUPPLIER_CONTACT_VALUE));
            columnMap.put(SupplierContact.getQualifiedColumnName(SupplierContact.COLUMN_SUPPLIER_CONTACT_DEFAULT),
                    SupplierContact.getQualifiedColumnName(SupplierContact.COLUMN_SUPPLIER_CONTACT_DEFAULT));
            queryBuilder.setProjectionMap(columnMap);
        }

        /**
         * Method that returns the Columns for use in the Select clause of the query
         *
         * @return An Array of Strings which are the Columns to use in the Select clause
         * of the query
         */
        public static String[] getProjection() {
            return new String[]{
                    Supplier.getQualifiedColumnName(Supplier._ID),
                    SupplierContact.getQualifiedColumnName(SupplierContact.COLUMN_SUPPLIER_CONTACT_TYPE_ID),
                    SupplierContact.getQualifiedColumnName(SupplierContact.COLUMN_SUPPLIER_CONTACT_VALUE),
                    SupplierContact.getQualifiedColumnName(SupplierContact.COLUMN_SUPPLIER_CONTACT_DEFAULT)
            };
        }

        /**
         * Method that returns the Where Clause of the query
         *
         * @return String containing the Where Clause required
         */
        public static String getSelection() {
            //Where clause is only the 'supplier' table's _id column
            return Supplier.getQualifiedColumnName(Supplier._ID) + EQUALS + PLACEHOLDER;
        }

        /**
         * Method that returns the Where Clause arguments of the query
         *
         * @param uri is the URI for the query
         * @return An Array of Strings which are the Where Clause arguments of the query
         */
        public static String[] getSelectionArgs(@NonNull Uri uri) {
            return new String[]{
                    //Where clause value is the '_id' passed in the URI
                    String.valueOf(ContentUris.parseId(uri))
            };
        }
    }


    /**
     * Class that provides all the necessities
     * for building the query to retrieve Items sold by the Supplier
     * <p>
     * <pre>
     *     SELECT supplier_id, item_id, unit_price
     *     FROM item_supplier_info
     *     WHERE supplier_id = ?;
     * </pre>
     */
    public static final class SupplierItemsQuery {
        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_SUPPLIER_ID_INDEX = 0;
        public static final int COLUMN_ITEM_ID_INDEX = 1;
        public static final int COLUMN_ITEM_UNIT_PRICE_INDEX = 2;

        /**
         * Method that returns the Columns for use in the Select clause of the query
         *
         * @return An Array of Strings which are the Columns to use in the Select clause
         * of the query
         */
        public static String[] getProjection() {
            return new String[]{
                    ProductSupplierInfo.COLUMN_SUPPLIER_ID,
                    ProductSupplierInfo.COLUMN_ITEM_ID,
                    ProductSupplierInfo.COLUMN_ITEM_UNIT_PRICE
            };
        }

        /**
         * Method that returns the Where Clause of the query
         *
         * @return String containing the Where Clause required
         */
        public static String getSelection() {
            //Where clause is only the 'item_supplier_info' table's supplier_id column
            return ProductSupplierInfo.COLUMN_SUPPLIER_ID + EQUALS + PLACEHOLDER;
        }

        /**
         * Method that returns the Where Clause arguments of the query
         *
         * @param uri is the URI for the query
         * @return An Array of Strings which are the Where Clause arguments of the query
         */
        public static String[] getSelectionArgs(@NonNull Uri uri) {
            return new String[]{
                    //Where clause value is the 'supplier_id' passed in the URI
                    String.valueOf(ContentUris.parseId(uri))
            };
        }
    }

    /**
     * Class that provides all the necessities
     * for building the query to retrieve the Supplier Id and Name
     * identified by the 'supplier_code'
     * <p>
     * <pre>
     *     SELECT _id, supplier_name, supplier_code
     *     FROM supplier
     *     WHERE supplier_code = ?
     * </pre>
     */
    public static final class SupplierByCodeQuery {
        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_SUPPLIER_ID_INDEX = 0;
        public static final int COLUMN_SUPPLIER_NAME_INDEX = 1;
        public static final int COLUMN_SUPPLIER_CODE_INDEX = 2;

        /**
         * Method that returns the Columns for use in the Select clause of the query
         *
         * @return An Array of Strings which are the Columns to use in the Select clause
         * of the query
         */
        public static String[] getProjection() {
            return new String[]{
                    Supplier._ID,
                    Supplier.COLUMN_SUPPLIER_NAME,
                    Supplier.COLUMN_SUPPLIER_CODE
            };
        }

        /**
         * Method that returns the Where Clause of the query
         *
         * @return String containing the Where Clause required
         */
        public static String getSelection() {
            //Where clause is only the 'supplier' table's 'supplier_code' column
            return Supplier.COLUMN_SUPPLIER_CODE + EQUALS + PLACEHOLDER;
        }

        /**
         * Method that returns the Where Clause arguments of the query
         *
         * @param uri is the URI for the query
         * @return An Array of Strings which are the Where Clause arguments of the query
         */
        public static String[] getSelectionArgs(@NonNull Uri uri) {
            return new String[]{
                    //Where clause value is the 'supplier_code' passed in the URI
                    uri.getLastPathSegment()
            };
        }
    }

    /**
     * Class that provides all the necessities
     * for building the query to retrieve and display the Sales data
     * for all the Products in the Store.
     * <p>
     * <pre>
     *     SELECT item_supplier_inventory.item_id, item_supplier_inventory.supplier_id, item.item_name, item.item_sku,
     *     item_category.category_name, item_image.image_uri,
     *     supplier.supplier_name, supplier.supplier_code,
     *     item_supplier_info.unit_price,
     *     item_supplier_inventory.available_quantity AS supplier_available_quantity,
     *     (SELECT sum(available_quantity) AS total_available_quantity
     *     FROM item_supplier_inventory
     *     WHERE item_supplier_inventory.item_id = item._id) AS total_available_quantity
     *     FROM item JOIN item_category
     *     ON item.category_id = item_category._id
     *     LEFT JOIN item_image
     *     ON item_image.item_id = item._id
     *     JOIN item_supplier_info
     *     ON item_supplier_info.item_id = item._id
     *     JOIN item_supplier_inventory
     *     ON item_supplier_inventory.item_id = item._id
     *     JOIN supplier
     *     ON supplier._id = item_supplier_inventory.supplier_id
     *     WHERE (item_image.is_default IS NULL OR item_image.is_default = 1)
     *     AND item_supplier_inventory.supplier_id = (
     *     SELECT supplier._id
     *     FROM supplier JOIN item_supplier_inventory
     *     ON item_supplier_inventory.supplier_id = supplier._id
     *     WHERE item_supplier_inventory.item_id = item._id
     *     ORDER BY item_supplier_inventory.available_quantity DESC
     *     LIMIT 1)
     *     AND item_supplier_info.supplier_id = item_supplier_inventory.supplier_id;
     * </pre>
     */
    public static final class SalesShortInfoQuery{
        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_ITEM_ID_INDEX = 0;
        public static final int COLUMN_SUPPLIER_ID_INDEX = 1;
        public static final int COLUMN_ITEM_NAME_INDEX = 2;
        public static final int COLUMN_ITEM_SKU_INDEX = 3;
        public static final int COLUMN_ITEM_CATEGORY_NAME_INDEX = 4;
        public static final int COLUMN_ITEM_IMAGE_URI_INDEX = 5;
        public static final int COLUMN_SUPPLIER_NAME_INDEX = 6;
        public static final int COLUMN_SUPPLIER_CODE_INDEX = 7;
        public static final int COLUMN_ITEM_UNIT_PRICE_INDEX = 8;
        public static final int COLUMN_SUPPLIER_AVAIL_QUANTITY_INDEX = 9;
        public static final int COLUMN_TOTAL_AVAIL_QUANTITY_INDEX = 10;
        //Column Name constants for the custom columns
        private static final String COLUMN_SUPPLIER_AVAIL_QUANTITY = "supplier_available_quantity";
        private static final String COLUMN_TOTAL_AVAIL_QUANTITY = "total_available_quantity";
    }

    /**
     * Class that provides all the necessities
     * for building the query to retrieve the Suppliers' Inventory and Price
     * data for a given Item identified by its '_id'.
     * <p>
     * <pre>
     *     SELECT item_supplier_info.item_id, item_supplier_info.supplier_id,
     *     supplier.supplier_name, supplier.supplier_code, item_supplier_info.unit_price,
     *     item_supplier_inventory.available_quantity
     *     FROM supplier JOIN item_supplier_info ON
     *     item_supplier_info.supplier_id = supplier._id
     *     JOIN item_supplier_inventory ON
     *     item_supplier_inventory.supplier_id = item_supplier_info.supplier_id
     *     WHERE item_supplier_inventory.item_id = item_supplier_info.item_id
     *     AND item_supplier_info.item_id = ?
     * </pre>
     */
    public static final class ItemSuppliersSalesQuery {
        //Constants of Column Index as they would appear in the Select clause
        public static final int COLUMN_ITEM_ID_INDEX = 0;
        public static final int COLUMN_SUPPLIER_ID_INDEX = 1;
        public static final int COLUMN_SUPPLIER_NAME_INDEX = 2;
        public static final int COLUMN_SUPPLIER_CODE_INDEX = 3;
        public static final int COLUMN_ITEM_UNIT_PRICE_INDEX = 4;
        public static final int COLUMN_AVAIL_QUANTITY_INDEX = 5;

        /**
         * Method that builds the relationship tables involved in the join.
         *
         * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance to set the Tables on
         */
        public static void setTables(SQLiteQueryBuilder queryBuilder) {
            String inTables = Supplier.TABLE_NAME
                    + JOIN + ProductSupplierInfo.TABLE_NAME + ON
                    + ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_SUPPLIER_ID)
                    + EQUALS + Supplier.getQualifiedColumnName(Supplier._ID)
                    + JOIN + ProductSupplierInventory.TABLE_NAME + ON
                    + ProductSupplierInventory.getQualifiedColumnName(ProductSupplierInventory.COLUMN_SUPPLIER_ID)
                    + EQUALS + ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_SUPPLIER_ID);
            queryBuilder.setTables(inTables);
        }

        /**
         * Method that builds a map of Projection columns used in the Select clause
         * with the appropriate column qualifiers or aliases such that there is no ambiguity in the
         * column names
         *
         * @param queryBuilder Query Builder {@link SQLiteQueryBuilder} instance
         *                     to set the ProjectionMap on.
         */
        public static void setProjectionMap(SQLiteQueryBuilder queryBuilder) {
            Map<String, String> columnMap = new HashMap<>();
            columnMap.put(ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_ITEM_ID),
                    ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_ITEM_ID));
            columnMap.put(ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_SUPPLIER_ID),
                    ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_SUPPLIER_ID));
            columnMap.put(Supplier.getQualifiedColumnName(Supplier.COLUMN_SUPPLIER_NAME),
                    Supplier.getQualifiedColumnName(Supplier.COLUMN_SUPPLIER_NAME));
            columnMap.put(Supplier.getQualifiedColumnName(Supplier.COLUMN_SUPPLIER_CODE),
                    Supplier.getQualifiedColumnName(Supplier.COLUMN_SUPPLIER_CODE));
            columnMap.put(ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_ITEM_UNIT_PRICE),
                    ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_ITEM_UNIT_PRICE));
            columnMap.put(ProductSupplierInventory.getQualifiedColumnName(ProductSupplierInventory.COLUMN_ITEM_AVAIL_QUANTITY),
                    ProductSupplierInventory.getQualifiedColumnName(ProductSupplierInventory.COLUMN_ITEM_AVAIL_QUANTITY));
            queryBuilder.setProjectionMap(columnMap);
        }

        /**
         * Method that returns the Columns for use in the Select clause of the query
         *
         * @return An Array of Strings which are the Columns to use in the Select clause
         * of the query
         */
        public static String[] getProjection() {
            return new String[]{
                    ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_ITEM_ID),
                    ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_SUPPLIER_ID),
                    Supplier.getQualifiedColumnName(Supplier.COLUMN_SUPPLIER_NAME),
                    Supplier.getQualifiedColumnName(Supplier.COLUMN_SUPPLIER_CODE),
                    ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_ITEM_UNIT_PRICE),
                    ProductSupplierInventory.getQualifiedColumnName(ProductSupplierInventory.COLUMN_ITEM_AVAIL_QUANTITY)
            };
        }

        /**
         * Method that returns the Where Clause of the query
         *
         * @return String containing the Where Clause required
         */
        public static String getSelection() {
            return ProductSupplierInventory.getQualifiedColumnName(ProductSupplierInventory.COLUMN_ITEM_ID)
                    + EQUALS + ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_ITEM_ID)
                    + AND + ProductSupplierInfo.getQualifiedColumnName(ProductSupplierInfo.COLUMN_ITEM_ID)
                    + EQUALS + PLACEHOLDER;
        }

        /**
         * Method that returns the Where Clause arguments of the query
         *
         * @param uri is the URI for the query
         * @return An Array of Strings which are the Where Clause arguments of the query
         */
        public static String[] getSelectionArgs(@NonNull Uri uri) {
            return new String[]{
                    //Where clause value is the 'item_id' passed in the URI
                    String.valueOf(ContentUris.parseId(uri))
            };
        }
    }

}