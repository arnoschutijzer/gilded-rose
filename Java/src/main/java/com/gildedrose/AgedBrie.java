package com.gildedrose;

public class AgedBrie {
    AgedBrie() {
    }

    public static int depreciationValue(Item item) {
        if (item.quality == 50) {
            return 0;
        }
        if (item.sellIn < 0) {
            return -2;
        }
        return -1;
    }
}
