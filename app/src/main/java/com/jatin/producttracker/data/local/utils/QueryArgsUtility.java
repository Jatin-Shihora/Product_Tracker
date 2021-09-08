package com.jatin.producttracker.data.local.utils;

/**
 * Utility class that provides Static inner classes with methods
 * for generating queries required in the App.
 *
 * @author Jatin C Shihora
 */
public class QueryArgsUtility {

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
}