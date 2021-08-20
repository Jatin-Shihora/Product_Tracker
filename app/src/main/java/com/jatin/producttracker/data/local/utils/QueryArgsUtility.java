package com.jatin.producttracker.data.local.utils;

public class QueryArgsUtility {

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
