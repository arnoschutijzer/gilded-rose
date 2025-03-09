package com.gildedrose;

public class BackstagePassToATAFKAL80ETCConcert {
    BackstagePassToATAFKAL80ETCConcert() {
    }

    public static int depreciationValue(Item item) {
        if (item.quality == 50) {
            return 0;
        }
        if (item.sellIn <= 0) {
            return item.quality;
        }
        if (item.sellIn < 5) {
            return -3;
        }
        if (item.sellIn < 10) {
            return -2;
        }
        return -1;
    }
}
