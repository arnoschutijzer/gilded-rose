package com.gildedrose;

public class RegularItem {
    RegularItem() {
    }

    public static int depreciationValue(Item item) {
        if (item.sellIn < 0 && item.quality > 0) {
            return 2;
        }

        return 1;
    }
}
